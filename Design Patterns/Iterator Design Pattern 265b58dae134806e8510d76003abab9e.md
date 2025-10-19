# Iterator Design Pattern

https://www.youtube.com/watch?v=YLAwNBHrLOc

https://www.youtube.com/watch?v=X7shKHOaYtU

An iterator is a behavioral design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).

The core themes of the Iterator Design Pattern revolve around **standardizing traversal** and **decoupling iteration logic from data structure implementation**

## **Problem**

Collections are one of the most used data types in programming. Nonetheless, a collection is just a container for a group of objects.

![image.png](Iterator%20Design%20Pattern/image.png)

Most collections store their elements in simple lists. However, some of them are based on stacks, trees, graphs and other complex data structures.

But no matter how a collection is structured, it must provide some way of accessing its elements so that other code can use these elements. There should be a way to go through each element of the collection without accessing the same elements over and over.

This may sound like an easy job if you have a collection based on a list. You just loop over all of the elements. But how do you sequentially traverse elements of a complex data structure, such as a tree? For example, one day you might be just fine with depth-first traversal of a tree. Yet the next day you might require breadth-first traversal. And the next week, you might need something else, like random access to the tree elements.

![image.png](Iterator%20Design%20Pattern/image%201.png)

Adding more and more traversal algorithms to the collection gradually blurs its primary responsibility, which is efficient data storage. Additionally, some algorithms might be tailored for a specific application, so including them in a generic collection class would be weird.

On the other hand, the client code that’s supposed to work with various collections may not even care how they store their elements. However, since collections all provide different ways of accessing their elements, you have no option other than to couple your code to the specific collection classes.

When working with collections (like ArrayList, HashSet, TreeSet in Java, or custom data structures storing multiple objects), a common need is to access and process each object individually.

The challenge arises because different data structures store data in different ways, requiring unique traversal logic for each. For instance, If you use ArrayList, you might iterate through elements and get values; but if you use HashSet, the traversal implementation will be different.

This leads to client code being tightly coupled to the underlying data structure's implementation, making it difficult to switch data structures without modifying the iteration logic.

## **Solution**

The main idea of the Iterator pattern is to extract the traversal behavior of a collection into a separate object called an *iterator*.

![image.png](Iterator%20Design%20Pattern/image%202.png)

In addition to implementing the algorithm itself, an iterator object encapsulates all of the traversal details, such as the current position and how many elements are left till the end. Because of this, several iterators can go through the same collection at the same time, independently of each other.

Usually, iterators provide one primary method for fetching elements of the collection. The client can keep running this method until it doesn’t return anything, which means that the iterator has traversed all of the elements.

All iterators must implement the same interface. This makes the client code compatible with any collection type or any traversal algorithm as long as there’s a proper iterator. If you need a special way to traverse a collection, you just create a new iterator class, without having to change the collection or the client.

The Iterator Design Pattern provides a **common and standardized way to traverse elements** in a collection, regardless of its internal structure.

The Iterator Design Pattern states that you should implement this design pattern, and we will provide you with a common way to traverse any type of object if that object follows the Iterator Design Pattern.

The key benefit is that it **hides the internal implementation details** of the collection from the client code. The pattern provides a way to access the elements of an object without exposing its underlying implementation, meaning we don't have to reveal the implementation, and the user can traverse our object without knowing it.

## Structure

![image.png](Iterator%20Design%20Pattern/image%203.png)

### **Iterator Interface and its Methods**

- The Iterator Design Pattern primarily consists of a simple **interface** (e.g., MyIterator in the example written in IntelliJ IDE).
- This interface defines two essential methods:
    - hasNext(): This method returns a boolean value (true or false). This will tell you true if there is a next element, otherwise false. It checks if there are more elements to traverse.
    - next(): This method returns the next element in the collection and increases the internal pointer. This next method provides us with the next element.
1. **Implementation Example Walkthrough:**
- The source demonstrates implementing the Iterator pattern for a UserManagement class that internally uses an ArrayList to store User objects.
    - **User Class:** A simple class with a name field.
    - **UserManagement Class:** Contains an ArrayList<User> (or any other data structure) to store users.
    - Provides addUser() and getUser(index) methods.
    - Crucially, it provides a getIterator() method which returns an instance of MyIterator (specifically MyIteratorImpl). This method **hides the internal collection type**.
    - **MyIterator Interface:** Declares hasNext() and next() methods.
    - **MyIteratorImpl Class: Implements** the MyIterator interface.
    - Takes the actual collection (e.g., List<User>) in its constructor.
    - Maintains an internal position variable to keep track of the current element during traversal.
    - hasNext() implementation: Checks if the position is less than the collection's size. If the position is greater than or equal to the length, it returns false.
    - next() implementation: Retrieves the element at the current position, increments the position, and returns the retrieved element.
1. **Client-Side Usage:**
- The client code (e.g., the Main application) first gets an instance of UserManagement.
- It adds User objects to UserManagement.
- To traverse, it obtains an iterator using userManagement.getIterator().
- It then uses a while loop with myIterator.hasNext() as the condition and myIterator.next() to retrieve and process each element.
- As long as hasNext returns true, we will keep looping. As long as there are elements ahead, the loop will continue, and we will call myIterator.next() to get the object.
- This client code remains **unaware** of whether UserManagement uses an ArrayList, LinkedList, or any other internal collection. If the internal collection changes, only MyIteratorImpl needs modification, not the client code.

### Conclusion

The Iterator Design Pattern is fundamental and frequently used (often implicitly with built-in collection iterators). It effectively addresses the challenge of traversing diverse data structures by providing a universal interface and decoupling the client code from the intricate details of data storage and retrieval. This promotes code reusability, maintainability, and flexibility, making it easier to change underlying data structures without impacting the iteration logic in client applications.