# Observer Design Pattern

https://www.youtube.com/watch?v=Ep9_Zcgst3U

## **1. Introduction to the Observer Design Pattern**

The Observer Design Pattern is a behavioral design pattern that defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. The pattern involves two main types of objects:

- **Observable (Subject):** The object whose state is being observed.
- **Observer:** The object that observes the Observable's state and performs actions when notified of changes.

**Key Concept: The Observer Design Pattern**

In the **Observer Design Pattern**, there are two primary objects:

1. **Observable**: This object has a state. Whenever this state changes, for example, from one state to another, the Observable is responsible for notifying all its registered Observers.

2. **Observer**: There can be multiple Observers. These Observers are "observing" the Observable object. When the Observable's state changes, it updates all the Observers, informing them that its state has changed and that they can perform any necessary actions. This update mechanism occurs every time the Observable's state changes, whether from State 1 to State 2, or State 2 to State 3, and so on.

![image.png](Observer%20Design%20Pattern/image.png)

## **2. Core Components and Implementation Details**

The implementation of the Observer Design Pattern typically involves the following interfaces and concrete classes:

### 2.1. Observable Interface (Subject)

This interface defines methods for managing observers.

- **add(Observer obj) / register(Observer obj)**: This method is used to add an observer to the Observable's internal list of dependents. It takes an `Observer` object as a parameter, and is also known as "register" or "registration" for an observer. The Observable interface itself "keeps its object" to determine which observer to add. In a concrete implementation, this method would add the observer object to an internal list.
- **remove(Observer obj)**: This method is used to remove an observer from the Observable's internal list. Similar to `add`, it takes an `Observer` object as a parameter, and in a concrete class, it would remove that object from the list.
- **notify()**: This method is responsible for notifying all registered observers about a state change. It typically does not take any input parameters and its function is to iterate through the internal list of observers and invoke their `update` method.
- **setData(Object data)**: Although sometimes overlooked, the source highlights this method as very useful. It allows for setting or updating the Observable's internal data, such as a stock count or temperature. Crucially, this method can encapsulate **business logic** to decide *when* to call the `notify()` method. For instance, if the stock count changes from zero to a positive number, `setData` can trigger `notify` to alert all observers.
- **Internal Data Structure**: The Observable maintains an internal data structure, specifically a **List<Observer Interface>**, to keep track of all its registered observers. This list holds all the `Observer` objects that are observing the Observable. The `add`, `remove`, and `notify` methods all operate on this internal list. The relationship between an Observable and its Observers is a "has-a" or composition relationship, specifically a "zero-to-many" or "one-to-many" relationship, where one Observable can have multiple Observers

### **2.2. Concrete Observable Class**

This class implements the Observable interface.

- **add(Observer obj)**: This method takes an `Observer` object and adds it to the Observable's internal `List<Observer>`. For example, in a`NotificationAlertObserver` concrete class, this would add a `MobileAlertObserverImpl` to its `List<NotificationAlertObserver>`.
- **remove(Observer obj)**: This method removes a specified `Observer` object from the Observable's internal list of observers.
- **notify()**: This method has no input parameters. Its primary function is to iterate through the Observable's internal list of all registered observer objects and **invoke their update() method**.
- **setData(Object data)**: This method is considered crucial, even though it's sometimes overlooked, as it encapsulates **business logic** that determines *when* to trigger a notification. When `setData` is called with new data (e.g., a stock count, temperature, or any internal state), the concrete Observable can check if a significant change has occurred. If the data has indeed changed in a way that warrants notification (e.g., a product changing from "out of stock" to "available", or a new temperature value being different from the current one), the `setData` method will then **call the notify() method**. This allows the Observable to decide whether to notify based on specific conditions, rather than notifying on every single data change, which might not always be necessary.

### **2.3. Observer Interface**

This interface defines the method that concrete observers must implement to receive updates.

- **update():** This method is called by the Observable when its state changes.

### **2.4. Concrete Observer Class**

