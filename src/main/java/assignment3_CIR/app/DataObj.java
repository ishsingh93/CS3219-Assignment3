package assignment3_CIR.app;

import java.util.List;

public class DataObj {

	private List<Integer> noOfCitedDocuments;
	private List<Integer> rangeOfYears;
	private List<String> citedConferences;
	public DataObj() {
		
	}
	
	//Getters
	public List<Integer> getNoOfCitedDocuments() {
		return noOfCitedDocuments;
	}
	
	public List<String> getCitedConferences() {
		return citedConferences;
	}
	
	public List<Integer> getRangeOfYears() {
		return rangeOfYears;
	}
	
	public void setNoOfCitedDocuments(List<Integer> citedDocs) {
		this.noOfCitedDocuments = citedDocs;
	}
	
	public void setRangeOfYears(List<Integer> yearRange) {
		this.rangeOfYears = yearRange;
	}
	
	public void setCitedConferences(List<String> citedConf) {
		this.citedConferences = citedConf;
	}
		
}
