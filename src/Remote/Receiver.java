package Remote;

public interface Receiver {

    void receive (String from, String message);
    void initClient (String[] clients);
    void addClient (String client);
    void remClient (String client);

}
