# Visitor Design Pattern

https://www.youtube.com/watch?v=pDsz-AuFO0g

## Intent

**Visitor** is a behavioral design pattern that lets you separate operations from the objects on which they operate.

## Problem

![image.png](Visitor%20Design%20Pattern/image.png)

1. **Class Growth and Maintenance:** Without the Visitor pattern, adding new operations to a class (e.g., HotelRoom with getRoomPrice, initiateRoomMaintenance, reserveRoom) would require modifying and retesting that class every time. This leads to the class growing "vertically" with potentially 50 or more methods, making it hard to manage and test.
    - **Quote:** "This class can grow if you don't know how many operations can be added... this class may host around 50 methods or you can say that 50 operations so this class can grow huge."
2. **Violation of Open/Closed Principle:** The pattern allows for the addition of new operations without changing the existing class's structure, adhering to the open/closed principle (open for extension, closed for modification).
    - **Quote:** "This pattern allow you to add new operation to existing class without changing their structure."

## UML of Visitor Pattern

![image.png](Visitor%20Design%20Pattern/image%201.png)

- **IElement / RoomElement (Interface):** Declares accept(IVisitor visitor).
- **ConcreteElement / SingleRoom, DoubleRoom, DeluxeRoom (Classes):** Implement IElement, providing specific implementations for accept (which calls visitor.visit(this)).
- **IVisitor / RoomVisitor (Interface):** Declares visit methods for each ConcreteElement type.
- **ConcreteVisitor / RoomPricingVisitor, RoomMaintenanceVisitor (Classes):** Implement IVisitor, providing specific logic for each operation on each element type.

![image.png](Visitor%20Design%20Pattern/image%202.png)

![image.png](Visitor%20Design%20Pattern/image%203.png)

![image.png](Visitor%20Design%20Pattern/image%204.png)

## **Core Concept and How it Works:**

The Visitor pattern achieves its goals by **separating operations from the objects on which they operate**. It takes all operations (like pricing, maintenance, reservation) out of the "element" classes (e.g., SingleRoom, DoubleRoom, DeluxeRoom) and encapsulates them into "visitor" classes.

1. **Elements:** These are the objects on which operations are performed. In the example, RoomElement is an interface with concrete implementations like SingleRoom, DoubleRoom, and DeluxeRoom.
    - Each RoomElement has a single method: accept(RoomVisitor visitor). This method is crucial for initiating the "double dispatch."
2. **Visitors:** These interfaces and their concrete implementations host the operations.
    - RoomVisitor is an interface that declares visit methods for each concrete RoomElement type (e.g., visit(SingleRoom room), visit(DoubleRoom room), visit(DeluxeRoom room)).
    - Concrete visitor classes (e.g., RoomPricingVisitor, RoomMaintenanceVisitor, ReserveRoomVisitor) implement the RoomVisitor interface and contain the specific logic for each operation on each type of room.
    - **Quote:** "Visitor is something which host all the operations... for each operation you can create visitor."

## **How Operations are Added**

- **New Operation:** To add a new operation (e.g., AuditRoom), a new concrete visitor class (RoomAuditingVisitor) is created. The existing RoomElement classes and existing visitor classes remain unchanged. This means the system grows "horizontally" by adding new visitor classes.
    - **Quote:** "Any new operation will come, it will grow horizontally, not vertically. One class will not grow to a massive size; it will grow horizontally for each operation, and we will create one visitor."
- **New Element:** If a new room type (e.g., PresidentialSuite) is added, it implements RoomElement. All *existing* concrete visitor classes (RoomPricingVisitor, RoomMaintenanceVisitor, etc.) then need to be updated to include a visit method for the new PresidentialSuite type.

## **Dispatch Explained:**

The Visitor pattern heavily relies on **double dispatch** to determine which specific method to execute at runtime based on the *type of two objects*: the caller object and the argument object.

1. **Single Dispatch:** This is standard polymorphism where the method invoked depends on the *type of the object reference calling the method*.
    - **Example:** Room obj = new DeluxeRoom(); obj.accept(visitor); Here, obj.accept() will call the accept method of DeluxeRoom because obj holds a DeluxeRoom object.
2. **Double Dispatch:** In the Visitor pattern, when a client calls                    singleRoomObject.accept(new RoomPricingVisitor()):
    - **First Dispatch (Caller):** The accept method of the SingleRoom object is invoked (single dispatch based on the singleRoomObject's concrete type).
    - **Second Dispatch (Argument):** Inside the SingleRoom's accept method, it calls visitor.visit(this). Here, visitor is a RoomPricingVisitor and this refers to the SingleRoom object. The specific visit method called (e.g., visit(SingleRoom room)) is determined by:
    - The concrete type of the visitor object (RoomPricingVisitor).
    - The concrete type of the this argument (SingleRoom).
    - **Quote:** "Double dispatch means the method which has to be invoked it depend upon two objects right one is the caller and another is argument."
    - **Quote:** "The method is decided based upon the caller and the argument. So visitor pattern uses double dispatch functionality to take out of the operation from the object or element."

## Visitor vs. Strategy Pattern:

The briefing differentiates Visitor from the Strategy design pattern, which some people confuse it with:

- **Strategy Pattern:** Primarily for **separating algorithms** that are independent of the element classes. Elements can then choose which algorithm to use dynamically. Algorithms are often reusable across different elements without being specific to them.
- **Quote:** "Strategy pattern is mostly for separating out the algorithm... algorithm is independent of this elements like single room double room."
- **Visitor Pattern:** Specifically for **separating operations** that are often tightly coupled to the structure of the element classes. Each visit method typically contains logic *specific* to how an operation should be performed on a particular element type.
- **Quote:** "Visitor pattern we are talking about operations right specifically for each of this element single room it's a specific operation."

In summary, the Visitor pattern provides a structured way to add new operations to an existing object structure without modifying the objects themselves, improving maintainability and adhering to good design principles through the elegant use of double dispatch.