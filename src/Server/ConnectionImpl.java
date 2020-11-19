package Server;

import Remote.Connection;
import Remote.Emitter;
import Remote.Receiver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ConnectionImpl extends UnicastRemoteObject implements Connection {

    private HashMap<String,Receiver> listClients;
    private EmitterImpl serverEmitter;

    public ConnectionImpl() throws RemoteException {
        super();
        listClients = new HashMap<String, Receiver>();
        serverEmitter = new EmitterImpl();
    }

    @Override
    public Emitter connect(String nickname, Receiver rcv) {
        synchronized(listClients) {
            if (listClients.get(nickname) != null) return null;
            listClients.put(nickname, rcv);
        }
        EmitterImpl emitter = new EmitterImpl();
        emitter.sendMessage(nickname,nickname+": has logged in");
        return emitter;
    }

    @Override
    public void disconnect(String nickname) {
        synchronized (listClients) {
            try {
                listClients.remove(nickname);
                serverEmitter.sendMessage("Server", nickname+": has logged off");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public HashMap getListClients(){
        return listClients;
    }
}
