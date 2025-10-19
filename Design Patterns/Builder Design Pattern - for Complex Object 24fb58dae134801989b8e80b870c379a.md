# Builder Design Pattern - for Complex Object

https://www.youtube.com/watch?v=4ff_KZdvJn8&list=PLTCrU9sGybuo3HIJUKusfhB_m7QucuDTQ&index=4

## **1. Introduction to the Builder Design Pattern**

The Builder Design Pattern is a **creational design pattern** utilized for the creation of objects. Its primary purpose is to address the challenges associated with constructing **complex objects**, especially when these objects have constructors with a large number of parameters, some of which may be optional. The pattern promotes a clear separation between the construction of an object and its representation.

**Key takeaway:** The Builder Pattern is for creating complex objects, especially when constructors become unwieldy due to many parameters.

## **2. Problems Solved by the Builder Design Pattern**

**Complex Constructors / "Telescoping Constructors"**:

- **Problem:** When a class has many fields, some optional, using standard constructors requires creating numerous constructor overloads (a "telescoping constructor" approach).
- This leads to:
    - **Code Duplication:** "How many permutations and combinations you would have to manage in order to create those constructors."
    - **Maintainability Issues:** Adding a new field requires updating multiple constructors, potentially introducing null values for optional parameters not included in a specific constructor.
    - **Readability Issues:** It can be unclear which parameters are being set when calling a constructor with many arguments, especially if many are of the same type.
    - **Example (Wardrobe):** A wardrobe can have doors, mirrors, hanging rods, compartments, and wheels. Some features (mirror, wheels) are optional. A standard approach would involve multiple constructors like Wardrobe(doors, mirror), Wardrobe(doors, mirror, wheels), etc., making it hard to create a Wardrobe with just doors, mirrors, and compartments without having to pass null for hanging rods and wheels.
    - **Example (URL):** A URL consists of protocol, host name, port, path param, and query param. Protocol and host name are essential, while port, path param, and query param are optional. Traditional constructors would necessitate "a lot of constructors" to handle all combinations of optional parameters.
    - **Telescoping Constructor Limitation:** While telescoping constructors (where one constructor calls another with more parameters) reduce code length, they "do not solve the problem of having multiple combinations" for optional parameters. "In that case you would have to write another constructor and thus telescope constructors do not solve the problem hundred percent”.
    - **Immutability:** The Builder Pattern facilitates the creation of **immutable objects**. Once an object is built using the pattern, its state cannot be changed, as setters are often not exposed or not needed. "The class instance written by the builder pattern is immutable so you cannot make any changes to that object”.
    - **Reduced Need for Setters:** By constructing the object through the builder, there is "less need for exposing the setters of a class," contributing to immutability and controlled object creation.

## **3. Analogy and Core Concept**

![image.png](Builder%20Design%20Pattern%20-%20for%20Complex%20Object/image.png)

The source uses a **wardrobe building analogy** to illustrate the problem: "Let's consider a scenario of building a wardrobe as you know wardrobes can be of multiple types they can have one door two doors multiple doors there can or cannot be mirrors on the wardrobes also the material of the wardrobe can be metal wood plastic or something else there can be a feature of hanging rods in the wardrobes and the number of compartments in a wardrobe can vary some wardrobes might might come with wheels as well as you might have guessed by now that some features in the wardrobes are going to be essential like the doors and logs and so on but some features like the mirror on the wardrobe door or the wheels might be optional for some particular wardrobes.

This analogy perfectly highlights the challenge of managing various combinations of essential and optional features when creating an object. The Builder Pattern addresses this by allowing you to specify only the features you need

## **4. Implementing vs. Using a Builder Pattern**

![image.png](Builder%20Design%20Pattern%20-%20for%20Complex%20Object/image%201.png)

The source distinguishes between *using* and *implementing* a builder pattern:

- **Using a Builder Pattern:** This refers to utilizing an existing builder class provided by a library or framework.
    - **Example:** Java's StringBuilder. You initialize StringBuilder, keep appending the strings onto the builder, and finally call sb.toString()."This is a utilization of a builder pattern because a stringbuilder is a builder class that helps you to concatenate strings one after the other and finally returns you a string which you cannot change.
- **Implementing a Builder Pattern:** This involves writing the builder class yourself for a specific use case. The source provides a detailed example of implementing a URLBuilder.

## **5. Implementation Details (URL Builder Example)**

![image.png](Builder%20Design%20Pattern%20-%20for%20Complex%20Object/image%202.png)

## 6. Pros and Cons of the Builder Pattern

**Pros:**

- **Handles Complexity:** "It is a good way to handle complexity and complex constructors."
- **Ease of Implementation:** "It is relatively easy to implement than other patterns." It typically involves an inner static class in Java.
- **Refactoring Capability:** "This is a pattern that you can refactor your code later into. This is not a pattern that you have to start implementing from scratch."

**Cons:**

- **Immutability (Potential Con):** "The class instance written by the builder pattern is immutable, so you cannot make any changes to that object." While often a pro, this can be a con if mutability is required after creation.
- **Inner Static Class:** "It uses an inner static class for implementation, which might seem confusing to some folks sometimes."
- **Increased Code Lines:** "Sometimes the number of lines of code that you have to write can become huge in order to implement a builder pattern, although it is not that complex."
- **Design Consideration:** "Whenever you're using the builder pattern or refactoring your code into the builder pattern, you have to think of end-to-end use cases, so you have to think of design." This isn't a direct con but a necessary consideration.

Where have you used this Pattern in previous work?

In CHReME at C-DAC, I used the Builder pattern to create complex HPC job submission requests with many optional parameters like CPU, memory, and priority. The builder let us set only the needed fields step-by-step and produce an immutable request object. This made the code cleaner, easier to maintain, and adaptable when new parameters were added.