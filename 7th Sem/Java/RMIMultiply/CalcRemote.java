package RMIMultiply;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcRemote extends UnicastRemoteObject implements Calc{

    public CalcRemote() throws RemoteException {
        super();
    }
    @Override
    public int multiply(int a, int b) throws RemoteException {
        return (a*b);
    }

    @Override
    public int factorial (int a) throws RemoteException {
        int fact = 1;
        for(int i = 1; i <= a; i++){
            fact = fact*i;
        }
        return fact;
    }
    
}
