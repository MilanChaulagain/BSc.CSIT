package SingleChatApplication;

import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class SingleChatClient {
    public static void main(String[] args) {
        try {
            Socket cs = new Socket("localhost", 2345);

            Scanner ins = new Scanner(cs.getInputStream());

            PrintWriter outs = new PrintWriter(cs.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            String rmsg, smsg;

            do{
                rmsg = ins.nextLine();
                System.out.println("\tServer: " + rmsg);
                System.out.println("Client:");
                smsg = scanner.nextLine();
                outs.println(smsg);
            }while(rmsg.equals("bye")!= true);

            ins.close();
            outs.close();
            cs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
