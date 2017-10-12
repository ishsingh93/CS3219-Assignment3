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
		Parser inputParser = new Parser();
		inputParser.parseInput(input);
	}
}
