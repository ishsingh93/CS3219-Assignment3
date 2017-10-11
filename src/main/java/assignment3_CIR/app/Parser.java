package assignment3_CIR.app;

public class Parser {

	public Parser() {

	}

	public void parseInput(String input) {
		String[] inputArr = input.split(" ");
		printInputArr(inputArr);
		
		
	}

	private void printInputArr(String[] inputArr) {
		for (String i : inputArr) {
			System.out.println(i);
		}
	}

}
