# Strategy Design Pattern

https://www.youtube.com/watch?v=u8DttUrXtEw

https://refactoring.guru/design-patterns/strategy

## **Intent**

**Strategy** is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

## **Problem**

One day you decided to create a navigation app for casual travelers. The app was centered around a beautiful map which helped users quickly orient themselves in any city.

One of the most requested features for the app was automatic route planning. A user should be able to enter an address and see the fastest route to that destination displayed on the map.

The first version of the app could only build the routes over roads. People who traveled by car were bursting with joy. But apparently, not everybody likes to drive on their vacation. So with the next update, you added an option to build walking routes. Right after that, you added another option to let people use public transport in their routes.

However, that was only the beginning. Later you planned to add route building for cyclists. And even later, another option for building routes through all of a city’s tourist attractions.

![image.png](Strategy%20Design%20Pattern/image.png)

While from a business perspective the app was a success, the technical part caused you many headaches. Each time you added a new routing algorithm, the main class of the navigator doubled in size. At some point, the beast became too hard to maintain.

Any change to one of the algorithms, whether it was a simple bug fix or a slight adjustment of the street score, affected the whole class, increasing the chance of creating an error in already-working code.

In addition, teamwork became inefficient. Your teammates, who had been hired right after the successful release, complain that they spend too much time resolving merge conflicts. Implementing a new feature requires you to change the same huge class, conflicting with the code produced by other people.

## **Solution**

The Strategy pattern suggests that you take a class that does something specific in a lot of different ways and extract all of these algorithms into separate classes called *strategies*.

The original class, called *context*, must have a field for storing a reference to one of the strategies. The context delegates the work to a linked strategy object instead of executing it on its own.

The context isn’t responsible for selecting an appropriate algorithm for the job. Instead, the client passes the desired strategy to the context. In fact, the context doesn’t know much about strategies. It works with all strategies through the same generic interface, which only exposes a single method for triggering the algorithm encapsulated within the selected strategy.

This way the context becomes independent of concrete strategies, so you can add new algorithms or modify existing ones without changing the code of the context or other strategies.

![image.png](Strategy%20Design%20Pattern/image%201.png)

In our navigation app, each routing algorithm can be extracted to its own class with a single `buildRoute` method. The method accepts an origin and destination and returns a collection of the route’s checkpoints.

Even though given the same arguments, each routing class might build a different route, the main navigator class doesn’t really care which algorithm is selected since its primary job is to render a set of checkpoints on the map. The class has a method for switching the active routing strategy, so its clients, such as the buttons in the user interface, can replace the currently selected routing behavior with another one.

## **Real-World Analogy**

![image.png](Strategy%20Design%20Pattern/image%202.png)

Imagine that you have to get to the airport. You can catch a bus, order a cab, or get on your bicycle. These are your transportation strategies. You can pick one of the strategies depending on factors such as budget or time constraints.

## **Structure**

![image.png](Strategy%20Design%20Pattern/image%203.png)

## **🤔 Nai samjhra?**

Let’s break it down thora easy way mai….

## 1. Introduction to Design Patterns

Design Patterns are fundamental principles in Object-Oriented Programming (OOP) that help manage complexity and promote code reusability and flexibility. They are crucial for good Low-Level Design (LLD) in System Design. Without a strong understanding of design patterns, significant problems can arise in LLD.

## 2. The Problem with Traditional Inheritance (without Design Patterns)

The source highlights a common issue that arises when relying solely on traditional inheritance, particularly when child classes require similar, specialized functionalities that are not available or suitable in the base class.

### 2.1 The Duplication and Scalability Problem

Consider a Vehicle base class with a drive() method implementing "normal drive capability." If multiple child classes, such as SportsVehicle and OffRoadVehicle, require a "special drive capability" that is *different* from the base class's drive() and *identical* to each other, they would each override the drive() method and implement the same "special drive capability" code.

**Key Issues:**

- **Code Duplication:** As demonstrated, if SportsVehicle and OffRoadVehicle both need "special drive capability" and this isn't in the base class, they will both write the exact same code, leading to duplication.
- **Lack of Scalability: New Features:** If more features are added (e.g., display(), fuelCapability(), seatingArrangement()), and multiple child classes need to override these with identical, specialized implementations, code duplication will escalate.
- **New Child Classes:** As the system grows and more child classes are introduced, the likelihood of encountering situations where siblings need identical functionalities (not provided by the base class) increases, further amplifying code duplication.
- **Maintenance Nightmare:** Maintaining duplicated code across multiple child classes becomes challenging. Any change or bug fix to the shared specialized functionality would need to be applied to every instance, increasing the risk of errors.

