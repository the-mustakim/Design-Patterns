package VisitorDesignPattern.IElement;

import VisitorDesignPattern.Visitor.RoomVisitor;

public interface RoomElement {
    public void accept(RoomVisitor roomVisitor);
}
