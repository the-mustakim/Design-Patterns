package VisitorDesignPattern.Visitor;

import VisitorDesignPattern.IElement.DeluxeRoom;
import VisitorDesignPattern.IElement.DoubleRoom;
import VisitorDesignPattern.IElement.SingleRoom;

public class RoomPricingVisitor implements RoomVisitor{

    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Pricing computation logic of SingleRoom");
        singleRoom.roomPrice = 1000;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Pricing computation logic of DoubleRoom");
        doubleRoom.roomPrice = 2000;
    }

    @Override
    public void visit(DeluxeRoom deluxRoom) {
        System.out.println("Pricing computation logic of DeluxeRoom");
        deluxRoom.roomPrice = 5000;
    }
}
