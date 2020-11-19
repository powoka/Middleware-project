package Client;

import Remote.Connection;
import Server.ConnectionImpl;
import Server.EmitterImpl;
import Remote.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient {



    public static void main(String[] args) throws IOException, NotBoundException {
        ReceiverImpl receiver = new ReceiverImpl(args[0]);
        Connection server;
        try {
            server = (Connection) java.rmi.Naming.lookup("rmi://localhost:1099/Connection");
        } catch (RemoteException|MalformedURLException|NotBoundException e){
            throw new java.rmi.RemoteException("Problem connecting to the server");
        }
        Emitter emitter = server.connect(args[1], receiver);
        java.io.BufferedReader in = new java.io.BufferedReader(new
                java.io.InputStreamReader(System.in));
        while (true) {
            String msg = in.readLine();
            if (msg == null || msg.length() == 0) break;
            emitter.sendMessage(args[0], msg);
        }
        server.disconnect(args[0]);
        System.exit(0);
    }
}
