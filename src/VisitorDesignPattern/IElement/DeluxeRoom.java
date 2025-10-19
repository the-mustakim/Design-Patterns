package VisitorDesignPattern.IElement;

import VisitorDesignPattern.Visitor.RoomVisitor;

public class DeluxeRoom implements RoomElement{

    public int roomPrice = 0;

    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}
