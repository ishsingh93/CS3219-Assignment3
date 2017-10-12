package assignment3_CIR.app;

import java.util.ArrayList;

public class Input {
	
	private String homeDirectory;
	private String queryType;
	private String queryCommand;
	private ArrayList<String> datasets;
	private ArrayList<Integer> numYrs;
	private ArrayList<String> conferences;
	private ArrayList<String> authors;
	
	//Constructors
	public Input() {
		
	}
	
	//Getters
	public String getHomeDirectory() {
		return homeDirectory;
	}
	
	public String getQueryType() {
		return queryType;
	}
	
	public String getQueryCommand() {
		return queryCommand;
	}
	
	public ArrayList<String> getDatasets() {
		return datasets;
	}
	
	public ArrayList<Integer> getNumYrs() {
		return numYrs;
	}
	
	public ArrayList<String> getConferences() {
		return conferences;
	}
	
	public ArrayList<String> getAuthors() {
		return authors;
	}
	
	//Setters
	public void setHomeDirectory(String homeDir) {
		this.homeDirectory = homeDir;
	}
	
	public void setQueryType(String query) {
		this.queryType = query;
	}
	
	public void setQueryCommand(String queryInstr) {
		this.queryCommand = queryInstr;
	}
	
	public void setDatasets(ArrayList<String> listOfDatasets) {
		this.datasets = listOfDatasets;
	}
	
	public void setNumYrs(ArrayList<Integer> listOfYears) {
		this.numYrs = listOfYears;
	}
	
	public void setConferences(ArrayList<String> listOfConferences) {
		this.conferences = listOfConferences;
	}
	
	public void setAuthors(ArrayList<String> listOfAuthors) {
		this.authors = listOfAuthors;
	}
}
