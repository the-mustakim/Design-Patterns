package MediatorDesingPattern.AuctionSystem;

public interface Collegue {
    void placeBid(int bidAmount);
    void receiveBidNotification(String name,int bidAmount);

    String getName();
}
