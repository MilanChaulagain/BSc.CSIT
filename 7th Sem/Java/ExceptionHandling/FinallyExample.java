package ExceptionHandling;

import java.io.*;

public class FinallyExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("hello.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Always executed
                    System.out.println("File closed successfully.");
                }
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
}

