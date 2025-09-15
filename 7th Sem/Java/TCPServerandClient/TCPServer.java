package TCPServerandClient;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Server is waiting for client...");

            Socket connectionSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Input from client
            DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
            int num1 = inFromClient.readInt();
            int num2 = inFromClient.readInt();

            // Determine greatest number
            int greatest = (num1 > num2) ? num1 : num2;

            // Output to client
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            outToClient.writeInt(greatest);

            System.out.println("Sent greatest number: " + greatest);

            // Close connections
            connectionSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

