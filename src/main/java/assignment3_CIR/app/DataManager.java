package assignment3_CIR.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
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
	// Location of Ish's directory ->
	// C:\\Users\\User\\my-app\\papers-2017-02-21-sample.json\\sample5papers.json
	// Location of Javan's directory ->
	// D:\CS3219-Assignment3\papers-2017-02-21-sample.json\sample5papers.json
	private static final String CITED_DOCUMENTS = "cited_documents";
	private static final String CITATIONS = "citations";
	private static final String DOCUMENTS = "documents";
	private static final String AUTHORS = "authors";
	private static final String TOP_AUTHORS = "top 10 authors";
	private static final String UNIQUE_CITATIONS = "unique_citations";
	private static final String PUBLICATIONS = "publications";
	private static final String TOP = "top";
	// private static final int PRETTY_PRINT_INDENT_FACTOR = 4;

	private Input inputObj;
	private ArrayList<JSONObject> dataset = new ArrayList<JSONObject>();
	private static Output output = new Output();

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
				// FileManager.jsonToTxtFile(jo, "data"+ jsonTxt.indexOf(i) + ".json");
				dataset.add(jo);
			}
		}
		System.out.println("Number of JSONObjects in dataset is: " + dataset.size());
	}

	/*
	 * public static String readFile() { String result = ""; try { BufferedReader br
	 * = new BufferedReader(new FileReader(inputObj.getDataLocation()));
	 * StringBuilder sb = new StringBuilder(); String line = br.readLine(); while
	 * (line != null) { sb.append(line); line = br.readLine(); } result =
	 * sb.toString(); } catch (Exception e) { e.printStackTrace(); } return result;
	 * }
	 */
	private void execute() {
		// TODO Auto-generated method stub
		String queryCommand = inputObj.getQueryCommand();
		String queryType = inputObj.getQueryType();
		String venue = inputObj.getVenue();
		String[] query = queryType.split(" ");
/*		
		System.out.print("queryType once split is: ");
		for (String i : query) {
			System.out.print(i + ", ");
		}
*/
		if (queryCommand.equalsIgnoreCase("count")) {
			switch (queryType) {
			case DOCUMENTS:
				ArrayList<PublicationObj> topPapers = getTopPapers(dataset, venue, 5);
				printTopPapers(topPapers);
				break;
			case CITATIONS:
				int numCitations = countInCitations(dataset);
				System.out.println("Total number of citations in the dataset is: " + numCitations);
				break;
			case CITED_DOCUMENTS:
				break;
			case AUTHORS:
				ArrayList<String> topAuthors = getTopAuthors(5, venue);
				for (int topAuthorSize = 0; topAuthorSize < 5; topAuthorSize++) {
					System.out.println(topAuthors.get(topAuthorSize));
				}
				break;
			case TOP_AUTHORS:
				ArrayList<String> top10Authors = getTopAuthors(10, venue);
				for (int topAuthorSize = 0; topAuthorSize < 10; topAuthorSize++) {
					System.out.println(top10Authors.get(topAuthorSize));
				}
				break;
			case UNIQUE_CITATIONS:
				break;
			case PUBLICATIONS:
				ArrayList<PubTrendObj> publicationsPerYear = publicationTrend(dataset, "");
				printPubTrend(publicationsPerYear);
				break;
			default:
				break;

			}
		} else if (queryCommand.equalsIgnoreCase("select")) {
			switch (queryType) {
			case DOCUMENTS:
				break;
			case CITATIONS:
				break;
			case CITED_DOCUMENTS:
				break;
			case AUTHORS:
				break;
			case UNIQUE_CITATIONS:
				break;
			default:
				break;

			}
		} else {
			// do nothing
		}

		System.out.println("Data manager executed task successfully");
	}

	private void printPubTrend(ArrayList<PubTrendObj> publicationsPerYear) {
		System.out.println("Trend of publications " + publicationsPerYear.size());
		for (int limits = 0; limits < publicationsPerYear.size(); limits++) {
			System.out.println(publicationsPerYear.get(limits).getPublicationsCount() + " times " + " : Published in "
					+ publicationsPerYear.get(limits).getPublishedYear());
		}
	}

	private void printTopPapers(ArrayList<PublicationObj> topPapers) {
		System.out.println("Top 5 Papers of dataset " + topPapers.size());
		for (int limit = 0; limit < 5; limit++) {
			System.out.println(topPapers.get(limit).getPublicationTitle() + " : "
					+ topPapers.get(limit).getPubCount() + " times");
		}
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
		for (int i = 0; i < datasets.size(); i++) {
			if (datasets.get(i).has("authors")) {
				// System.out.println("yass there's authors at data " + i);
				JSONArray authorsArray = datasets.get(i).getJSONArray("authors");
				// System.out.println(authorsArray.toString());
				for (int j = 0; j < authorsArray.length(); j++) {
					JSONObject element = authorsArray.getJSONObject(j);
					// System.out.println(element.toString());
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
		System.out.println("numtop = " + numTop);
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
		/*
		 * for (int b=0; b < aoArr.size(); b++) {
		 * System.out.println(aoArr.get(b).getAuthorName() + " has " +
		 * aoArr.get(b).getCount() + " publications."); }
		 */
		//output.writeCSVFile("authors", aoArr, numTop);
		ArrayList<String> nameArr = extractAuthorNamesFromAoArr(aoArr, numTop);
		return nameArr;
	}

	private ArrayList<String> extractAuthorNamesFromAoArr(ArrayList<AuthorObj> aoArr, int numTop) {
		ArrayList<String> topAuthArr = new ArrayList<String>();
		if (!aoArr.isEmpty()) {
			for (int authIndex = 0; authIndex < numTop; authIndex++) {
				String topAuthor = aoArr.get(authIndex).getAuthorName();
				topAuthArr.add(topAuthor);
			}
		}
		return topAuthArr;
	}

	private void sortArrListDescending(ArrayList<AuthorObj> aoArr) {
		Collections.sort(aoArr, AuthorObj.authorCount);
	}

	private void incrementAuthorCount(String authorName, ArrayList<AuthorObj> aoArr) {
		for (AuthorObj ao : aoArr) {
			if (ao.getAuthorName().equalsIgnoreCase(authorName)) {
				ao.setCount(ao.getCount() + 1);
				System.out.println("duplicate found : " + ao.getAuthorName());
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

	public static ArrayList<PublicationObj> getTopPapers(ArrayList<JSONObject> dataset, String venue, int noOfTopPapers) {
		ArrayList<PublicationObj> publicationList = new ArrayList<PublicationObj>();
		for (JSONObject dataInJson : dataset) {
			String getVenue = getVenue(dataInJson);
			if (venue.equalsIgnoreCase(getVenue)) {
				String paperTitle = dataInJson.getString("title");
				JSONArray inCitArray = dataInJson.getJSONArray("inCitations");
				PublicationObj pubObject = new PublicationObj(paperTitle);
				// System.out.println(pubObject.getPublicationTitle());
				int inCitCount = inCitArray.length();
				pubObject.setPubCount(inCitCount);
				publicationList.add(pubObject);
			}
		}
		// System.out.println(publicationList.size());
		sortTopPapers(publicationList, "top papers");
		System.out.println("sorted");
		output.writeCSVFile2("publications", publicationList, noOfTopPapers);
		System.out.println("output to csv");
		return publicationList;
	}

	private static void sortTopPapers(ArrayList<PublicationObj> publicationList, String sortType) {
		if (sortType.equals("top papers")) {
			Collections.sort(publicationList, PublicationObj.pubCounter);
		} else if (sortType.equals("publication trend")) {
			Collections.sort(publicationList, PublicationObj.yearComparator);
		}
	}

	private static ArrayList<PubTrendObj> publicationTrend(ArrayList<JSONObject> dataset, String venue) {
		ArrayList<PublicationObj> pubList = new ArrayList<PublicationObj>();
		for (JSONObject dataInJson : dataset) {
			String getVenue = getVenue(dataInJson);
			if (venue.equalsIgnoreCase(getVenue) && dataInJson.has("year")) {
				int paperYear = dataInJson.getInt("year");
				System.out.println(paperYear);
				String paperTitle = dataInJson.getString("title");
				PublicationObj pubObject = new PublicationObj(paperTitle, paperYear);
				pubList.add(pubObject);
			}
		}
		sortTopPapers(pubList, "publication trend");
		
		ArrayList<PubTrendObj> pubTrend = new ArrayList<PubTrendObj>();
		int latestPublishedYear = pubList.get(0).getPubYear();
		for (int i = 0; i< pubList.size(); i++) {
			if (i == 0) { //add first element of pubTrend, only applies for first element of pubList
				pubTrend.add(new PubTrendObj(latestPublishedYear, 1));
			} else {
				for (int j=0; j< pubTrend.size(); j++) { //check if PublicationObj.getPubYear() is same as year of element of pubTrend
					if (pubList.get(i).getPubYear() == latestPublishedYear && pubTrend.get(j).getPublishedYear() == latestPublishedYear) {
						pubTrend.get(j).incrementPublicationsCount();
					} else if (pubList.get(i).getPubYear() != latestPublishedYear) {
						latestPublishedYear = pubList.get(i).getPubYear();
						pubTrend.add(new PubTrendObj(latestPublishedYear, 0));
					} else {
						
					}
				}
			}
		}
		
		return pubTrend;
	}

	private static String getVenue(JSONObject dataInJson) {
		String paperVenue = dataInJson.getString("venue");
		// System.out.println(paperVenue);
		return paperVenue;
	}

	public Input getInputObj() {
		return inputObj;
	}

	public void setInputObj(Input inputObj) {
		this.inputObj = inputObj;
	}
}