The source states: Whenever I encounter a situation where, at the same level, children are not using their parents’ capability but are using some capability that is common among the children, then a code reusability issue arises, and it's not scalable. As our system grows and the number of children increases within the system, code duplication will increase.

## 3. The Strategy Design Pattern Solution

The Strategy Design Pattern offers a solution to the problems of code duplication and inflexibility inherent in the traditional inheritance approach described above.

### 3.1 Core Idea: Encapsulate Behavior

The core principle of the Strategy Pattern is to encapsulate varying algorithms or behaviors into separate, interchangeable objects called "strategies." These strategies are then composed into the context object (e.g., Vehicle) at runtime.

### 3.2 Implementation Steps

1. **Create a Strategy Interface/Abstract Class:**
    - Define an interface (e.g., DriveStrategy) that declares the method(s) for the varying behavior (e.g., drive()).
    - This interface acts as a contract for all concrete strategy implementations.
2. **Implement Concrete Strategy Classes:**
    - Create multiple concrete classes that implement the strategy interface, each representing a specific variation of the behavior.
    - For example, NormalDriveStrategy for normal driving, SpecialDriveStrategy (or SportsDriveStrategy, OffRoadDriveStrategy) for specialized driving.
3. **Context Class (e.g., Vehicle):**
    - The Vehicle class (the context) will now **have an object** of the DriveStrategy interface. This is a "Has-A" relationship (composition) instead of "Is-A" (inheritance) for the specific behavior.
    - The Vehicle class will receive the appropriate DriveStrategy object, typically through its constructor or a setter method (known as "Constructor Injection" or "Dependency Injection").
    - The Vehicle class's drive() method will then **delegate** the actual driving behavior to the drive() method of its contained DriveStrategy object.

### 3.3 Benefits of the Strategy Pattern

- **Eliminates Code Duplication:** Shared specialized functionalities are now implemented only once in their respective concrete strategy classes.
- **Increased Flexibility and Reusability:** Behaviors can be changed dynamically at runtime by swapping strategy objects.
- New behaviors can be easily added by creating new concrete strategy classes without modifying existing code (Open/Closed Principle).
- Child classes (e.g., SportsVehicle, OffRoadVehicle, GoodsVehicle) simply choose and "inject" the desired DriveStrategy into their parent Vehicle's constructor.
- **Improved Scalability:** As the system grows, adding new drive capabilities (e.g., XYZDriveStrategy) only requires creating a new strategy class, without altering the Vehicle class or other existing strategies.
- **Better Separation of Concerns:** The Vehicle class focuses on its core responsibilities, while the DriveStrategy classes focus on specific driving behaviors.
- **Decoupling:** The Vehicle class is decoupled from the concrete implementations of the driving behavior. It only knows about the DriveStrategy interface.

The source concludes by emphasizing: You should use the Strategy Pattern when you feel that the child classes you are creating have the same code, which is not present in the base class, and they need the same functionality. For example, the drive method had one code, and these needed the same functionality. In that case, we can use the Strategy Pattern, and as features increase, we don't need to duplicate the code.

This pattern is highly valuable in Low-Level Design and helps create robust, maintainable, and scalable systems.

## **Applicability**

**Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.**

The Strategy pattern lets you indirectly alter the object’s behavior at runtime by associating it with different sub-objects which can perform specific sub-tasks in different ways.

**Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.**

The Strategy pattern lets you extract the varying behavior into a separate class hierarchy and combine the original classes into one, thereby reducing duplicate code.

**Use the pattern to isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.**

The Strategy pattern lets you isolate the code, internal data, and dependencies of various algorithms from the rest of the code. Various clients get a simple interface to execute the algorithms and switch them at runtime.

**Use the pattern when your class has a massive conditional statement that switches between different variants of the same algorithm.**

The Strategy pattern lets you do away with such a conditional by extracting all algorithms into separate classes, all of which implement the same interface. The original object delegates execution to one of these objects, instead of implementing all variants of the algorithm.