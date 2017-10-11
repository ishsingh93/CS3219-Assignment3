package assignment3_CIR.app;

import java.util.ArrayList;

public class Parser {

	private static final String AUTHORS = "authors=";
	private static final String AUTHOR = "author=";
	private static final String COMMA = ",";
	private static final String DATASET = "dataset=";	
	private static final String DATASETS = "datasets=";
	private static final String YEAR = "year=";
	private static final String YEARS = "years=";
	private static final String CONFERENCE = "conference=";
	private static final String CONFERENCES = "conferences=";
	private static final String ALL = "all";
	private static final String DASH = "-";
	
	Input inputObj;

	public Parser() {
		inputObj = new Input();
	}

	public void parseInput(String input) {
		String[] inputArr = input.split(" ");
		printArr(inputArr);
		parseCommand(inputArr[0]);
		parseQueryType(inputArr[1]);
		parseLocation(inputArr);

	}

	private void parseLocation(String[] inputArr) {
		String location = concatLocationParameter(inputArr);
		String[] locArr = location.split("\"");
		//System.out.println(location);
		switch (locArr[0]) {
		case AUTHOR :
			extractAuthors(locArr);
			break;
		case AUTHORS :
			extractAuthors(locArr);
			break;
		case DATASET :
			break;
		case DATASETS :
			break;
		case YEAR :
			extractYears(locArr);
			break;
		case YEARS :
			extractYears(locArr);
			break;
		case CONFERENCE : 
			extractConferences(locArr);
			break;
		case CONFERENCES :
			extractConferences(locArr);
			break;
		case ALL :
			break;
		default :
			break;
		}
		
	}

	private void extractConferences(String[] locArr) {
		ArrayList<String> confList = new ArrayList<String>();
		if (locArr.length == 1) {
			confList.add(locArr[1]);
		} else {
			for (String i : locArr) {
				if (!i.equalsIgnoreCase(CONFERENCE) && !i.equalsIgnoreCase(CONFERENCES) && !i.equalsIgnoreCase(DASH)) {
					confList.add(i);
				}
			}
		}
		inputObj.setConferences(confList);
	}

	private void extractYears(String[] locArr) {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		if (locArr.length == 1) {
			numList.add(Integer.parseInt(locArr[1]));
		} else {
			for (String i : locArr) {
				if (!i.equalsIgnoreCase(YEAR) && !i.equalsIgnoreCase(YEARS) && !i.equalsIgnoreCase(DASH)) {
					numList.add(Integer.parseInt(i));
				}
			}
		}
		inputObj.setNumYrs(numList);
	}

	private void extractAuthors(String[] locArr) {
		ArrayList<String> authors = new ArrayList<String>();
		for (String i : locArr) {
			if (!i.equalsIgnoreCase(AUTHORS) && !i.equalsIgnoreCase(COMMA) && !i.equalsIgnoreCase(AUTHOR)) {
				authors.add(i);
			}
		}
		printArrList(authors);
		inputObj.setAuthors(authors);
	}

	private void parseQueryType(String string) {
		inputObj.setQueryType(string);
	}

	private void parseCommand(String string) {
		inputObj.setQueryCommand(string);
	}

	private void printArr(String[] inputArr) {
		for (String i : inputArr) {
			System.out.println(i);
		}
	}

	private void printArrList(ArrayList<String> authors) {
		for (String i : authors) {
			System.out.println(i);
		}
	}

	private String concatLocationParameter(String[] inputArr) {
		String locPar = inputArr[3];
		if (inputArr.length > 4) {
			for (int i = 4; i < inputArr.length; i++) {
				locPar = locPar + " " + inputArr[i];
			}
			return locPar;
		} else {
			return locPar;
		}

	}
}
