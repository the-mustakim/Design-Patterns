package MediatorDesingPattern.AuctionSystem;

public interface Mediator {
    void addBidder(Collegue bidder);
    void placeBid(Collegue bidder, int bidAmount);
}
