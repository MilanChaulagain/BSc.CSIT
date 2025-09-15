package RMIMultiply;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote {
    int multiply(int a, int b) throws RemoteException;
    int factorial(int a) throws RemoteException;
}
