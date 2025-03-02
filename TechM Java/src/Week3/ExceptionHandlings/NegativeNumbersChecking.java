package Week3.ExceptionHandlings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NegativeNumbersChecking {

    public static void checkNumbersInFile(String filePath) throws FileNotFoundException, PositiveNumberException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num > 0) {
                scanner.close();
                throw new PositiveNumberException("Error: Positive number " + num + " found in file.");
            }
        }
        scanner.close();
        System.out.println("File contains only negative numbers or zero.");
    }

    public static void main(String[] args) {
        try {
            checkNumbersInFile("C:\\Your\\Numbers.txt"); // Change path accordingly
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: File not found.");
        } catch (PositiveNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
