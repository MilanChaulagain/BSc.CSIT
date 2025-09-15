package FileServer;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileClient {
    public static void main(String[] args) {
        String server = "localhost";
        int port = 5000;

        try (
            Socket socket = new Socket(server, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
        ) {
            System.out.print("Enter filename to get: ");
            String filename = scanner.nextLine();

            // Send command
            out.write("GET " + filename + "\n");
            out.flush();

            // Read response
            String response = in.readLine();
            if ("OK".equals(response)) {
                System.out.println("File found. Contents:");
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                System.out.println("ERROR: File not found on server.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

