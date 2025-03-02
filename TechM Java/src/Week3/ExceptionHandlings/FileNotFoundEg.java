package Week3.ExceptionHandlings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNotFoundEg {
	public static void readFile(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		System.out.println("File found and being read...");
		scanner.close();
	}

	public static void main(String[] args) {
		try {
			readFile( "S:\\java\\TechM\\src\\Name"); // Change path accordingly
		} catch (FileNotFoundException e) {
			System.out.println("Exception caught: File not found.");
		}
	}
}
