package MediatorDesingPattern.AuctionSystem;

import java.util.ArrayList;
import java.util.List;

public class AuctionImpl implements Mediator{

    List<Collegue> bidderList = new ArrayList<>();

    @Override
    public void addBidder(Collegue bidder) {
        bidderList.add(bidder);
    }

    @Override
    public void placeBid(Collegue bidder, int bidAmount) {
        for(Collegue bd: bidderList){
            if(!bidder.getName().equals(bd.getName())){
                bd.receiveBidNotification(bidder.getName(),bidAmount);
            }
        }
    }
}
