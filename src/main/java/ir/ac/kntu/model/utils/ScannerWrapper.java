package ir.ac.kntu.model.utils;

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
		return Double.parseDouble(scanner.nextLine());
	}

	public Integer nextInt() {
		return Integer.parseInt(scanner.nextLine());
	}
	
	public void close() {
		scanner.close();
	}
}