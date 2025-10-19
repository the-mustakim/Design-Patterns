package VisitorDesignPattern.Visitor;

import VisitorDesignPattern.IElement.DeluxeRoom;
import VisitorDesignPattern.IElement.DoubleRoom;
import VisitorDesignPattern.IElement.SingleRoom;

public interface RoomVisitor {

    public void visit(SingleRoom singleRoom);
    public void visit(DoubleRoom doubleRoom);
    public void visit(DeluxeRoom deluxRoom);

}
