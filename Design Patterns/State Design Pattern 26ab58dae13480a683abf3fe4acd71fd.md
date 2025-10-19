# State Design Pattern

https://www.youtube.com/watch?v=wOXs5Z_z0Ew

https://refactoring.guru/design-patterns/state

## **Intent**

**State** is a behavioral design pattern that lets an object alter its behavior when its internal state changes. It appears that the object has changed its class.

The State Design Pattern is employed when an object's behavior changes based on its internal state.

## **Problem**

The State pattern is closely related to the concept of a *Finite-State Machine*

![image.png](State%20Design%20Pattern/image.png)

The main idea is that, at any given moment, there’s a *finite* number of *states* which a program can be in. Within any unique state, the program behaves differently, and the program can be switched from one state to another instantaneously. However, depending on a current state, the program may or may not switch to certain other states. These switching rules, called *transitions*, are also finite and predetermined.

You can also apply this approach to objects. Imagine that we have a `Document` class. A document can be in one of three states: `Draft`, `Moderation` and `Published`. The `publish` method of the document works a little bit differently in each state:

- In `Draft`, it moves the document to moderation.
- In `Moderation`, it makes the document public, but only if the current user is an administrator.
- In `Published`, it doesn’t do anything at all.

![image.png](State%20Design%20Pattern/image%201.png)

State machines are usually implemented with lots of conditional statements (`if` or `switch`) that select the appropriate behavior depending on the current state of the object. Usually, this “state” is just a set of values of the object’s fields. Even if you’ve never heard about finite-state machines before, you’ve probably implemented a state at least once.

Even if you’ve never heard about finite-state machines before, you’ve probably implemented a state at least once. Does the following code structure ring a bell?

![image.png](State%20Design%20Pattern/image%202.png)

The biggest weakness of a state machine based on conditionals reveals itself once we start adding more and more states and state-dependent behaviors to the `Document` class. Most methods will contain monstrous conditionals that pick the proper behavior of a method according to the current state. Code like this is very difficult to maintain because any change to the transition logic may require changing state conditionals in every method.

The problem tends to get bigger as a project evolves. It’s quite difficult to predict all possible states and transitions at the design stage. Hence, a lean state machine built with a limited set of conditionals can grow into a bloated mess over time.

## **Solution**

The State pattern suggests that you create new classes for all possible states of an object and extract all state-specific behaviors into these classes.

Instead of implementing all behaviors on its own, the original object, called *context*, stores a reference to one of the state objects that represents its current state, and delegates all the state-related work to that object.

![image.png](State%20Design%20Pattern/image%203.png)

To transition the context into another state, replace the active state object with another object that represents that new state. This is possible only if all state classes follow the same interface and the context itself works with these objects through that interface.

