package Week3.IOStreams;

import java.io.File;
import java.util.Scanner;

//5. Write a Java program to check if the given pathname is a directory or a file.
public class CheckPathFileOrDirectory {
    public static void main(String[] args) {


    Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file or directory path: ");
    String path = scanner.nextLine();
        scanner.close();

    File file = new File(path);

        if (!file.exists()) {
        System.out.println("The specified path does not exist.");
    } else if (file.isFile()) {
        System.out.println("It is a file.");
    } else if (file.isDirectory()) {
        System.out.println("It is a directory.");
    } else {
        System.out.println("Unknown type.");
    }
}
}
