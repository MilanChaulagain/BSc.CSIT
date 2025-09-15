package SingleChatApplication;

import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class SingleChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2345);
            Socket cs = ss.accept();

            Scanner ins = new Scanner(cs.getInputStream());
            PrintWriter outs = new PrintWriter(cs.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            String rmsg, smsg;

            do {
                System.out.println("Server: ");
                smsg = scanner.nextLine();
                outs.println(smsg);

                rmsg = ins.nextLine();
                System.out.println("\tClient: "+rmsg);
            }while(rmsg.equals("bye")!=true);

            outs.close();
            ins.close();
            cs.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
