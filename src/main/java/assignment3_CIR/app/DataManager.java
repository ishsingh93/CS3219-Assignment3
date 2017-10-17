package assignment3_CIR.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
public class DataManager {

	private static final String NAME = "name";
	private static final String VENUE = "venue";
	// please change directory to your own localised directory
	// Location of Ish's directory -> C:\\Users\\User\\my-app\\papers-2017-02-21-sample.json\\sample5papers.json
	// Location of Javan's directory -> D:\CS3219-Assignment3\papers-2017-02-21-sample.json\\papers-2017-02-21-sample.json
	private static final String CITED_DOCUMENTS = "cited_documents";
	private static final String CITATIONS = "citations";
	private static final String DOCUMENTS = "documents";
	private static final String AUTHORS = "authors";
	private static final String UNIQUE_CITATIONS = "unique_citations";
//	private static final int PRETTY_PRINT_INDENT_FACTOR = 4;

	private Input inputObj;
	private ArrayList<JSONObject> dataset = new ArrayList<JSONObject>();

	public DataManager(Input input) throws IOException {
		this.setInputObj(input);
		parseJSONFileIntoObjArrList();
		execute();
	}

	private void parseJSONFileIntoObjArrList() throws IOException {
		File f = new File(inputObj.getDataLocation());
		if (f.exists()) {
			InputStream is = new FileInputStream(inputObj.getDataLocation());
			ArrayList<String> jsonTxt = (ArrayList<String>) IOUtils.readLines(is, "UTF-8");
			for (String i : jsonTxt) {
				JSONObject jo = new JSONObject(i);
				//FileManager.jsonToTxtFile(jo, "data"+ jsonTxt.indexOf(i) + ".json");
				dataset.add(jo);
			}
		}
		System.out.println("Number of JSONObjects in dataset is: " + dataset.size());
	}

/*	public static String readFile() {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputObj.getDataLocation()));
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
*/
	private void execute() {
		// TODO Auto-generated method stub
		String queryCommand = inputObj.getQueryCommand();
		String queryType = inputObj.getQueryType();
		
		if (queryCommand.equalsIgnoreCase("count")) {
			switch (queryType) {
			case DOCUMENTS :
				break;
			case CITATIONS : 
				int numCitations = countInCitations(dataset);
				System.out.println("Total number of citations in the dataset is: " + numCitations);
				break;
			case CITED_DOCUMENTS :
				break;
			case AUTHORS :
				int authors = countAuthors(dataset);
				System.out.println("Number of authors: " + authors);
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

	public static int countInCitations(ArrayList<JSONObject> dataset) {
		int numCitations = 0;
		for (int i = 0; i < dataset.size(); i++) {
			JSONArray inCitArr = dataset.get(i).getJSONArray("inCitations");
			numCitations = numCitations + inCitArr.length();
		}
		return numCitations;
	}
	
	public static int countOutCitations(ArrayList<JSONObject> dataset) {
		int numCitations = 0;
		for (int i = 0; i < dataset.size(); i++) {
			JSONArray outCitArr = dataset.get(i).getJSONArray("outCitations");
			numCitations = numCitations + outCitArr.length();
		}
		return numCitations;
	}
	
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
	
	public static int countAuthors(ArrayList<JSONObject> datasets) {
		int authorCount = 0;
		List<String> listAuthors = new ArrayList<String>();
		for (int i=0; i< datasets.size(); i++) {
			if (datasets.get(i).has("authors")) {
				System.out.println("yass there's authors at data " + i);
				JSONArray authorsArray = datasets.get(i).getJSONArray("authors");
				//System.out.println(authorsArray.toString());
				for (int j=0; j< authorsArray.length(); j++) {
					JSONObject element = authorsArray.getJSONObject(j);
					//System.out.println(element.toString());
					if (element.has(NAME)) {
						String nameString = element.getString(NAME);
						System.out.println(nameString);
						listAuthors.add(nameString);
					}
				}
					
			}
		}
		Set<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		set.addAll(listAuthors);
		listAuthors = new ArrayList<String>(set);
		authorCount = listAuthors.size();
		return authorCount;
	}

	
	public ArrayList<String> getTopAuthors(int numTop, String ven) {
		int initCount = 0; 
		ArrayList<AuthorObj> aoArr = new ArrayList<AuthorObj>();
		for (JSONObject jo : dataset) {
			if (jo.getString(VENUE).equalsIgnoreCase(ven)) {
				JSONArray authorArr = jo.getJSONArray(AUTHORS);
				for (int j = 0; j < authorArr.length(); j++) {
					JSONObject author = authorArr.getJSONObject(j);  
					String authorName = author.getString(NAME);
					if (aoArrHasAuthor(authorName, aoArr)) {
						incrementAuthorCount(authorName, aoArr);
					} else {
						AuthorObj newAuthor = new AuthorObj();
						newAuthor.setAuthorName(authorName);
						newAuthor.setCount(1);
						aoArr.add(newAuthor);
					}
				}
			}
		}
		
		sortArrListDescending(aoArr);
		ArrayList<String> nameArr = extractAuthorNamesFromAoArr(aoArr, numTop);
		return nameArr;
		
	}
	
	
	private ArrayList<String> extractAuthorNamesFromAoArr(ArrayList<AuthorObj> aoArr, int numTop) {
		// TODO Auto-generated method stub
		return null;
	}

	private void sortArrListDescending(ArrayList<AuthorObj> aoArr) {
		for (AuthorObj ao : aoArr) {
			
		}
		
	}

	private void incrementAuthorCount(String authorName, ArrayList<AuthorObj> aoArr) {
		for (AuthorObj ao : aoArr) {
			if (ao.getAuthorName().equalsIgnoreCase(authorName)) {
				ao.setCount(ao.getCount() + 1);
			}
		}
	}

	private boolean aoArrHasAuthor(String authorName, ArrayList<AuthorObj> aoArr) {
		boolean hasAuthor = false;
		for (AuthorObj ao : aoArr) {
			if (ao.getAuthorName().equalsIgnoreCase(authorName)) {
				hasAuthor = true;
			} else {
				hasAuthor = false;
			}
		}
		return hasAuthor;
	}

	public Input getInputObj() {
		return inputObj;
	}

	public void setInputObj(Input inputObj) {
		this.inputObj = inputObj;
	}
}
