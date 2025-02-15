package Week3.IOExceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileData {
    public static void main(String[] args) {
        // Specify the file path
        String filePath = " S:\\java\\untitled\\Kesaria.srt";

        // Read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
