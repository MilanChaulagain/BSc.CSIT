package RMIMultiply;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            CalcRemote obj = new CalcRemote();

            Registry rgsty = LocateRegistry.createRegistry(9000);
            rgsty.rebind("multiply", obj);
            rgsty.rebind("factorial", obj);

            System.out.println("Server is ready to serve multiply\n");
        } catch (Exception e) {
            System.out.println("Server failed" + e);
        }
    }
}
