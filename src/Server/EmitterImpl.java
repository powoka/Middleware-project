package Server;


import Remote.Connection;
import Remote.Emitter;
import Remote.Receiver;

import java.util.Iterator;
import java.util.Map;

public class EmitterImpl implements Emitter {

    private ConnectionImpl connection;

    public EmitterImpl(){}

    @Override
    public void sendMessage(String from,String message) {

        Iterator it = connection.getListClients().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            String nickname = (String) m.getKey();
            Receiver receiver = (Receiver) m.getValue();
            try{
                receiver.receive(from,message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void setConnection(ConnectionImpl connection){
        this.connection = connection;
    }

}
