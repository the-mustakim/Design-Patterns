package VisitorDesignPattern;

import VisitorDesignPattern.IElement.DeluxeRoom;
import VisitorDesignPattern.IElement.DoubleRoom;
import VisitorDesignPattern.IElement.RoomElement;
import VisitorDesignPattern.IElement.SingleRoom;
import VisitorDesignPattern.Visitor.RoomMaintenanceVisitor;
import VisitorDesignPattern.Visitor.RoomPricingVisitor;
import VisitorDesignPattern.Visitor.RoomVisitor;

public class Client {
    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomElement deluxeRoom = new DeluxeRoom();

        // Performing an operation on each room
        RoomVisitor roomPricingVisitor = new RoomPricingVisitor();
        singleRoom.accept(roomPricingVisitor);
        System.out.println(((SingleRoom) singleRoom).roomPrice);

        doubleRoom.accept(roomPricingVisitor);
        System.out.println((((DoubleRoom)doubleRoom).roomPrice));

        deluxeRoom.accept(roomPricingVisitor);
        System.out.println(((DeluxeRoom)deluxeRoom).roomPrice);

        System.out.println("--------------------------------------------------------------------------");

        // Performing another operation on the objects
        RoomVisitor roomMaintenanceVisitor = new RoomMaintenanceVisitor();
        singleRoom.accept(roomMaintenanceVisitor);
        doubleRoom.accept(roomMaintenanceVisitor);
        deluxeRoom.accept(roomMaintenanceVisitor);

    }
}
