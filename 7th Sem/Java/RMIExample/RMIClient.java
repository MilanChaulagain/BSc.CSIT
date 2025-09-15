package RMIExample;

import java.rmi.*;

public class RMIClient {
    public static void main(String[] args) {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://localhost/HelloService");
            String response = service.sayHello();
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

