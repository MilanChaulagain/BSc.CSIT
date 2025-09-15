package RMIExample;

import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public MyRemoteImpl() throws RemoteException {
        super();
    }

    public String sayHello() {
        return "Hello from RMI Server!";
    }

}
