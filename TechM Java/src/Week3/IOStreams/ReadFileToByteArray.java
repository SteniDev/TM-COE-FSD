package Week3.IOStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//9. Write a Java program to read the contents of a file into a byte array.
public class ReadFileToByteArray {
    public static void main(String[] args) {
        String filePath = "S:\\java\\TechM\\src\\Name";

        try {
            byte[] fileBytes = readFileToByteArray(filePath);
            System.out.println("File read successfully. Byte array length: " + fileBytes.length);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static byte[] readFileToByteArray(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }
}
