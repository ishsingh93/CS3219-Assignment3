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
	

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		UI uiMod = new UI();
		uiMod.run();
	}

	/*		String folderName = "D12";
	int fileCount = FileManager.fileCounter(Paths.get("dataset"), folderName);
	System.out.println("Total number of files in D12 is: " + fileCount);
	
	File testCount = new File("C:\\Users\\User\\my-app\\dataset");
	int totalFiles = FileManager.getTotalFilesCount(testCount);
	System.out.println("Total number of files: " + totalFiles);
	
	JSONObject testObj = FileManager.xmlToJSON("dataset/D12/D/D12/D12-1000-parscit.130908.xml");
//	FileManager.jsonToTxtFile(testObj, "1000.json");
	
	//FileManager.getAuthorsFromJSONObj(testObj);
	int citdocs = DataManager.citedDocuments(testObj, 2012);
	System.out.println(citdocs);
*/

	
	
}