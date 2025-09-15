package RMIExample;

import java.rmi.*;

public class RMIServer {
    public static void main(String[] args) {
        try {
            MyRemoteImpl obj = new MyRemoteImpl();
            Naming.rebind("rmi://localhost/HelloService", obj);
            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

