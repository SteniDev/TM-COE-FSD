package Week3.IOStreams;

import java.io.File;
import java.util.Scanner;

//3. Write a Java program to check if a file or directory specified by pathname exists or not.

public class IsFileExist {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file or directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("The specified path exists and it is a file.");
            } else if (file.isDirectory()) {
                System.out.println("The specified path exists and it is a directory.");
            }
        } else {
            System.out.println("The specified path does not exist.");
        }

        scanner.close();
    }
}