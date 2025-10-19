# Singleton Design Pattern

https://www.youtube.com/watch?v=fs6ZUcF-nuc

https://www.youtube.com/watch?v=zHWusHi9Nt0

## **1. Introduction to the Singleton Design Pattern**

The Singleton Design Pattern is a **creational design pattern** focused on object creation. Its primary purpose is to **ensure that a class has only one instance and provides a global point of access to that instance.**

- **Core Idea:** If we need to create an object only once within our project... this means the Singleton object will help us; this object will be created only once, and we can use it repeatedly.
- **Purpose:** To prevent multiple instances of a class from being created, ensuring that all parts of the application use the exact same object.
- **Naming Convention:** The name "Singleton" signifies " a single object, Singleton object.

## **2. Why Use the Singleton Pattern? (Use Cases)**

The Singleton pattern is particularly useful in scenarios where a single point of control or a shared resource is required across an application.

- **Database Connections:** A classic example is managing database connections. Instead of creating a new connection for every operation (insert, delete, update, read), a Singleton ensures that only one connection is established and reused.
- Suppose you are working with a database... the best example is JDBC. In a JDBC program, you need to perform CRUD operations... your application and your database connection don't need to be created repeatedly; they need to be created only once. In that case, we create a Singleton object..
- **Logging:** A single logging instance can manage all log outputs consistently.
- **Configuration Managers:** A single configuration object can hold application settings, accessible globally.

### 3. Implementing the Singleton Pattern (Lazy Initialization Example)

The source details a common implementation strategy for Singleton, focusing on lazy initialization.

**Key Principles for Singleton Implementation:**

1. **Private Constructor:** The constructor of the Singleton class must be private. This prevents external classes from directly instantiating the class using new.
    - First thing, the constructor must be private because no one should be able to call the constructor, as calling it would lead to repeated object creation.
2. **Private Static Instance Variable:** A static, private variable of the class's type is used to hold the single instance. It is initialized to null.
    - `private static JdbcConnection *jdbcConnection*;`
3. **Public Static "Factory" Method:** 
    
    A public static method (often named getInstance or get[ClassName]) is provided to return the single instance of the class. This method handles the creation of the instance if it doesn't already exist.
    
    - Now, to create it, we should have a method that creates an object of this class... we will make it public, its return type will be `JdbcConnection`, and we will name it `getJdbcConnection`.
    - **Lazy Initialization Logic (within** `getJdbcConnection`**):** Check if the instance variable (`*jdbcConnection*`) is null.
    - If null, create a new instance and assign it to the instance variable.
    - Return the instance.

## **4. Initialization Strategies: Lazy vs. Eager**

The source discusses two main strategies for initializing the Singleton instance:

- **Lazy Initialization:** The instance is created only when it is first requested (i.e., the getInstance method is called for the first time).
    - **Pros:** Resource-efficient if the instance is not always needed. It will be created simply when needed.
    - **Cons:** Can have performance overhead on the first call, and **is not thread-safe by default in multi-threaded environments** (discussed below).
- **Eager Initialization:** The instance is created at the time the class is loaded by the JVM, often by initializing the static instance variable directly.
    - **Pros:** Simple to implement and inherently thread-safe (as the instance is created before any threads can access it.
    - **Cons:** Not resource-efficient if the instance is heavy and not always used. For example, the client didn't need this object at all throughout the project, didn't need `NetworkConnection`at all, but in the eager way, the object has already been created... it's like, if needed, take it, otherwise, don't; we have to create it anyway.
    - This is not a good approach in terms of usage; it can also degrade our project's performance because if it's not being used, then there will be a problem.

## **5. Thread Safety in Singleton**

The source highlights a critical issue with the basic lazy initialization approach: **it is not thread-safe in multi-threaded environments.**

- **The Problem:** If multiple threads attempt to access the `getJdbcConnection`method concurrently when the instance is null, it's possible for more than one thread to find the instance as null and subsequently create a new object, violating the Singleton principle.
- **Solutions for Thread-Safe Singleton:**
1. **Synchronized Method:** Synchronize the entire `getJdbcConnection` method.
    - This method, from where it starts to where it ends, only one thread can access it at a time because you have used synchronized here.)
    - **Pros:** Simple to implement.
    - **Cons:** Performance overhead because the entire method is locked, even after the instance has been created. Subsequent calls still incur synchronization overhead, which is unnecessary. We only need to synchronize this specific line; if there's a lot of code above and below it, then in that case, while one thread is executing this line, others might have to wait just to get the object, which is not a good approach.
