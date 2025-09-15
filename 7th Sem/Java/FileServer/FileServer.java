package FileServer;

import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("File server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // Handle each client in a new thread (optional for concurrency)
                handleClient(clientSocket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            String command = in.readLine();
            System.out.println("Received command: " + command);

            if (command != null && command.startsWith("GET ")) {
                String filename = command.substring(4).trim();
                File file = new File(filename);

                if (file.exists() && file.isFile()) {
                    out.write("OK\n");
                    out.flush();

                    // Send file content
                    BufferedReader fileReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = fileReader.readLine()) != null) {
                        out.write(line + "\n");
                    }
                    fileReader.close();
                } else {
                    out.write("ERROR\n");
                }
            } else {
                out.write("ERROR\n");
            }

            out.flush();
            socket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

