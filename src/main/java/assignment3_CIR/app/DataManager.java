package assignment3_CIR.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataManager {

	private static final String DATASETPATH = "C:\\Users\\User\\my-app\\papers-2017-02-21-sample.json\\papers-2017-02-21-sample.json";
	private static final String CITED_DOCUMENTS = "cited_documents";
	private static final String CITATIONS = "citations";
	private static final String DOCUMENTS = "documents";
	private static final String AUTHORS = "authors";
	private static final String UNIQUE_CITATIONS = "unique_citations";
	// private static final int PRETTY_PRINT_INDENT_FACTOR = 4;

	private Input inputObj;
	private ArrayList<JSONObject> dataset = new ArrayList<JSONObject>();

	public DataManager(Input input) throws IOException {
		this.setInputObj(input);
		parseJSONFileIntoObjArrList();
		execute();
	}

	private void parseJSONFileIntoObjArrList() throws IOException {
		File f = new File(DATASETPATH);
		if (f.exists()) {
			InputStream is = new FileInputStream(DATASETPATH);
			ArrayList<String> jsonTxt = (ArrayList<String>) IOUtils.readLines(is, "UTF-8");
			for (String i : jsonTxt) {
				JSONObject jo = new JSONObject(i);
				//FileManager.jsonToTxtFile(jo, "data"+ jsonTxt.indexOf(i) + ".json");
				dataset.add(jo);
			}
		}
		System.out.println("Number of JSONObjects in dataset is: " + dataset.size());
	}

	public static String readFile() {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(DATASETPATH));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private void execute() {
		// TODO Auto-generated method stub
		String queryCommand = inputObj.getQueryCommand();
		String queryType = inputObj.getQueryType();
		
		if (queryCommand.equalsIgnoreCase("count")) {
			switch (queryType) {
			case DOCUMENTS :
				break;
			case CITATIONS : 
				break;
			case CITED_DOCUMENTS :
				break;
			case AUTHORS :
				break;
			case UNIQUE_CITATIONS :
				break;
			default :
				break;
				
			}
		} else if (queryCommand.equalsIgnoreCase("select")) {
			switch (queryType) {
			case DOCUMENTS :
				break;
			case CITATIONS : 
				break;
			case CITED_DOCUMENTS :
				break;
			case AUTHORS :
				break;
			case UNIQUE_CITATIONS :
				break;
			default :
				break;
				
			}
		} else {
			// do nothing
		}
		
		System.out.println("Data manager executed task successfully");
	}

	public static int countCitations(JSONObject testObj) {
		int lengthOfObj = 0;
		JSONObject ob1 = testObj.getJSONObject("algorithms");
		org.json.JSONArray ar2 = ob1.getJSONArray("algorithm");
		JSONObject ob3 = (JSONObject) ar2.get(2);
		JSONObject ob4 = ob3.getJSONObject("citationList");
		org.json.JSONArray ob5 = ob4.getJSONArray("citation");
		for (int i = 0; i < ob5.length(); i++) {
			// String validString = ob5.getJSONObject(i).has("valid");
			if (ob5.getJSONObject(i).has("valid")) {
				lengthOfObj++;
			}
		}
		return lengthOfObj;
	}

	/*
	 * public static DataObj listCitedDocumentsByYears(String conference, File
	 * homeDirectory, List<Integer> rangeYears) { return DataObj; }
	 */
	public static int citedDocuments(JSONObject testObj, int year) {
		int citedDocuments = 0;
		int date;
		JSONObject ob1 = testObj.getJSONObject("algorithms");
		org.json.JSONArray ar2 = ob1.getJSONArray("algorithm");
		JSONObject ob3 = (JSONObject) ar2.get(2);
		JSONObject ob4 = ob3.getJSONObject("citationList");
		org.json.JSONArray ar5 = ob4.getJSONArray("citation");
		System.out.println(ar5.toString());
		for (int i = 0; i < ar5.length(); i++) {
			if (ar5.getJSONObject(i).getBoolean("valid")) {
				JSONObject ob6 = (JSONObject) ar5.getJSONObject(i);
				date = ob6.getInt("date");
				System.out.println(date);
				// int datedYear = Integer.parseInt(date);
				if (date == year) {
					citedDocuments++;
				}
				System.out.println(date + "has cited documents");
			}
		}
		return citedDocuments;
	}

	public Input getInputObj() {
		return inputObj;
	}

	public void setInputObj(Input inputObj) {
		this.inputObj = inputObj;
	}
}
