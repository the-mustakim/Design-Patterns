package SingletonDesignPattern;

public class NetworkConnection {
    private static NetworkConnection networkConnection = new NetworkConnection();

    private NetworkConnection(){

    }

    public static NetworkConnection getNetworkConnection(){
        return networkConnection;
    }
}
