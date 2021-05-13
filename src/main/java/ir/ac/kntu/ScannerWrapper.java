package ir.ac.kntu;

import java.util.Scanner;

public class ScannerWrapper {

	private static ScannerWrapper instance = new ScannerWrapper();
	private Scanner scanner;
	
	private ScannerWrapper() {
		scanner = new Scanner(System.in);
	}
	
	public static ScannerWrapper getInstance() {
		return instance;
	}
	
	public char next() {
		String input = scanner.nextLine().trim();
		if(input.length() == 1){
			return input.charAt(0);
		}
		return '!';
	}

	public String nextLine() {
		return scanner.nextLine();
	}
	
	public Double nextDouble() {
		return scanner.nextDouble();
	}

	public Integer nextInt() {
		return scanner.nextInt();
	}
	
	public void close() {
		scanner.close();
	}
}