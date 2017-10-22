package assignment3_CIR.app;

import java.util.Comparator;

public class PubTrendObj {

	private int publicationsCount;
	private int publishedYear;
	
	public PubTrendObj() {

	}
	
	public PubTrendObj(int year, int count) {
		this.publishedYear = year;
		this.publicationsCount = count;
	}

	public int getPublicationsCount() {
		return publicationsCount;
	}

	public void setPublicationsCount(int publicationsCount) {
		this.publicationsCount = publicationsCount;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	public void incrementPublicationsCount() {
		this.publicationsCount = publicationsCount + 1;
	}

}
