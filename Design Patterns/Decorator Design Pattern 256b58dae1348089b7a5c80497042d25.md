# Decorator Design Pattern

https://www.youtube.com/watch?v=w6a9MXUwcfY

The Decorator Pattern is a widely used software design pattern, especially prevalent in real-world applications and a frequent topic in system design interviews. It is particularly useful for adding new functionalities to an existing object without altering its structure.

- **Core Concept:** The Decorator Pattern allows for adding "additional features" to a "base object" by "wrapping" it in a decorator. The key insight is that "this new decorator that we have created is also an object (instance of) the base class itself, showing the IS-A relationship, so we can also decorate it." This creates a recursive, layered structure, or an "inside-out look," where one decorator can wrap another, and so on.
- **Analogy:** Adding toppings one by one to the base pizza.

![image.png](Decorator%20Design%20Pattern/image.png)

## **1. Real-World Use Cases**

**Pizza Shop Use Case**

**Base Object:** A "base pizza."

- **Decorators:** Various "toppings" like "extra cheese," "mushrooms," "jalapenos," or "extra veggies."

**Process:** One starts with a base pizza, then decorates it with extra cheese, and then further decorates the "base pizza + extra cheese" with mushrooms, and so on. The resulting decorated object (e.g., base pizza + extra cheese) itself becomes a base for further decoration.

**Coffee Shop Use Case**

**Base Object:** "Base coffee."

- **Decorators:** Additions like "cream," "extra milk," or "extra sugar."

**Car Customization Use Case**

**Base Object:** A "base car."

- **Decorators:** "Extra features" such as "cover seat," "power steering," or "flat tires."

These examples demonstrate the pattern's flexibility in allowing for various combinations of features without creating an explosion of distinct classes.

## **2. Why the Decorator Pattern is Needed: Avoiding Class Explosion**

The most significant problem the Decorator Pattern addresses is **"Class Explosion"**.

- **Problem Description:** Without the Decorator Pattern, adding new combinations of features would necessitate creating a new class for each permutation. For instance, in the car example, one would need classes like BaseCarPlusAC, BaseCarPlusACPlusPowerSteering, BaseCarPlusPowerSteeringPlusFlatTires, and so on. Similarly, for pizza, one would need BasePizzaPlusExtraCheese, BasePizzaPlusExtraCheesePlusMushroom, etc.
- **Scalability Issue:** "How many classes will you make?" The number of classes would grow exponentially with each new topping or feature, leading to an unmanageable system. "As soon as new toppings arrive in the market, new classes will have to be created for them.
- **Solution:** The Decorator Pattern "comes into the picture where our base is the same, where our base is prepared once, after that it's just toppings and their combinations." This avoids the need to create a new class for every possible combination of features.

## **2. Implementation Details and Key Relationships (Is-A and Has-A)**

The Decorator Pattern solves the class explosion problem by defining two crucial relationships:

- **Base Object (Abstract Class):**
    - An Abstract Class (e.g., BasePizza) defines a method (e.g., cost()) that all concrete base objects (e.g., FarmHouse, VegDelight, Margherita) will implement. These concrete base objects are themselves types of BasePizza (Is-A relationship).
    - *Quote:* "Base pizza is an abstract class, and inside this abstract class I have a cost method which is abstract."
- **Topping Decorator (Abstract Decorator):**
    - An Abstract Topping Decorator (e.g., ToppingDecorator) is also an abstract class. It **extends** the BasePizza abstract class, meaning it **"Is-A"** BasePizza. This allows decorators to be treated as pizzas themselves, enabling chaining.
    - It also **"Has-A"** reference to a BasePizza object (e.g., BasePizza pizza;). This is crucial because it allows the decorator to wrap another BasePizza object (which could be another decorator or a concrete base pizza).
    - *Quote:* "This Topping Decorator... I first extended it with Base Pizza meaning it **is IS-A**" And, "This extra object, this second decorator, it has a base object... so here it HAS-A base object."
    - *Key Principle:* "The decorator itself IS-A and HAS-A both." This dual relationship is fundamental to its ability to create layered functionality.
- **Concrete Decorators:**
    - Concrete decorators (e.g., ExtraCheese, Mushroom) extend the ToppingDecorator.
    - They implement the cost() method by calling the cost() method of the wrapped BasePizza object and then adding their own specific cost.
    - *Example: ExtraCheese Cost Calculation:* this.pizza.cost() + 10 (where this.pizza refers to the wrapped base pizza object).