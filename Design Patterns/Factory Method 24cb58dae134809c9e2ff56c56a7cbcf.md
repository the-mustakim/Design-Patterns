# Factory Method

https://www.youtube.com/watch?v=s3Wr5_tsODs

**I. Overview of Factory Method Design Pattern**

![image.png](Factory%20Method/image.png)

The Factory Method Design Pattern is a **creational design pattern** used for creating objects. Its primary goal is to **hide the complexity of object instantiation** from the client code. It's particularly useful when creating objects that are of similar type but may have varying implementations or depend on different parameters for their initialization. The pattern defers the object creation logic to subclasses, promoting abstraction and flexibility.

**II. Key Concepts and Principles**

![image.png](Factory%20Method/image%201.png)

- **Creational Design Pattern:** Focuses on object creation mechanisms, trying to create objects in a manner suitable for the situation.
- **Hides Complexity:** The client code interacting with the factory method does not need to know the intricate details of how an object is created. It simply requests an object of a certain type, and the factory handles the instantiation.
- **Similar Objects, Varied Implementations:** The pattern is ideal for scenarios where you need to create objects that belong to a common family or interface but have distinct internal implementations or configurations based on input parameters.
- **Abstraction and Encapsulation:** It promotes abstraction by defining an interface for creating objects, but allowing subclasses to decide which class to instantiate. This encapsulates the object creation logic.
- **Deferred Instantiation:** The actual implementation of object creation is "deferred" or left to the concrete subclasses that inherit from the abstract factory class.
- **Client Decoupling:** The client code is decoupled from the concrete classes it instantiates. It interacts only with the abstract factory interface, making the system more flexible and easier to maintain.

**III. Class Diagram Explained**

The typical class diagram for the Factory Method Pattern consists of:

- **Factory (Abstract Interface/Class):**
    - Defines an abstract method (the "factory method") for creating objects.
    - Does not implement the creation logic itself.
    - Serves as the interface that the client code interacts with.
    - *Example:* CourseFactory (in the course website example).
- **Concrete Factory (Concrete Class):**
    - Subclass of the Factory.
    - Implements the factory method defined in the abstract factory.
    - Contains the actual logic for creating specific types of objects based on parameters.
    - *Example:* CourseFactory (in the course website example, where the createCourse logic is actually handled). *Self-correction based on source: The source's "CourseFactory" is more of the abstract interface, and the logic within its getCourse method (which acts like the factory method) directs to the concrete product classes like HLD and LLD.*
- **Product (Abstract Interface/Class):**
    - Defines the interface for the objects the factory method creates.
    - All concrete products implement this interface.
    - *Example:* Course (in the course website example).
- **Concrete Product (Concrete Class):**
    - Subclass of the Product.
    - Represents the specific type of object created by the factory method.
    - Implements the Product interface.
    - *Example:* HLD (High-Level Design Course), LLD (Low-Level Design Course) – these inherit from Course.
- **Client Code:**
    - Interacts with the Factory interface to request objects.
    - Has no knowledge of the concrete product classes or the complexity of their creation.
    - *Example:* DemoClass (in the course website example).

**IV. Analogies and Real-World Applications**

![image.png](Factory%20Method/image%202.png)

- **Bottle Lid Factory Analogy:** A factory manufactures bottle lids (metal, plastic, small, large). A client orders lids (e.g., "metal lids for certain bottles"). The factory handles the internal complexity (different departments, machinery) but only returns the finished lids to the client, hiding the manufacturing process.
- **Calendar and NumberFormat classes in Java:** Classic examples of how the Factory Method is implemented in standard libraries.
- **UI Frameworks and Libraries:** When developing UI frameworks, factory methods can be used to allow users to create different types of buttons, scrollbars, or widgets based on parameters, without exposing the underlying implementation details.
- **Vehicle Creation Example:** Creating different types of vehicles (truck, car, ship, plane) where the complexity of instantiation is hidden behind a createVehicle factory method, and the specific vehicle type is determined by parameters like weight and number of wheels.
- **Course Website (Udacity, edX, Coursera):** Building a website with multiple online courses, where each course can have different modules. The CourseFactory creates Course objects (like HLD or LLD) based on requested course types, hiding the module composition details from the client.

![image.png](Factory%20Method/image%203.png)

![Factory Method Pattern_ Course & Modules Example - visual selection.png](Factory%20Method/Factory_Method_Pattern__Course__Modules_Example_-_visual_selection.png)

Code:

Refer to: D:\Dublin\Interview Prep\Design Patterns\Design Patterns\src\FactoryDesign

How did you use this pattern in a previous experience or project?

When I worked on CHReME at C-DAC, I used the Factory Method pattern to connect with different HPC schedulers like Slurm and Torque. I made one common interface for all schedulers and separate classes for each scheduler type. A factory picked the right class based on settings, so the main code worked the same way for all schedulers and we could add new ones later without big changes.

