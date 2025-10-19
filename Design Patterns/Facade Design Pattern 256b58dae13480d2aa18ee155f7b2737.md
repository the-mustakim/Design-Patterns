# Facade Design Pattern

https://refactoring.guru/design-patterns/facade

https://www.youtube.com/watch?v=GYaBXK54eLo

## **1. Problem**

Imagine that you must make your code work with a broad set of objects that belong to a sophisticated library or framework. Ordinarily, you’d need to initialize all of those objects, keep track of dependencies, execute methods in the correct order, and so on.

As a result, the business logic of your classes would become tightly coupled to the implementation details of 3rd-party classes, making it hard to comprehend and maintain.

## **2. Solution**

A facade is a class that provides a simple interface to a complex subsystem which contains lots of moving parts. A facade might provide limited functionality in comparison to working with the subsystem directly. However, it includes only those features that clients really care about.

Having a facade is handy when you need to integrate your app with a sophisticated library that has dozens of features, but you just need a tiny bit of its functionality.

For instance, an app that uploads short funny videos with cats to social media could potentially use a professional video conversion library. However, all that it really needs is a class with the single method `encode(filename, format)`. After creating such a class and connecting it with the video conversion library, you’ll have your first facade.

## **3. Real-World Analogy**

![image.png](Facade%20Design%20Pattern/image.png)

When you call a shop to place a phone order, an operator is your facade to all services and departments of the shop. The operator provides you with a simple voice interface to the ordering system, payment gateways, and various delivery services.

## **4. Core Purpose: Hiding System Complexity**

The primary objective of the Facade Design Pattern is to “hide the system complexity from the client”

This is the fundamental principle to remember when considering facade. The client should not need to understand the intricate internal workings of a complex subsystem; instead, they interact with a simplified interface provided by the Facade.

**Key Idea:**

- **Simplification for the client:** The Facade acts as a single, unified interface that shields the client from the underlying complex architecture.
- **Analogy: Car operation:** The source effectively illustrates this with a car example: "As a user we who are driving the car we are a client... if I press accelerate pedal speed will go up if I push the brake pedal, speed will go down but the real complexity the system complexity behind the accelerate does clients knows it? No right." The client only needs to know *what* to do (press accelerator) not *how* it's done (engine, gear interactions).

**Important Fact:**

- **Optional Interaction:** It's crucial to understand that **"we are not forcing client to always talk with facade."** Clients can still interact directly with the subsystem components if they choose, but the Facade offers a simpler, optional alternative. The Facade is "not a mandatory" interaction layer.

## **5. When to Use Facade: Scenarios and Examples**

![image.png](Facade%20Design%20Pattern/image%201.png)

**Scenario 1: Exposing Specific Methods**

- **Problem:** A subsystem (e.g., an EmployeeDao class interacting with a database) might have a large number of methods (e.g., 50-100 for insert, updateEmployeeName, getEmployeeDetailByEmailId, etc.). A client, however, might only be interested in a small subset of these methods.
- **Facade Solution:** Create an EmployeeFacade that "expose only those method which client required." The facade takes responsibility for creating and managing the EmployeeDao object and only exposes methods like insert and getEmployeeDetailByEmployeeId to the client.
- **Benefit:** The client's interface remains lean and focused, ignoring the "50 or 100 methods" it doesn't need.

**Scenario 2: Orchestrating Complex Processes**

- **Problem:** A complex operation (e.g., "create an order") requires interaction with multiple, distinct classes within a subsystem (e.g., ProductDao, Payment, Invoice, Notification).
- If the client directly orchestrates these steps:
- It needs knowledge of all involved classes and their invocation order.
- Any changes to the order creation logic (new steps, modified return types of existing steps) would "impact client" and require client-side code updates.
- **Facade Solution:** Introduce an OrderFacade with a single createOrder method. This facade encapsulates the entire order creation process: "first fetching the product first step second making a payment third invoice generated and then send notification."
- **Benefit:** The client simply calls orderFacade.createOrder(). "Any change in the product in the system... it only impact facade right it will not impact the client." This promotes loose coupling and makes the system more maintainable.

**Scenario 3: Facade Using Another Facade**

- **Concept:** The Facade pattern is flexible enough that one facade can utilize other facades. This allows for hierarchical or modular simplification.
- **Example:** A CheckoutFacade could internally call an OrderFacade (to create the order) and a PaymentFacade (to handle payment), along with any other necessary components.
- **Benefit:** This allows for building more sophisticated facades by leveraging existing simplified interfaces, further promoting reusability and modularity.