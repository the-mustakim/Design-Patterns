# Bridge Design Pattern

https://www.youtube.com/watch?v=SOw1_W0taBg&t=20s

## **Introduction to the Bridge Design Pattern**

The Bridge Design Pattern is a structural design pattern that aims to **decouple an abstraction from its implementation so that the two can vary independently.** This means that changes made to the abstraction or its implementation do not necessitate changes in the other, promoting flexibility and extensibility in software design.

The core idea is to separate a class into two distinct hierarchies:

- **Abstraction:** Represents the high-level control logic.
- **Implementation:** Represents the low-level details and specific functionalities.

The abstraction holds a reference to an object from the implementation hierarchy, allowing it to delegate tasks to it.

![image.png](Bridge%20Design%20Pattern/image.png)

## **The Problem Bridge Pattern Solves: Tight Coupling**

![image.png](Bridge%20Design%20Pattern/image%201.png)

**Initial Problematic Design (Simple Inheritance):**

In this setup, you have an abstract class `LivingThing` with an abstract method `breatheProcess()`. Child classes like `Dog`, `Fish`, and `Tree` directly inherit from `LivingThing` and implement their specific `breatheProcess()` logic. For instance, a dog's `breatheProcess()` involves breathing through its nose, a fish's through gills, and a tree's through leaves
**The Core Issue: Tight Coupling:**

The problem arises because the **implementation of the breathing process is tightly coupled with the specific type of living thing:**

- **No Independent Variation**: The "`LivingThing` " (abstraction) and its "breathing process" (implementation) **cannot vary independently**. They are intrinsically tied together.
- **Introducing New Breathing Processes is Difficult**: If you want to introduce a completely **new way of breathing**, for example, a bird's unique breathing process through nostrils on its beak, or a hypothetical process where an organism both inhales and exhales carbon dioxide, **you cannot simply add this new process on its own**.
- **Forced Creation of New Child Classes**: To incorporate a new breathing process, you are **forced to create a new child class of** `LivingThing` (e.g., a `Bird` class) that explicitly *uses* that new breathing process. The source states, "you cannot add this new breathing process because currently it is very tightly coupled with the abstraction... unless this will not add bird... then only you can add this breathing process".
- **Implementation Tied to Abstraction**: The *logic* of how something breathes (the implementation) is **directly embedded within and dependent on a specific type of living creature** (the abstraction). You can't have a new breathing process exist unless there's a `LivingThing` child class defined to use it.

In essence, the initial design creates a rigid hierarchy where adding new behaviors (such as breathing processes) always necessitates extending the `LivingThing` hierarchy, even if the new behavior could theoretically be applied to existing or future `LivingThing` types without modification. This lack of independence in variation is precisely what the Bridge Pattern aims to solve.

## **Solution: Decoupling with the Bridge Pattern**

![image.png](Bridge%20Design%20Pattern/image%202.png)

The Bridge Pattern resolves this by separating the "how to breathe" logic from the "what is breathing" entity.

**Bridge Pattern Applied:**

1. **Abstraction Hierarchy:**

The `LivingThing` abstract class and its concrete child classes form the Abstraction Hierarchy, which now manages the higher-level logic and holds a reference to an implementation:

- `LivingThing` **Abstract Class:** This class **remains an abstract class**. Crucially, instead of containing the concrete `breatheProcess()` logic directly, it now holds a **reference to an Implementer interface**. The source states, "I have a reference of this implementer".
- **Concrete** `LivingThing`  **Child Classes:** Concrete classes like `Dog`, `Fish`, and `Tree` are still present in this hierarchy.
    - Their **constructors now accept an Implementer object**. For example, "In the Dog class we are passing and object of **LandBreatheImplementer like in Fish we will be passing WaterBreatheImplementer**". This means that when you create a `Dog` or `Fish` object, you provide it with the specific breathing mechanism it should use.
- **Delegation of** `breatheProcess()` : The `breatheProcess()` method within the `LivingThing` class no longer contains the actual breathing logic. Instead, it **simply delegates the call to the Implementer's breathe() method**.
1. **Implementation Hierarchy**

A new, separate hierarchy is introduced specifically for the different breathing mechanisms. This is the Implementation Hierarchy:

- **BreatheImplementer Interface:** A **new interface named BreatheImplementer is introduced**. This interface defines a single abstract method, `breathe()`.
- **Concrete Implementations of BreatheImplementer:** Different concrete classes implement the `BreatheImplementer` interface, each providing a specific breathing mechanism:
    - **LandBreatheImplementer:** Implements breathing through the nose, inhaling oxygen and exhaling carbon dioxide.
    - **WaterBreatheImplementer:** Implements breathing through gills, absorbing oxygen from water and releasing carbon dioxide.
    - **TreeBreatheImplementer:** Implements breathing through leaves, inhaling carbon dioxide and exhaling oxygen

**Advantages of this Decoupling:**

- **Independent Variation**: The fundamental benefit of the Bridge Pattern is that it **decouples an abstraction from its implementation so that they both can vary independently**. This means that changes or additions to the types of `LivingThing` (the abstraction hierarchy) will not affect the various `BreatheImplementer` mechanisms (the implementation hierarchy), and vice versa.
- **Extensibility**:
    - **Adding New Breathing Processes**: You can **increase more concrete implementers**. For instance, if a new breathing process like `XYZBreatheImplementer` (for inhaling and exhaling carbon dioxide) needs to be introduced, it can be added to the `BreatheImplementer` hierarchy **simply** by creating a new implementer class. This addition does not require any modification to the existing `LivingThing` abstraction hierarchy, nor does it necessitate a new child class within the `LivingThing` hierarchy to use it. The implementer can grow independently of the abstraction.
    - **Adding New Types of Living Things**: Similarly, you can **add more child classes for the abstraction**. New types of `LivingThing` (e.g., a `Bird` class) can be introduced without needing to change or replicate the existing `LandBreatheImplementer`, `WaterBreatheImplementer`, or `TreeBreatheImplementer` implementations.
- **Runtime Flexibility**: The specific breathing process used by a `LivingThing` object **can be changed at runtime** by injecting a different `BreatheImplementer` instance into its constructor or through a setter method. This dynamic capability allows a single `LivingThing` object to switch its breathing behavior without altering its core type.

## **Bridge Pattern vs. Strategy Pattern: Intent is Key**

**The Crucial Distinction: Intent**

"You will learn so many design patterns and lot of design patterns are very similar but difference in the intent.”

- **Intent of Strategy Pattern:**
    - "To change the behavior of this object [Context] on runtime."
    - The client chooses and passes a specific strategy to the context object, dynamically altering how that object performs an action.
    - "You are changing the behavior of this object on runtime which one will you pass."
- **Intent of Bridge Pattern:**
    - "Both should grow independently."
    - "Blitz pattern is designed from that perceptive separate the logic whatever the logic you have and to implementer so that both can vary independently both can increase decrease independently."
    - The primary goal is to **split a single large class or tightly coupled system into two separate hierarchies that can evolve independently.** It's about breaking down a monolithic structure into manageable, decoupled components. While runtime behavior change is a side effect, it's not the primary intent.