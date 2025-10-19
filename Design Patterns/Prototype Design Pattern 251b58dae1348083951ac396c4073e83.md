# Prototype Design Pattern

https://www.youtube.com/watch?v=rriiXRdc0HQ

https://www.youtube.com/watch?v=bmVElHDhBP8

https://www.youtube.com/watch?v=lvv2ePs6H6w

Prototype Design Pattern is a creational design pattern that focuses on creating objects by copying an existing object (the prototype) instead of creating new instances from scratch. This approach offers significant benefits, particularly in scenarios involving complex or costly object creation processes.

## **Key Themes and Concepts:**

### **1. What is the Prototype Design Pattern?**

- The Prototype Design Pattern is a **creational design pattern**, meaning it deals with object creation.
- Its core principle is to **create new objects by copying an existing object**, rather than constructing them from scratch. This process is often referred to as "cloning."
- The source states: "Prototype design pattern yeh kehta hai ki bhai agar hum koi object bana rahe hain kisi class ka aur wo object banate samay koi complex logic execute kar rahe hain… toh aap bar-bar us object ko direct mat create kariye… **copy an existing object rather than creating a new instance from scratch**."

### **2. Why Use the Prototype Design Pattern? (Benefits)**

The primary motivation for using this pattern is to **avoid repetitive execution of complex or costly logic** during object creation.

- **Cost and Time Saving:** When object creation involves "complex logic" (e.g., database connections, reading large files, network calls), repeatedly executing this logic is inefficient and costly in terms of time and resources.
    - "Jitni bar aap us object ko create karenge utni bar complex logic execute hoga."
    - "Database se connection bar-bar costly hota hai."
    - "Agar heavy process hai toh wahan par time bhi save karega aur cost resources bhi save karega."
- **Resource Optimization:** By reusing an already initialized object, the pattern conserves resources that would otherwise be spent on repeated initialization.
- "Ek bar object create ho gaya toh aap phir dobara naya object mat create kariye."
- **Reduced Overhead:** It eliminates the overhead associated with instantiating a new object and running its full initialization logic every time an object is needed.

### **3. When to Use the Prototype Design Pattern:**

This pattern is particularly beneficial in situations where:

- **Object creation is expensive:** This includes operations like:
    - Connecting to a database.
    - Reading large files.
    - Making network calls.
    - Any other logic that is computationally intensive or time-consuming.
- **You need many instances of an object that are similar:** Instead of creating each one independently, you create one "prototype" and then clone it as needed, making minor modifications if necessary.

### **4. How Cloning Works (Technical Implementation in Java):**

The source provides a practical example in Java to demonstrate cloning.

- **Cloneable Interface:** To enable cloning, a class must implement the Cloneable marker interface.
    - "Hume `NetworkConnection` mein implement karna padega `Cloneable`interface."
    - "Yeh class Clone ki ja sakti hai agar yeh implement kiya ho to, nahi laga hoga toh marker interface yeh nahi bata payega ki Cloneable ki ja sakti hai."
- **Overriding clone() Method:** The class must override the Object class's clone() method.
- The clone() method typically involves calling super.clone() to perform a shallow copy.
- **CloneNotSupportedException:** The clone() method can throw CloneNotSupportedException, which must be handled.
- **Example Scenario (Network Connection):**The example uses a NetworkConnection class with a loadImportantData() method that simulates a time-consuming operation.
- Initially, creating a NetworkConnection object and loading data takes time.
- After the first object is created, subsequent objects (networkConnection2, networkConnection3) are created using networkConnection.clone().
- The key observation is that the cloned objects do not re-execute the loadImportantData() method, significantly reducing creation time.
- "Pehle object create hone mein time laga, create hone ka matlab data ko load hone mein time laga aur then uske baad hume time nahi laga kyunki humne cloning kar li."

### **5. Shallow vs. Deep Cloning:**

- The source briefly mentions these concepts as important for future discussion and interviews.
- **Shallow cloning** typically copies the values of the fields from one object to another. If a field is a reference to another object, only the reference is copied, not the object itself.
- **Deep cloning** creates a completely independent copy, including all referenced objects. This is crucial when the cloned objects need to be fully independent of the original.

### **6. Real-World Analogy:**

- The source uses an analogy of buying a bike: "Ek bar apne ghar mein, aap ek bar bike lete ho aur bike agar wahi bike dobara se use ho sakti hai toh aap nayi bike kyun loge kyunki nayi bike lage toh bhai wahan par paisa bhi jyada padega."
- It acknowledges that this is not literally possible in the real world but is analogous to how virtual object cloning works. "Real world mein ye cheez possible nahi hai ki hum ek bike ki ek copy bana ke de new kare but virtual world mein hum ek object ki copy bana ke aur use kar sakte hain usko as on new object."

### Conclusion:

The Prototype Design Pattern is a powerful tool for optimizing object creation, particularly when dealing with complex or resource-intensive initialization processes. By enabling the cloning of existing objects, it saves time, reduces cost, and improves application performance. Understanding the concepts of shallow and deep cloning is crucial for effective implementation