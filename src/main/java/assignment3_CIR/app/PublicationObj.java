package assignment3_CIR.app;

import java.util.Comparator;

public class PublicationObj {

	private String publicationTitle;
	private int pubCount;
	
	public PublicationObj() {
		pubCount = 0;
	}
	
	public PublicationObj(String pubTitle) {
		this.publicationTitle = pubTitle;
		pubCount = 0;
	}

	public String getPublicationTitle() {
		return publicationTitle;
	}

	public void setPublicationTitle(String pubTitle) {
		this.publicationTitle = pubTitle;
	}

	public int getPubCount() {
		return pubCount;
	}

	public void setPubCount(int pubCount) {
		this.pubCount = pubCount;
	}

    /*Comparator for sorting the list by publication Count*/
    public static Comparator<PublicationObj> pubCounter = new Comparator<PublicationObj>() {

	public int compare(PublicationObj pub1, PublicationObj pub2) {

	   int pubCount1 = pub1.getPubCount();
	   int pubCount2 = pub2.getPubCount();

	   /*For descending order*/
	   return pubCount2-pubCount1;
   }};
	
}
