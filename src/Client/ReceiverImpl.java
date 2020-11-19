package Client;

import Remote.Connection;
import Remote.Emitter;
import Remote.Receiver;
import Server.ConnectionImpl;
import Server.EmitterImpl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ReceiverImpl implements Receiver {

    private String serverURL;
    private String clientName;

public ReceiverImpl (String clientName) throws RemoteException {
    this.serverURL = "rmi://localhost:1099";
    this.clientName = clientName;
}


    @Override
    public void receive(String from, String message) {

    }

    @Override
    public void initClient(String[] clients) {

    }

    @Override
    public void addClient(String client) {

    }

    @Override
    public void remClient(String client) {

    }


}
