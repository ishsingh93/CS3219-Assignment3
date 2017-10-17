package assignment3_CIR.app;

import java.util.Comparator;

public class AuthorObj {

	private String authorName;
	private int count;
	
	public AuthorObj() {
		// TODO Auto-generated constructor stub
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

    /*Comparator for sorting the list by author publication count*/
    public static Comparator<AuthorObj> authorCount = new Comparator<AuthorObj>() {

	public int compare(AuthorObj au1, AuthorObj au2) {

	   int auCount1 = au1.getCount();
	   int auCount2 = au2.getCount();

	   /*For descending order*/
	   return auCount2-auCount1;
   }};
}
