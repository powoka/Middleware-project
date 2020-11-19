package Remote;

public interface Connection {

    Emitter connect (String nickname, Receiver rcv);
    void disconnect (String nickname);

}
