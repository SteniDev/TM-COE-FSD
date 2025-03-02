package Week3.IOStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadPlainTextFile {
    public static void main(String[] args) {

        String filePath = "S:\\java\\TechM\\src\\Name";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;


            System.out.println("--- Reading and printing line by line ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }


        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
