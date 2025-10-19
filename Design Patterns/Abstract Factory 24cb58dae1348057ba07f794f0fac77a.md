# Abstract Factory

https://www.youtube.com/watch?v=5hXZnI86E2Y

![image.png](Abstract%20Factory/image.png)

### 1. Core Concept: "Factory of Factories"

The Abstract Factory Method Design Pattern is a **creational design pattern** that acts as a "factory of factories." While the traditional Factory Method pattern creates objects of similar types, the Abstract Factory creates "objects which belong to a family of similar objects."

- **Key Quote:** "It's very simple a factory of factory pattern so basically it is a pattern inside a pattern it is a creational design pattern which is required to create objects which belong to a family of similar objects."

This pattern introduces an additional layer of abstraction, where an abstract factory decides which specific factory to call, and that specific factory then decides which concrete implementation of an object to instantiate.

![image.png](Abstract%20Factory/image%201.png)

![image.png](Abstract%20Factory/image%202.png)

The above diagram is of the Factory Design Pattern

![image.png](Abstract%20Factory/image%203.png)

The above diagram is of the Abstract Factory Design Pattern

### 2. Implementation & Code Flow

The Abstract Factory pattern, like the Factory Method, is implemented using a common interface. The actual implementation details are deferred to subclasses or "concrete classes."

- **Code Flow:**
    - The **client** calls an **Abstract Factory**.
    - Based on parameters, the Abstract Factory determines which **concrete factory** (one of its implementations) to utilize.
    - This concrete factory then instantiates the relevant **concrete objects** (which belong to its "family" of objects).
    - The object is returned to the client.
- **Analogy:** A large furniture factory (Abstract Factory) receives an order for a type of furniture (e.g., chair, sofa). It then directs this order to its respective specialized internal factories (concrete factories) for chairs, sofas, etc., which then manufacture the specific furniture piece.

![image.png](Abstract%20Factory/image%204.png)

### **3. Practical Example: University Admit Card & Fee Calculator System**

![image.png](Abstract%20Factory/image%205.png)

![image.png](Abstract%20Factory/image%206.png)

### **4. Advantages (Pros)**

The Abstract Factory pattern offers several significant benefits for software design:

- **Abstraction & Loose Coupling:** It provides a high level of abstraction, effectively decoupling the client code from the concrete implementations of the objects it creates. The client doesn't need to know *how* the objects or even the factories are instantiated.
    - **Key Quote:** "Using this pattern you can have loose coupling between the client code and the actual implementation code which is a good software architecture practice to be used."
- **Family of Objects:** It's particularly useful when you need to create "a family of similar objects" together.
- **Open/Closed Principle (OCP):** The design allows for easy extension (adding new factories or new types of objects within existing factories) without modifying existing code.
    - **Key Quote:** "You can easily add more different type of factories and different type of objects in the implementation." For instance, adding a new university type or a new course/admit card within an existing university factory is straightforward.
- **Single Responsibility Principle (SRP):** Each class (concrete factory, concrete object) has a distinct responsibility for instantiating or implementing its specific type of object, with details hidden.
    - **Key Quote:** "Every class has a responsibility to instantiate its type of object and the details are hidden in that particular concrete implementation so all the classes follow single responsibility principle."

### **5. Disadvantages (Cons)**

Despite its benefits, the Abstract Factory pattern comes with certain complexities:

- **Increased Complexity:** The code structure can become more "complicated and complex over the time when the family of factory grows."
- **Learning Curve:** As it's a "pattern inside a pattern," it might take time for developers new to the concept to "wrap their head around it and to understand the real implementation."

### How did you used this pattern in your previous work?

In CHReME at C-DAC, I used an Abstract Factory–style design to support different HPC scheduler families like Slurm and Torque. Each factory created related objects such as job submission and job monitoring services specific to that scheduler. This kept the client code independent of scheduler details and made it easy to add new scheduler types later.