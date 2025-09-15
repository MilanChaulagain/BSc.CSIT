package TCPServerandClient;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try {
            // Connect to server
            Socket clientSocket = new Socket("localhost", 6789);

            // Input and Output streams
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());

            // Read two integers from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter first integer: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int num2 = scanner.nextInt();

            // Send integers to server
            outToServer.writeInt(num1);
            outToServer.writeInt(num2);

            // Receive result from server
            int greatest = inFromServer.readInt();
            System.out.println("Greatest number received from server: " + greatest);

            // Close connection
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

