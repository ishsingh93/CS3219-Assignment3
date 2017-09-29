package assignment3_CIR.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class App {
	

	public static void main(String[] args) throws IOException {
		
		int fileCount = FileManager.fileCounter(Paths.get("dataset"));
		System.out.println("Total number of files in D12 is: " + fileCount);
		
		File testCount = new File("C:\\Users\\User\\my-app\\dataset");
		int totalFiles = FileManager.getTotalFilesCount(testCount);
		System.out.println("Total number of files: " + totalFiles);
				
	}

	
	
}