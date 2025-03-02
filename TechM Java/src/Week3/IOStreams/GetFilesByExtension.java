package Week3.IOStreams;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
//2. Write a Java program to get specific files with extensions from a specified folder.
public class GetFilesByExtension {
    public static void main(String[] args) {
        // Specify the folder path and the desired file extension
        String folderPath = "C:\\Users\\STENI DEV S A\\Downloads";
        String extension = "pdf";

        // Get the list of files with the specified extension
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("The specified folder does not exist or is not a directory.");
            return;
        }

        // FilenameFilter to filter files based on the extension
        FilenameFilter filter = (dir, name) -> name.toLowerCase().endsWith("." + extension);
        File[] files = folder.listFiles(filter);

        // Display the filtered files
        if (files != null && files.length > 0) {
            System.out.println("Files with extension ." + extension + " in folder " + folderPath + ":");
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No files with the specified extension found in the folder.");
        }
    }
}
