package Remote;

import Client.ReceiverImpl;

public interface Emitter {

    void sendMessage (String from, String message);
}
