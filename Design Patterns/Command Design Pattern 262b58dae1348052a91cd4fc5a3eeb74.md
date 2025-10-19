# Command Design Pattern

https://www.youtube.com/watch?v=E1lce5CWhE0

## **1. Introduction to the Command Design Pattern**

The Command Design Pattern is a **behavioral pattern** used in low-level system design. As its name suggests, it is employed in scenarios where "commands" are issued, such as "copy," "paste," "delete" in a text editor, or "turn on/off" for a remote-controlled device. The pattern aims to decouple the sender of a command from the object that performs the action, thereby improving system flexibility, maintainability, and enabling features like undo/redo functionality.

## **2. Problems with a Simple System Design (without Command Pattern)**

![image.png](Command%20Design%20Pattern/image.png)

The source illustrates a common, problematic approach using a simple "air conditioner" (AC) class and a "client" interacting directly with it. This direct interaction leads to several significant issues:

- **Lack of Abstraction:** The client needs direct knowledge of all methods required to perform an action. For example, to turn on an AC, the client might need to call turnOnAC(). If turnOnAC() later becomes a sequence of multiple internal steps, "the client has to know about that, okay if it wants to turn on the AC, then it has to know about all these steps." This creates tight coupling and makes changes difficult.
- **Difficulty in Implementing Undo/Redo Functionality:** A simple design offers no inherent mechanism for undoing or redoing operations. The source highlights this as "a very, very important interview question." If the client were to manage undo/redo, it would be a "very very bad design" as it would need to track all commands and their reverse operations, which is not the responsibility of the client or the "dumb object" (receiver) like the AC.
- **Difficulty in Code Maintenance and Scalability:** As the system grows to support more devices (e.g., a bulb alongside an AC) or more commands, the client becomes "very, very bulky and very, very tightly coupled with these objects." Supporting 100 devices would mean the client would need to "know about all 100 devices also," leading to significant maintenance challenges.

## **3. Core Components of the Command Design Pattern**

The Command Design Pattern resolves these issues by dividing the logic into four key components:

1. **Receiver:** The object that performs the actual operation. It knows how to carry out the request. In the AC example, the AirConditioner class with methods like turnOnAC(), turnOffAC(), and setTemperature() is the receiver. The receiver is a "dumb object" that merely executes instructions.
2. **Command (Interface/Abstract Class):** Declares an interface for executing an operation. This typically includes an execute() method. For undo/redo functionality, an undo() method is also added.
3. **Concrete Command:** Implements the Command interface by binding a receiver object with an action. It encapsulates the action as a specific command. Examples include TurnACOnCommand and TurnACOffCommand. Each concrete command holds a reference to its specific receiver and calls the appropriate method on that receiver when its execute() method is invoked. For undo, it calls the reverse operation on the receiver.
4. **Invoker:** The object that asks the command to carry out the request. It holds a command object and triggers its execute() method. In the remote control example, the RemoteControl class is the invoker. It "has access to command" and when a button is pressed, it calls command.execute(). The invoker does not know the specific receiver or the exact operation it performs.
5. **Client:** Creates concrete command objects and sets them to the invoker. The client initiates the process by interacting with the invoker (e.g., pressing a button on a remote). The client's interaction is highly simplified; it "only has to worry about press button that's all."

**Relationship between components:** "Invoker generates a command and this command is intent for particular receiver." The client uses the invoker to generate a command, which then controls a particular receiver.

![image.png](Command%20Design%20Pattern/image%201.png)

## **4. How the Command Pattern Solves the Identified Problems**

- **Abstraction and Decoupling:** The client no longer needs to know the details of how an operation is performed. It simply tells the invoker to "press button." The invoker, in turn, doesn't know the specifics of the command, only that it can execute(). This creates a layer of abstraction where "any change in a particular behavior of a receiver, only that command will get changed."
- **Undo/Redo Functionality:** This is a major advantage of the Command Pattern.
- **Extension:** The Command interface is extended to include an undo() method in addition to execute(). Each ConcreteCommand then implements both execute() and undo() (e.g., TurnACOnCommand.execute() turns on, TurnACOnCommand.undo() turns off).
- **Tracking:** The Invoker (e.g., RemoteControl) maintains a "stack command history" of executed commands. When pressButton() is called, the command is executed and also "adding into an stack stack of command."
- **Reversal:** An undo() method is exposed by the Invoker. When called, it "pop up the last element" from the stack, retrieves the command, and calls its undo() method. This allows the system to revert previous operations without the client managing the history or reversal logic. The client just needs to "simply call undo method."
- **Code Maintenance and Scalability:** Adding support for new devices (e.g., a bulb) or new commands simply involves creating new Receiver classes and corresponding ConcreteCommand classes. The Invoker can be designed to dynamically set or manage different commands for its "buttons." This modularity prevents the client from becoming "bulky and very very tight coupled."

## 5. UML Representation (Conceptual)

The typical UML representation involves:

- A Receiver class.
- A Command interface (with execute() and potentially undo()).
- Multiple ConcreteCommand classes implementing Command, each holding a reference to a Receiver.
- An Invoker class that has a Command object (or a collection of commands) and a method to trigger execution. For undo/redo, the Invoker also manages a history stack.
- A Client that creates Invoker and Receiver objects, then sets ConcreteCommand objects on the Invoker, and finally interacts with the Invoker.

## **6. Conclusion**

The Command Design Pattern is a powerful and "very interesting design pattern" that effectively addresses common design challenges related to abstraction, maintainability, and crucial features like undo/redo. It excels in scenarios where actions need to be queued, logged, or reverted, providing a clean and decoupled architecture. "Anytime you see copy paste card change using remote type anywhere command related things comes up the name itself is very clear command design pattern and the best pattern to implement undo reduce also this one.”