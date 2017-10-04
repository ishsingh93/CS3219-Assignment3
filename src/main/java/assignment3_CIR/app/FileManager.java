package assignment3_CIR.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class FileManager {

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
	public static String TEST_XML_STRING = null;

	public FileManager() {

	}

	public static JSONObject xmlToJSON(String fileName)
			throws FileNotFoundException, IOException, UnsupportedEncodingException {
		File file = new File(fileName);
		FileInputStream fin = new FileInputStream(file);
		byte[] xmlData = new byte[(int) file.length()];
		fin.read(xmlData);
		fin.close();
		TEST_XML_STRING = new String(xmlData, "UTF-8");
		JSONObject xmlJSONObj = new JSONObject();

		try {
			xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
		} catch (JSONException e) {
			System.out.println(e.toString());
		}

		return xmlJSONObj;
	}

	public static void jsonToTxtFile(JSONObject xmlJSONObj, String outputFileName) throws IOException {
		try (FileWriter outputFile = new FileWriter(outputFileName)) {
			outputFile.write(xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR));
			System.out.println("Successfully Copied JSON Object to File...");
			//System.out.println("\nJSON Object: " + xmlJSONObj);
		}
	}

	public static int fileCounter(Path dir, String folderName) throws IOException, NotDirectoryException {
		int c = 0;
		Path fullPath = Paths.get("C:\\Users\\User\\my-app\\" + dir.toString() + "\\" + folderName + "\\" + folderName.substring(0, 1) + "\\" + folderName);
		System.out.println(fullPath.toString());
		if (Files.isDirectory(fullPath)) {
			try (DirectoryStream<Path> files = Files.newDirectoryStream(fullPath)) {
				for (Path file : files) {
					if (Files.isRegularFile(file) || Files.isSymbolicLink(file)) {
						// symbolic link also looks like file
						c++;
					}
				}
			}
		} else
			throw new NotDirectoryException(dir + " is not directory");

		return c;
	}

	public static int getTotalFilesCount(File file) {
		File[] files = file.listFiles();
		int count = 0;
		for (File f : files)
			if (f.isDirectory())
				count += getTotalFilesCount(f);
			else
				count++;

		return count;
	}
	
	public static void getAuthorsFromJSONObj(JSONObject testObj) {
		JSONObject ob1 = testObj.getJSONObject("algorithms");
//		int i = ob1.getInt("version");
		org.json.JSONArray ar2 = ob1.getJSONArray("algorithm");
//		System.out.println(ar2.get(0));
		JSONObject ob3 = (JSONObject) ar2.get(0);
//		System.out.println(ob3.getString("name"));
		JSONObject ob4 = ob3.getJSONObject("variant");
//		System.out.println(ob4.getInt("no"));
		JSONObject ob5 = ob4.getJSONObject("author");
		System.out.println(ob5.getString("content"));
//		System.out.println("Done");
//		System.out.println(i);
	}

}
