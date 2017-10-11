package assignment3_CIR.app;

import java.io.File;
import java.util.List;

import org.json.JSONObject;
import assignment3_CIR.app.DataObj;

public class DataManager {

	private static final DataObj DataObj = null;

	public DataManager() {

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

	public static DataObj listCitedDocumentsByYears(String conference, File homeDirectory, List<Integer> rangeYears) {
		return DataObj;
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
}
