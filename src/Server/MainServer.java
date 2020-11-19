package Server;

import Remote.Connection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        ConnectionImpl connection = new ConnectionImpl();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("connection", connection);



    }

}