2. **Synchronized Block (Double-Checked Locking):** This is a more optimized approach where synchronization is applied only to the critical section where the instance is created, and an additional check is performed inside the synchronized block.
    - We are not going to block unnecessary lines; we will apply synchronization only if `*jdbcConnection*`is null... we will use a block here, and whatever you write inside it, only one thread will be able to use it at a time.
    - **Pros:** Improves performance over method synchronization as the lock is acquired only once when the instance is created. Subsequent calls bypass the synchronized block.
    - This is a good approach if you are working in a threaded environment; you should use this approach to create the Singleton.

## **6. Breaking the Singleton Pattern**

The source details three primary ways to break the Singleton pattern, allowing the creation of multiple instances:

1. **Using Reflection API:** 

The Reflection API in Java allows dynamic inspection and manipulation of classes, interfaces, fields, and methods at runtime. This capability can be leveraged to bypass the private constructor restriction of a Singleton class.

**Process:**

1. **Load the class:** Obtain a Class object for the Singleton class (e.g., `JdbcConnection`.class).
2. **Get the declared constructor:** Use getDeclaredConstructor() on the Class object to access the private constructor. This returns a Constructor object.
3. **Make the constructor accessible:** By default, private constructors cannot be invoked directly. The setAccessible(true) method on the Constructor object changes its accessibility, effectively making it public.
4. **Create a new instance:** Invoke the constructor using newInstance() on the Constructor object. This creates a new instance, bypassing the Singleton's control.
1. **Using Serialization/Deserialization:** 

Serialization is the process of converting an object into a byte stream, and deserialization is the process of reconstructing the object from that byte stream. When a Singleton object is serialized and then deserialized, a new instance of the object might be created if not handled properly, thus breaking the Singleton pattern.

**Process:**

1. **Serialize the first instance:** Write the existing Singleton instance to a file using ObjectOutputStream and FileOutputStream.
2. **Deserialize to create a second instance:** Read the object from the file using ObjectInputStream and FileInputStream. This process can create a new object in memory, distinct from the original Singleton instance.

**Observation (from the source):** After serializing and deserializing, comparing the original and the deserialized objects shows they are different, indicating the Singleton pattern has been broken.

1. **Using Cloning:**

Cloning allows an object to create a copy of itself. If a Singleton class implements the Cloneable interface and overrides the clone() method without proper restrictions, external code can create copies of the Singleton instance, violating its principle.

**Process:**

1. **Implement Cloneable:** The Singleton class must implement the Cloneable interface.
2. **Override clone():** Override the clone() method (typically calling super.clone()).

**Observation (from the source):** Calling the clone() method on a Singleton instance will create a new, distinct object if the same reference is returned, breaking the pattern.

## **7. Solutions to Protect the Singleton Pattern**

1. **Protection Against Reflection Attacks:**

To prevent Reflection from creating multiple instances, the Singleton class's constructor should include a check:

**Solution 1: Throw an Exception** Inside the private constructor, check if an instance of the class already exists. If it does, throw a RuntimeException (or a custom exception) to prevent the creation of a second instance.

Solution 2: Use ENUM instead of class

1. **Protection Against Serialization/Deserialization Attacks:**

To ensure that deserialization returns the same Singleton instance, the class needs to implement the readResolve() method.

**Solution: Override readResolve() Method** The readResolve() method is a special method in Java's serialization mechanism. If a class defines this method, it's called after the object has been read from the stream. Whatever object readResolve() returns is the object that is actually returned to the caller, effectively replacing the deserialized object.

**Implementation:** The readResolve() method should simply return the existing Singleton instance (e.g., JdbcConnection.getInstance()).

1. **Protection Against Cloning Attacks:**

To prevent cloning from creating new instances, the clone() method should either throw a CloneNotSupportedException or return the existing Singleton instance.

**Solution: Override clone() to return the existing instance** The clone() method should be overridden to return the current Singleton instance, rather than creating a new one.

**Implementation:** Override the clone() method to simply return JdbcConnection.getInstance().

## **8. Best Practices and Additional Notes**

- **Thread Safety:** The source implies that the same protection mechanisms can be integrated with thread-safe Singleton implementations.
- **Interview Importance:** The presenter emphasizes that these concepts are frequently asked in interviews.
- **Holistic Understanding:** It's crucial to understand both how to create a Singleton and how to protect it from being broken.