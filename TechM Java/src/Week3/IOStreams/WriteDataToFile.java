package Week3.IOStreams;

import java.io.*;
import java.util.Scanner;
//7. Write a Java program to read input from the Java console.
public class WriteDataToFile {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the output file path: ");
        String filePath = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))   {

            System.out.println("Enter text to write to the file (type 'done' to finish):");

            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.equalsIgnoreCase("done")) {
                    break; // Exit the loop when "done" is entered
                }
                writer.write(line);
                writer.newLine(); // Add a newline character after each line
            }

            System.out.println("Text written to file successfully.");

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            scanner.close();
        }







    }
}
