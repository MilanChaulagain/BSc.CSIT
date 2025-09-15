package RMILab;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    protected CalculatorImpl() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    public double divide(int a, int b) throws RemoteException {
        if (b == 0) throw new ArithmeticException("Division by zero not allowed.");
        return (double) a / b;
    }

    public List<Integer> factors(int n) throws RemoteException {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) result.add(i);
        }
        return result;
    }

    public long factorial(int n) throws RemoteException {
        if (n < 0) throw new IllegalArgumentException("Factorial not defined for negative numbers.");
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
