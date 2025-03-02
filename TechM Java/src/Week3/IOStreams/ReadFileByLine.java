package Week3.IOStreams;
//10. Write a Java program to read file content line by line.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileByLine {
    public static void main(String[] args) {
        String filePath =  "C:\\Users\\STENI DEV S A\\Downloads\\UNIT 3 WNBA ANS[1].pdf";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = reader.readLine()) != null) {
                System.out.println("Line : " +  line);

            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
