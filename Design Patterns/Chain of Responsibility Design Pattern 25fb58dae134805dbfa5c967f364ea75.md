# Chain of Responsibility Design Pattern

https://www.youtube.com/watch?v=gvIn5QBdGDk

## **I. Introduction to Chain of Responsibility Design Pattern**

The Chain of Responsibility is a behavioral design pattern that allows a request to be passed along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain. This pattern decouples the sender of a request from its receiver, allowing multiple objects to handle the request without the sender knowing which object will ultimately handle it.

**Key Principle:** The sender of the request "does not care which receiver will fulfill my request."

## **II. Core Concepts and Mechanisms**

1. **Sender (Client):** Initiates a request and sends it to the first handler in the chain. The client is unaware of which specific handler will process the request.
2. **Request Object:** The data or operation that needs to be processed.
3. **Handlers/Receivers/Processors:** A series of objects linked together, forming a chain. Each handler has:
    - A method to handle the request (e.g., handleRequest, log).
    - A reference to the **next handler** in the chain.
    - Logic to determine if it can process the request.
    - If it can process, it does so and the request usually stops there.
    - If it cannot process, it passes the request to the next handler in the chain.

The source explains this: When my client gives me a request, it will first go to the first receiver. The first receiver will check if it can fulfill this request. If it cannot, it will pass it to receiver two. Receiver two will check if it can fulfill it. If it cannot, it will forward it, and whichever receiver fulfills it will send the response.

## **III. Real-World Applications (Use Cases)**

The Chain of Responsibility pattern is highly applicable in scenarios where:

- Multiple objects can handle a request.
- The handler is not known in advance.
- The decision of which handler will process a request needs to be dynamic.

The source highlights several common real-time applications:

Design ATM Systems: When you have a question about designing an ATM, understand that it's a Chain of Responsibility design pattern question.
Vending Machines: If you are asked to make any kind of vending machine, you should use this design pattern. This includes handling requests for different items like "Pepsi, Cola, Water Bottle."
Logging Systems: Design loggers... You are indirectly asked to explain the Chain of Responsibility design pattern. This is presented as a crucial application.

## **IV. Detailed Examples**

The briefing doc will now delve into the examples provided in the source to illustrate the pattern's implementation.

### A. ATM Withdrawal Example

- **Client:** The person interacting with the ATM, requesting a withdrawal (e.g., ₹2000).
- **Handlers (Denominations):**
    - ₹2000 Handler
    - ₹500 Handler
    - ₹100 Handler
1. **Process:** Request for ₹2000 goes to the ₹2000 handler.
2. The ₹2000 handler checks if it can fulfill the request. If yes, it dispenses and stops.
3. If not (e.g., insufficient ₹2000 notes), it passes the request to the ₹500 handler.
4. The ₹500 handler checks if it can fulfill the remaining amount. If yes, it dispenses and passes the remainder (if any) to the next handler.
5. This continues until the request is fulfilled or all handlers are exhausted.
6. If no handler can fulfill the request, an "Insufficient Amount" message is returned.

### **B. Logging System Example Explanation**

This example demonstrates how different log levels (INFO, DEBUG, ERROR) can be handled by a chain of log processors.

- **Abstract Handler (LogProcessor):**
    - Defines log levels (e.g., INFO = 1, DEBUG = 2, ERROR = 3).
    - Holds a reference to the nextLogProcessor.
    - Constructor sets the nextLogProcessor.
    - log method: This is the core method. It checks if the current processor can handle the log level. If not, it calls the log method of the nextLogProcessor. If the log level is INFO, only then will I work on it, otherwise, I will tell my parent (the next handler) to print it.
- **Concrete Handlers:**
    - **InfoProcessor:** Handles messages at the INFO level. If the log level matches its own, it processes the message; otherwise, it passes to the nextLogProcessor.
    - **DebugProcessor:** Handles messages at the DEBUG level.
    - **ErrorProcessor:** Handles messages at the ERROR level. The source implicitly states that the ErrorProcessor would likely have no nextLogProcessor (it would be null), signifying the end of the chain for errors.
- **Client (Main Method):**
    - **Chain Creation:** The client constructs the chain explicitly: InfoProcessor -> DebugProcessor -> ErrorProcessor. This first InfoProcessor is InfoProcessor Info. Inside Info, I send the DebugProcessor object, so the next is Debug. Inside Debug, I send the ErrorProcessor object.
    - **Request Initiation:** The client then sends log messages to the first handler in the chain (the InfoProcessor object). infoLogger.log(LogProcessor.ERROR, "Exception Thrown") infoLogger.log(LogProcessor.DEBUG, "Debug message")
- **Process Flow for a LogProcessor.ERROR message:**
    1. infoLogger (an InfoProcessor) receives the ERROR message.
    2. It checks if it can handle ERROR (its level is INFO). It cannot.
    3. It calls its super's log method, which effectively passes the request to the nextLogProcessor (the DebugProcessor).
    4. debugLogger (the DebugProcessor) receives the ERROR message.
    5. It checks if it can handle ERROR (its level is DEBUG). It cannot.
    6. It calls its super's log method, passing the request to its nextLogProcessor (the ErrorProcessor).
    7. errorLogger (the ErrorProcessor) receives the ERROR message.
    8. It checks if it can handle ERROR (its level is ERROR). It can.
    9. It processes the message (e.g., prints "ERROR: Exception Thrown"). The chain ends here.

![image.png](Chain%20of%20Responsibility%20Design%20Pattern/image.png)

![image.png](Chain%20of%20Responsibility%20Design%20Pattern/image%201.png)

## **V. Key Takeaways**

- **Decoupling:** The Chain of Responsibility pattern effectively decouples the sender from the receiver, promoting flexibility.
- **Flexibility:** The chain of handlers can be configured dynamically at runtime, allowing for changes in processing order or the addition/removal of handlers without modifying client code.
- **Single Responsibility Principle (Implied):** Each handler is responsible for a specific type of request or a specific part of a larger request.
- **Control Flow:** The pattern provides a clear mechanism for passing requests along a predefined sequence of objects.
- **Potential for Unhandled Requests:** If no handler in the chain is capable of processing the request, it might remain unhandled, which needs to be considered in the design (e.g., returning an "Insufficient Amount" or a default error in the ATM example).

The source emphasizes the importance of this pattern for interview questions, particularly when designing systems like ATMs, vending machines, or logging systems, as these often involve requests that need to be processed by one of several possible handlers.