package MediatorDesingPattern.AuctionSystem;

public class Client {

    public static void main(String[] args) {
        Mediator auction = new AuctionImpl();

        Collegue bidder1 = new BidderImpl("Sameer", auction);
        Collegue bidder2 = new BidderImpl("Sajid", auction);

        auction.addBidder(bidder1);
        auction.addBidder(bidder2);

        bidder1.placeBid(1000);
        bidder2.placeBid(2000);

    }

}
