package MediatorDesingPattern.AuctionSystem;

public class BidderImpl implements Collegue{

    String name;
    Mediator auction;

    public BidderImpl(String name, Mediator auction){
        this.name = name;
        this.auction = auction;
    }

    @Override
    public void placeBid(int bidAmount) {
        auction.placeBid(this,bidAmount);
    }

    @Override
    public void receiveBidNotification(String bidderName,int bidAmount) {
        System.out.println("This is: " + name + " login");
        System.out.println("Bidder: " + bidderName + " has been placed bid of: " + bidAmount);
        System.out.println("--------------------------------------------------------------------");
    }

    @Override
    public String getName() {
        return name;
    }
}
