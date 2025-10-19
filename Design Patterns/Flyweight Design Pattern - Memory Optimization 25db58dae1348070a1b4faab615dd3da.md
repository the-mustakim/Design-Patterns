# Flyweight Design Pattern - Memory Optimization

https://www.youtube.com/watch?v=Mwm6tB3x1do

https://www.youtube.com/watch?v=8cL9KbHS5kE

## **1. Purpose: Memory Reduction through Data Sharing**

The primary goal of the Flyweight pattern is to "reduce the memory usage by sharing data (fields which are common) among multiple objects." This pattern is a critical consideration when facing "memory is very limited" constraints, as repeatedly emphasized in the source.

## **2. Core Problem: Excessive Memory Consumption with Redundant Objects**

The source illustrates this problem through two main scenarios:

- **Gaming Scenario (Army of Robots):**
    - **Problem:** Creating a large army of identical robots (e.g., 5 lakh human robots, 5 lakh robotic dogs) where each robot object stores unique positional data (x, y) but also redundant information like "type" (humanoid/robotic dog) and "body/sprite" (the image rendering data).
    - **Memory Impact:** If each robot object is 31KB, creating 10 lakh objects results in "31 GB in memory," which "would crash" if memory limits are there, for example, 25GB.
    - **Redundancy:** All human robots "look exactly the same" and share the same "type" and "humanoid sprite."
- **Word Processor/Text Editor:**
    - **Problem:** Typing a document with potentially "lacks of character." If each character (e.g., 't', 'h', 'i', 's') is a separate object storing its character value, font type, size, and unique row/column position, memory consumption becomes a significant issue.
    - **Redundancy:** All instances of the same character (e.g., 'T') with the same font type and size "look exactly the same," only differing in their "X axis Y axis their coordinates." The source notes that "all T looks exactly the same even the size is same."

## **3. Identifying Flyweight Applicability (Hints):**

The source provides clear indicators for when to consider the Flyweight pattern:

- **Memory Limitation:** "When memory is limited interviewer is saying hey memory is limited memory is limited memory is limited." This is the "first hint."
- **Object Data Sharing:** "When objects share the data." If "two objects doesn't share any data you can't use flywit for sure."
- **Expensive Object Creation:** "Creation of object is expensive." The "Sprite object 2D bitmap array is a very expensive object."

## **4. Intrinsic vs. Extrinsic Data:**

A fundamental concept in the Flyweight pattern is the distinction between two types of data:

- **Intrinsic Data:** "The data which is shared among objects are called instancing Data." This data remains constant across shared objects and is stored within the Flyweight object.
    - **Robot Example:** type (humanoid/robotic dog) and body/sprite (image rendering data).
    - **Character Example:** character (e.g., 't'), font type, size.
- **Extrinsic Data:** "Changes based on the client input and differ from one object to another." This data is unique to each "instance" and is **not** stored within the Flyweight object; instead, it is passed as parameters to methods.
    - **Robot Example:** x axis, y axis (position).
    - **Character Example:** row, column (coordinates).

Note: In the context of the gaming scenario discussed in the video, a **Sprite** in computer graphics refers to a **small 2D bitmap**

## **5. Steps to Implement the Flyweight Pattern:**

The pattern involves refactoring objects to separate intrinsic and extrinsic data and leveraging caching:

- **Step 1: Separate Data:** "From object remove all the extrinsic data and keep only intrinsic data."
- **Step 2: Create Flyweight Objects:** The resulting object, containing only intrinsic data, is called a "flyweight object." These objects should be **immutable**, meaning their intrinsic data cannot be changed after creation (e.g., by making fields private and providing only getters, no setters).
- **Step 3: Pass Extrinsic Data:** Extrinsic data, which was removed from the flyweight object, is "passed to the flyweight class in method parameter."
- **Step 4: Caching and Reuse (Flyweight Factory):**Once a flyweight object is created, it is "cached and reused whenever required."
    - A "Flyweight Factory" is used to manage this caching. It typically uses a Map where the **key is a combination of intrinsic data** (or a unique identifier for the shared object) and the value is the flyweight object.
    - Before creating a new object, the factory checks the cache: "if robot type is present into the cache I will return the object if not then I will create one humanoid robot."

## **6. Practical Demonstrations:**

Gaming Scenario (Robots): Refer the code

![image.png](Flyweight%20Design%20Pattern%20-%20Memory%20Optimization/image.png)

Word Processor/Text Editor: Refer the code