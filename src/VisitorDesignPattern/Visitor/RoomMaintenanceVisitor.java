package VisitorDesignPattern.Visitor;

import VisitorDesignPattern.IElement.DeluxeRoom;
import VisitorDesignPattern.IElement.DoubleRoom;
import VisitorDesignPattern.IElement.SingleRoom;

public class RoomMaintenanceVisitor implements RoomVisitor{

    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Performing maintenance of SingleRoom");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Performing maintenance of DoubleRoom");
    }

    @Override
    public void visit(DeluxeRoom deluxRoom) {
        System.out.println("Performing maintenance of DeluxeRoom");
    }
}
