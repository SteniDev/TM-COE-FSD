package Week3.IOStreams;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
//6. Write a Java program to determine the last modified date of a file.
public class LastModifiedDate {
    public static void main(String[] args) {
        // Specify the file path
        String filePath = "S:/java/TechM/src/Week3/IOExceptions/ListOfAllFiles.java";

        // Create a File object
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists()) {
            // Get the last modified time
            long lastModified = file.lastModified();

            // Convert to a readable date format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(new  Date(lastModified));

            // Print the last modified date
            System.out.println("Last Modified Date: " + formattedDate);
        } else {
            System.out.println("File does not exist.");
        }
    }
}
