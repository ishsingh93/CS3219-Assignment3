package assignment3_CIR.app;

public class CitObj {

	private int year;
	private int numCitations;
	
	public CitObj (int yr, int cit) {
		setYear(yr);
		setNumCitations(cit);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumCitations() {
		return numCitations;
	}

	public void setNumCitations(int numCitations) {
		this.numCitations = numCitations;
	}
}
