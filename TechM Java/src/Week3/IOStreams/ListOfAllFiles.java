package Week3.IOStreams;

// 1. Write a Java program to get a list of all file/directory names in the given directory.

import java.io.File;
import java.util.Scanner;

public class ListOfAllFiles {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            String[] fileList = directory.list();
            if (fileList != null) {
                System.out.println("Files and directories in " + directoryPath + ":");
                for (String fileName : fileList) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("Failed to retrieve file list.");
            }
        } else {
            System.out.println("Invalid directory path or directory does not exist.");
        }
    }
}