This structure may look similar to the [**Strategy**](https://refactoring.guru/design-patterns/strategy) pattern, but there’s one key difference. In the State pattern, the particular states may be aware of each other and initiate transitions from one state to another, whereas strategies almost never know about each other.

## **Vending Machine Design: A Deep Dive into the State Design**

![image.png](State%20Design%20Pattern/image%204.png)

![image.png](State%20Design%20Pattern/image%205.png)

### 1. Identifying the Problem: State-Wise Operations

The fundamental observation that leads to using the State Design Pattern is that a vending machine exhibits **"state-wise operations."** This means:

- **Different operations are allowed/disallowed based on the current state of the machine.**
- "When the vending machine was idle, what operations could I do? I could only press the 'insert cash' button."
- "In the 'hasmoney' state, what can I do? I can insert coins, select a product, or cancel/refund."
- "In the 'selection' state, I can choose a product or cancel/refund, but I cannot insert coins (they are already inserted)."

This pattern, where specific operations are only permitted in certain states, is a clear indicator of the State Design Pattern. Other examples include designing a TV (on/off states, with different operations in each).

### 2. Core Vending Machine Features & Flow (Assumptions)

The design is based on a "most common" vending machine, with the following features and a typical "happy flow":

**Features:**

- **Product Storage:** "Rows and columns where products are stored, and each product has a code and a price." (e.g., Pepsi, soda, water, juice).
- **Cash Insertion:** Accepts coins/cash, initiated by an "insert cash button."
- **Product Selection:** Users select a product by entering its code via a "select product button."
- **Change Dispensing:** Returns change if excess money is inserted.
- **Refunds:** A "cancel button" allows users to get a full refund.
- **Product Dispensing:** Dispenses the selected product if conditions are met.

**Happy Flow (Normal Operation):**

1. **Idle:** The Vending machine is inactive.
2. **Press Insert Cash Button:** User initiates interaction.
3. **Has Money State:** Machine starts accepting coins. User inserts coins.
4. **Press the Select Product Button:** User indicates they're done inserting money and want to select a product.
5. **Selection State:** User enters a product code (e.g., 106 for soda).
- **Sufficient Money & Product Available:** Dispenses product.
- If extra money was paid, it gives change.
1. **Dispense Product State:** Product is dispensed.
2. **Idle:** Machine returns to the idle state.

**Other Scenarios:**

- **Refund from "Has Money" State:** User can press "cancel" to get a refund and return to "Idle."
- **Refund from "Selection" State:** User can press "cancel" or if "insufficient fund" is detected, a refund is issued, and the machine returns to "Idle."

### 3. The State Design Pattern Explained

The State Design Pattern is employed when an object's behavior changes based on its internal state. It suggests:

- **Interface for States:** Create an interface (e.g., State) that defines all possible operations applicable to the product (vending machine).
- **Concrete State Classes:** Implement this interface for each distinct state of the product (e.g., IdleState, HasMoneyState, SelectionState, DispenseState).
- Each concrete state class implements only the operations relevant to its state effectively. "If a one-state only cares about one operation, it will implement it well; for all others, it will provide a default behavior or throw an exception."
- **Context/Product Class (Vending Machine):** This class holds a reference to the current state object. It delegates state-specific behavior to the current state object.
- "The product has an object called state... what is its current status?"
- Operations in the state classes often take the "product object" as a parameter. "Because if I perform an operation, I might want to change the product's status."

**UML Diagram Representation:**

1. **State Interface:** Defines methods like pressInsertCashButton(), insertCoin(), selectProductButton(), chooseProduct(), getChange(), refund(), dispenseProduct(), updateEntry().
- **Concrete State Implementations: IdleState:** Primarily implements pressInsertCashButton() (to transition to HasMoneyState). All other operations typically throw exceptions or provide default/no-op behavior.
- **HasMoneyState:** Implements insertCoin() (accepts coins), selectProductButton() (to transition to SelectionState), and refund() (to transition to IdleState).
- **SelectionState:** Implements chooseProduct() (processes selection), getChange() (if needed), and refund() (to IdleState).
- **DispenseState:** Primarily implements dispenseProduct() (dispenses the item and transitions to IdleState).
- **VendingMachine Class:** Holds a State object (currentState).
- Holds an Inventory object (list of ItemSelf objects).
- Holds a list of Coin objects (to track inserted money).
- Delegates all operations to its currentState object.

### 4. Vending Machine Components

Beyond the State Design Pattern, the vending machine itself requires specific data structures:

- **Item:** Represents a product, containing itemType (e.g., Pepsi, Juice, Soda) and price.
- **ItemSelf:** Represents a slot in the vending machine, containing a codeNumber, an Item object, and a boolean isSold flag.
- **Inventory:** Manages the collection of ItemSelf objects (essentially an array of ItemSelf).
- **Coin (or equivalent):** Represents the denominations of currency accepted.

### 5. Flow with State Transitions (Code Walkthrough)

The core idea is that when an action occurs, the VendingMachine (the context) calls the corresponding method on its currentState object. This method then performs the action and **crucially, updates the VendingMachine's currentState to the next appropriate state.**

**Example Execution Trace:**

- **main method:**Creates VendingMachine object.
- VendingMachine is initialized in IdleState.
- Fills inventory.
- **vendingMachine.clickOnInsertCoinButton():**Delegates to IdleState.clickOnInsertCoinButton(vendingMachine).
- IdleState prints "You clicked on the insert coin button" and then executes vendingMachine.setMachineState(new HasMoneyState()).
- **State Transition: Idle -> HasMoneyState.**
- **vendingMachine.insertCoin(Coin.NICKEL), vendingMachine.insertCoin(Coin.QUARTER):**Delegates to HasMoneyState.insertCoin(vendingMachine, coin).
- HasMoneyState adds the coin to the vendingMachine's internal coin storage.
- **State remains HasMoneyState.**
- **vendingMachine.clickOnProductSelectionButton():**Delegates to HasMoneyState.clickOnProductSelectionButton(vendingMachine).
- HasMoneyState executes vendingMachine.setMachineState(new SelectionState()).
- **State Transition: HasMoneyState -> SelectionState.**
- **vendingMachine.chooseProduct(vendingMachine, 102):**Delegates to SelectionState.chooseProduct(vendingMachine, code).
- SelectionState retrieves the item (e.g., code 102, price 12).
- Compares totalAmountPaid (e.g., 30) with itemPrice (12).
- Since totalAmountPaid > itemPrice:
- Calculates change (30 - 12 = 18).
- Calls vendingMachine.getChange(18) (which is delegated to SelectionState.getChange() and returns the change).
- Executes vendingMachine.setMachineState(new DispenseState()).
- **State Transition: SelectionState -> DispenseState.**
- **DispenseState (entry action implicitly handled by state change):**DispenseState.dispenseProduct(vendingMachine, code) is called.
- It prints "Product has been dispensed."
- Updates the ItemSelf to isSold = true.
- Executes vendingMachine.setMachineState(new IdleState()).
- **State Transition: DispenseState -> IdleState.**

This demonstrates how the State Design Pattern allows for clean, organized state management, with state transitions explicitly handled within the state classes, preventing complex conditional logic (if-else or switch) in the main VendingMachine class.

### 6. Benefits of State Design Pattern

- **Improved Readability and Maintainability:** Each state's behavior is encapsulated in its own class, making it easier to understand and modify specific state logic without affecting others.
- **Reduces Conditional Complexity:** Eliminates large if-else or switch statements that would otherwise be needed to manage state-dependent behavior.
- **Easier to Add New States:** New states can be added by simply creating a new concrete state class, without modifying existing code.
- **Encapsulates State-Specific Behavior:** Promotes better organization and separation of concerns.

This approach is highly recommended for interview questions like "Design Vending Machine" or "Design TV" where state-dependent behavior is prominent.

## **Applicability**

- **Use the State pattern when you have an object that behaves differently depending on its current state, the number of states is enormous, and the state-specific code changes frequently.**
- The pattern suggests that you extract all state-specific code into a set of distinct classes. As a result, you can add new states or change existing ones independently of each other, reducing the maintenance cost.
- **Use the pattern when you have a class polluted with massive conditionals that alter how the class behaves according to the current values of the class’s fields.**
- The State pattern lets you extract branches of these conditionals into methods of corresponding state classes. While doing so, you can also clean temporary fields and helper methods involved in state-specific code out of your main class.
- **Use State when you have a lot of duplicate code across similar states and transitions of a condition-based state machine.**
- The State pattern lets you compose hierarchies of state classes and reduce duplication by extracting common code into abstract base classes