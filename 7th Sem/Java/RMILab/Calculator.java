package RMILab;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Calculator extends Remote {
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
    int multiply(int a, int b) throws RemoteException;
    double divide(int a, int b) throws RemoteException;
    List<Integer> factors(int n) throws RemoteException;
    long factorial(int n) throws RemoteException;
}
