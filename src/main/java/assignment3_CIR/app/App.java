package assignment3_CIR.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
	

	public static void main(String[] args) throws IOException {
		
		String folderName = "D12";
		int fileCount = FileManager.fileCounter(Paths.get("dataset"), folderName);
		System.out.println("Total number of files in D12 is: " + fileCount);
		
		File testCount = new File("C:\\Users\\User\\my-app\\dataset");
		int totalFiles = FileManager.getTotalFilesCount(testCount);
		System.out.println("Total number of files: " + totalFiles);
		
		JSONObject testObj = FileManager.xmlToJSON("dataset/D12/D/D12/D12-1123-parscit.130908.xml");
//		FileManager.jsonToTxtFile(testObj, "1123.json");
		
/*        JSONParser parser = new JSONParser();
        try {
			Object object = parser.parse(new FileReader("1124.json"));
			JSONObject jsonObject = (JSONObject) object;
			JSONObject ob1 = jsonObject.getJSONObject("algorithms");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		FileManager.getAuthorsFromJSONObj(testObj);
				
	}

	

	
	
}