**V. Pros and Cons**

**Pros:**

- **Guarantees Abstraction:** Client code interacts with an abstract interface, promoting a high level of abstraction.
- **Flexible and Adaptable Code:** Easily add new types of objects or change existing implementations without modifying client code. New concrete products can be introduced without affecting the existing factory or client.
- **Useful for Frameworks and Libraries:** Enables library developers to provide creation mechanisms without exposing concrete implementation details to users.
- **Hides Complexity:** Keeps object creation logic separate from client code, making the client code cleaner and easier to understand.

**Cons:**

- **Increased Code Complexity:** The pattern introduces more classes and interfaces, making the overall codebase larger and potentially harder to initially understand or "demo."
- **Time-Consuming Setup:** Requires more effort and time to set up the base structure for implementing the pattern.
- **Difficult to Refactor Into:** It's not easily applied to existing codebases. It's often necessary to "start from scratch" or make significant changes to refactor an existing system into a Factory Method pattern, as it requires fundamental architectural shifts.
- **Anticipation of Future Requirements:** Optimal use requires foresight into future object creation needs. If you don't anticipate needing varied implementations upfront, the benefits might not outweigh the initial complexity.

**VI. When to Use (Decision Factors)**

- When a class cannot anticipate the class of objects it must create.
- When a class wants its subclasses to specify the objects it creates.
- When you want to hide the complexity of object creation from the client code.
- When you anticipate needing to add new types of objects in the future without modifying existing client code.
- When designing frameworks or libraries where users need to create specific objects without knowing their concrete classes.

**Quiz: Factory Method Design Pattern**

**Instructions:** Answer each question in 2-3 sentences.

1. What is the primary classification of the Factory Method Design Pattern, and what is its main purpose?
2. How does the Factory Method Design Pattern help in hiding object creation complexity from the client code?
3. Explain the relationship between the "Factory" (abstract interface) and "Concrete Factory" (concrete class) in the class diagram.
4. Why is the Factory Method Pattern particularly well-suited for creating objects that are "similar but vary a little in terms of implementation"?
5. Provide a real-world analogy (other than the bottle lid factory) that illustrates the core concept of the Factory Method Design Pattern.
6. Describe one significant advantage of using the Factory Method Design Pattern in a large software project.
7. What is a major downside or "con" of implementing the Factory Method Design Pattern?
8. In the course website example, how do the HLD and LLD classes relate to the Course class and the Factory Method Pattern?
9. Why is it generally difficult to "refactor" existing code into the Factory Method Design Pattern?
10. When would an architect or developer typically decide to use the Factory Method Design Pattern, considering future requirements?

Quiz Answer Key

1. The Factory Method Design Pattern is a creational design pattern. Its main purpose is to provide an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created, effectively hiding the instantiation logic.
2. It hides complexity by having the client code interact with an abstract factory interface rather than directly with concrete classes. The factory method within this interface handles the internal logic of deciding which specific object to instantiate and how to do so, abstracting these details from the client.
3. The "Factory" represents the abstract interface or class that declares the factory method, but does not implement it. The "Concrete Factory" is a subclass that inherits from the abstract Factory and provides the actual implementation for the factory method, deciding which concrete product to instantiate.
4. The pattern is well-suited because it allows for a common interface (the abstract product) for these similar objects, while deferring the specific, varying implementations to concrete product classes. The factory then decides which of these varying implementations to create based on parameters, all hidden from the client.
5. Consider a custom pizza delivery service. A client orders "a spicy vegetarian pizza." The "pizza factory" (the kitchen) knows how to assemble various pizzas (product), but the client doesn't need to know the specific steps or ingredients for the vegetarian option versus a meat-lover's; they just get their specific pizza.
6. One significant advantage is that it makes the code flexible and adaptable. New types of objects can be added to the system without requiring modifications to the existing client code, as long as they adhere to the product interface, promoting extensibility.
7. A major downside is that it increases the overall complexity of the codebase. It requires more classes and interfaces, which can make the initial setup time-consuming and the code harder to understand for someone new to the project.
8. In the course website example, HLD and LLD are concrete product classes that inherit from the abstract Course class. They implement the specific details (like modules) for high-level and low-level design courses, with the CourseFactory deciding whether to instantiate an HLD or LLD object based on client requests.
9. It is difficult to refactor existing code into the Factory Method Design Pattern because it often requires a fundamental architectural shift. The pattern necessitates defining abstract interfaces and delegating creation logic to subclasses, which means significant changes to how objects are currently instantiated throughout the codebase.
10. An architect would typically decide to use this pattern when anticipating future requirements, particularly if there's a clear expectation that new types of similar objects with varying implementations will need to be supported later. It allows for easy expansion without breaking existing client code.