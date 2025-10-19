# Composite Design Pattern

https://www.youtube.com/watch?v=mp5lwolO-wM

https://www.youtube.com/watch?v=Q1jZ4TI6MF4

![image.png](Composite%20Design%20Pattern/image.png)

The Composite Design Pattern is a **structural design pattern** used to **create objects that represent a tree structure**. Its primary goal is to allow **treating individual objects and compositions of objects uniformly**, meaning that operations can be performed on both single components and complex structures in the same way.

## **1. Tree Structure Representation**

The fundamental idea of the Composite Design Pattern is to model systems as tree structures. The source uses the example of **assembling a computer** to illustrate this:

- A computer is the top-level structure.
- It contains a "cabinet" and "peripheral devices."
- The cabinet, in turn, contains a hard drive, motherboard, RAM, and CPU.
- Peripheral devices include a mouse and keyboard.

This hierarchical arrangement, where objects contain other objects, forms the basis of the pattern.

## **2. Composite Objects vs. Leaf Objects**

Within this tree structure, two main types of objects are identified:

- **Composite Object:** An object that "has list of objects." As the source explains, "the awesome thing is the composite object we can also have a composite objects right a composite object can have even this is a composite object this composite object can have a composite or a layer of object." This signifies that composite objects can contain both leaf objects and other composite objects, allowing for arbitrary nesting.
- **Leaf Object:** An object that "we don't have anything inside this." These are the terminal nodes in the tree structure, representing individual components that do not contain other objects. Examples from the computer assembly include RAM, CPU, Mouse, and Keyboard.

## **3. Uniform Operations (The "Funder" Principle)**

A crucial aspect of the Composite Design Pattern is the ability to perform the **same operations on both leaf nodes and composite objects**. The source emphasizes this as "the funder here is if you can perform certain operations on Leaf node...the same operation need to be performed on the composite object or composite node."

The example used to illustrate this is calculating the **price**:

- If you can get the price of a leaf object (e.g., "price of a keyboard").
- You should also be able to get the price of a composite object (e.g., "price of a peripheral device" or the "price of the computer"), which would involve aggregating the prices of its contained components.

This uniformity simplifies client code, as it doesn't need to differentiate between individual objects and collections of objects when performing common operations.

## **4. Shared Characteristics and Type Consistency**

Despite their structural differences (composite vs. leaf), all objects within the tree structure often share common characteristics or belong to the same conceptual type. In the computer example, the source states, "they are all electronic devices. If you talk about a computer, it's an electronic device; if you talk about a camera, it's an electronic device; when you talk about a keyboard, it's an electronic device. That means they all follow the same structure, they have all the same features, right?" This implies a common interface or base type that both composite and leaf objects implement, enabling the uniform treatment.

![image.png](Composite%20Design%20Pattern/image%201.png)

![image.png](Composite%20Design%20Pattern/image%202.png)