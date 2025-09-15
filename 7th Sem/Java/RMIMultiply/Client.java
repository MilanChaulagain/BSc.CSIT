package RMIMultiply;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry rgsty = LocateRegistry.getRegistry(9000);

            Calc obj = (Calc) rgsty.lookup("multiply");

            int value = obj.multiply(5, 7);
            int value2 = obj.factorial(6);

            System.out.println("Value " + value);

            System.out.println("Factorial " + value2);
        }catch(Exception e){
            System.out.println("Failed to connect to server" + e);
        }
    }
}
