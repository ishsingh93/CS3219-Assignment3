package assignment3_CIR.app;

import java.io.IOException;
import java.util.Scanner;

public class UI {

	private Scanner sc = new Scanner(System.in);
	
	public UI() {
		
	}
	
	public String getInput() {
		System.out.print("Please enter your query: ");
		String input = sc.nextLine();
		return input;
	}
	
	public Output displayOutput() {
		return null;
	}
	
	public void run() throws IOException {
		String input = getInput();
		String dataLoc = getDataLoc();
		Parser inputParser = new Parser();
		inputParser.parseInput(input, dataLoc);
	}

	private String getDataLoc() {
		System.out.println("Choose data location : ");
		String ishLoc = "C:\\Users\\User\\my-app\\papers-2017-02-21-sample.json\\dataset.json";
		String javanLoc = "D:\\CS3219-Assignment3\\papers-2017-02-21\\dataset.json";
		System.out.println("Ish's data location -> " + ishLoc);
		System.out.println("Javan's data location -> " + javanLoc);
		System.out.print("Enter your name: ");
		String loc = sc.nextLine();
		if (loc.equalsIgnoreCase("ish")) {
			return ishLoc;
		} else if (loc.equalsIgnoreCase("javan")) {
			return javanLoc;
		} else {
			return null;
		}
		
	}
}