- **update() method**: This method is central to the observer's function. It contains the specific logic that the observer should execute when it is notified of a state change by the Observable. This is where the observer reacts to the Observable's updated state. For instance, in the Amazon stock notification example, when the `update()` method is called for an email observer, it would trigger a "send email" action. Similarly, for a mobile observer, it would trigger a "send message to mobile" action.
- **Constructor Injection (Preferred Method)**: The source strongly recommends **Constructor Injection** as the preferred way for a Concrete Observer to obtain a reference to its Observable, rather than passing the Observable object in the `update()` method.
- **Reasoning**: Passing the Observable object in the `update()` method can lead to issues such as needing `instanceof` checks and type-casting, especially when there are multiple types of Observable concrete classes that a single observer might be interested in (e.g., a mobile display observing a `WeatherStationObservable` and also a `CricketMatchScoreObservable`). This approach is not considered good practice.
- **Mechanism**: With Constructor Injection, the Concrete Observer receives the specific Observable object it is observing during its instantiation, within its constructor. This establishes a direct reference from the observer to the particular Observable it is interested in.
- **Benefit**: By receiving the Observable object in its constructor, the observer already has a reference to its Observable and can directly access its data (e.g., `observable.getData()`) without the need for the Observable to be passed as a parameter in the `update()` method

### 3. Example: Amazon "Notify Me" Feature (Walmart LLD Question)

The source uses a real-world scenario from a Walmart Low-Level Design (LLD) interview question to illustrate the Observer Pattern:

**Problem:** On Amazon's website, if a product (e.g., iPhone) is out of stock, a "Notify Me" option appears. When the product becomes available, all customers who clicked "Notify Me" for that product should receive a notification.

**Observer Pattern Application:**

- **Observable (Subject):** The iPhone product (or more generally, StockObservable). Its state is its stock count.
- **Observers:** Individual NotificationObserver objects (e.g., EmailAlertObserver, MobileAlertObserver) representing users who want to be notified.

**Implementation Steps (as described in the source):**

1. **StockObservable Interface:** Defines add, remove, notify, setStockCount, and getStockCount methods.
    - **iPhoneStockObservable (Concrete Observable):** Maintains a List<NotificationObserver>.
    - add() and remove() manage the observer list.
    - setStockCount(int newStock): This is where the core logic lies. If the newStock is greater than 0 **and** the previous stockCount was 0 (meaning it was out of stock and now became available), then notify() all observers. This prevents unnecessary notifications if the stock just changes from 5 to 10.
    - notify(): Iterates through its List<NotificationObserver> and calls update() on each.
2. **NotificationObserver Interface:** Defines the update() method.
    - **EmailAlertObserver (Concrete Observer):** Takes an StockObservable object in its constructor (constructor injection).
    - update(): Calls a sendEmail() method, indicating "Mail sent to [User's Email]". It can use the injected StockObservable to get current stock data if needed.
    - **MobileAlertObserver (Concrete Observer):** Takes an StockObservable object in its constructor.
    - update(): Calls a sendMessage() method, indicating "Message sent to [User's Mobile]".

**Flow of the "Notify Me" Example:**

1. An iPhoneStockObservable object is created.
2. Users click "Notify Me" for the iPhone. For each user, an EmailAlertObserver or MobileAlertObserver is created, passing the iPhoneStockObservable into its constructor, and then added to the iPhoneStockObservable's list of observers using add().
3. Initially, the iPhoneStockObservable's stock count might be 0.
4. When the stock count changes from 0 to a positive number (e.g., iphoneObservable.setStockCount(10)), the setStockCount method's logic detects this.
5. The iPhoneStockObservable then calls its notify() method.
6. notify() iterates through all registered observers and calls their update() method.
7. Each EmailAlertObserver sends an email, and each MobileAlertObserver sends an SMS, informing the user that the iPhone is back in stock.

### 4. Advanced Considerations / Best Practices

- **Constructor Injection:** This is highly recommended for Concrete Observers to access the Observable's data directly and avoid type-casting issues, especially when an observer might observe multiple types of Observables.
- **Business Logic in setData:** Embedding the notification trigger logic within the setData (or equivalent) method of the Observable allows for control over when notifications are sent, preventing unnecessary updates. For example, only notify if the state *actually* changed in a meaningful way (e.g., out of stock to in stock).
- **Loose Coupling:** The Observer Pattern promotes loose coupling between the Observable and its Observers. They interact through interfaces, meaning the Observable doesn't need to know the concrete types of its Observers, and Observers don't need to know the concrete type of the Observable beyond its interface.

### **5. Conclusion**

The Observer Design Pattern is a powerful and widely used pattern for implementing reactive systems where changes in one object need to trigger actions in multiple other objects. It effectively solves problems like the Amazon "Notify Me" feature by providing a flexible and decoupled way for objects to communicate state changes.