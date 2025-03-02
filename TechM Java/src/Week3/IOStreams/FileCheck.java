package Week3.IOStreams;

import java.io.File;
import java.util.Scanner;
//4. Write a Java program to check if a file or directory has read and write permissions.
public class FileCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file or directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("The specified file or directory does not exist.");
        } else {
            System.out.println("Checking permissions for: " + file.getAbsolutePath());
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
        }

        scanner.close();
    }
}