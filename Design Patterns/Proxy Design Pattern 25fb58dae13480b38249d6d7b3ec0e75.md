# Proxy Design Pattern

https://www.youtube.com/watch?v=9MxHKlVc6ZM

## **I. Core Concept of the Proxy Design Pattern**

The Proxy Design Pattern involves introducing a "proxy" object between a client and a "real object" that the client wishes to access. All requests from the client intended for the real object are first routed through this proxy.

- **Definition:** Any point (client) that requests a real object... in between, we introduce a proxy object... so any request going to the real object goes through the proxy.
- **Purpose:** The proxy acts as a substitute or placeholder for another object, controlling access to it. It adds a layer of abstraction and control to the interaction.

## **II. Key Use Cases and Applications**

The Proxy Design Pattern is a widely used and important pattern with several practical applications in day-to-day software development.

1. **Access Control/Restriction:**
- **Description:** The proxy can decide whether a client is allowed to access the real object or perform specific operations on it. It implements centralized validation for access permissions.
    - **Example:** If my client is an admin, then only call create(); otherwise, return access denied. This allows blocking unauthorized access, similar to how college networks block access to certain servers.
    - **Benefit:** Enhances security and ensures that only authorized users or systems can perform certain actions.
1. **Caching:**
- **Description:** The proxy can store frequently accessed data in a cache. If the requested data is already in the cache, the proxy serves it directly without forwarding the request to the real object.
    - **Example:** The proxy will decide if it already has data in the cache or not. If data is in the cache, it will not request the real object; it will reply from here.
    - **Benefit:** Improves performance by reducing the load on the real object and decreasing response times.
1. **Pre-processing and Post-processing:**
    - **Description:** The proxy can execute additional tasks before (pre-processing) or after (post-processing) the actual call to the real object.
    - **Examples of Pre-processing:** Validation, authentication.
    - **Examples of Post-processing: Logging:**  Logging can happen before the event, and logging can happen after the event.
    - **Event Publishing/Notifications:** We have to click on the event (publish event). This is useful for notifying other clients about changes to the object.
    - **Benefit:** Centralizes common operations, such as logging or event handling, preventing code duplication and making the system more maintainable.
2. **Lazy Initialization (Virtual Proxy):**
    - **Description:** The proxy can defer the creation and initialization of a heavy or resource-intensive real object until it is actually needed.
    - **Not explicitly detailed in the source, but implied by the control over object access.**
3. **Monitoring and Marshalling/Unmarshalling:**
    - **Description:** Proxies can be used to monitor requests and responses, or to transform data formats (marshalling/unmarshalling) before sending them to the real object or back to the client.
    - **Example:** Monitoring and marshalling... when this request came, I can add something else... whenever I get an output, it can break it into what the application understands.
    - **Benefit:** Provides insights into system behavior and enables seamless communication between components with different data requirements.

## **III. Implementation Details and Relationships**

The source provides a concrete example of implementing a proxy for an EmployeeTable interface.

- **Interface:** EmployeeTable (with methods like create, delete, get).
- **Concrete Implementation:** EmployeeTableImpl (implements EmployeeTable and contains the actual database operations).
- **Proxy Implementation:** EmployeeTableProxy**Implements the same interface:** This also implements Employee DAO.) This ensures that the proxy can be used interchangeably with the real object.
- **Holds a reference to the real object:** EmployeeTableProxy has the object of the concrete Implementation. This demonstrates the "has-a" relationship (composition).
- **Interception Logic:** Within the proxy's methods (e.g., create, delete, get), it first applies its own logic (e.g., access checks) before conditionally calling the corresponding method on the EmployeeTableImpl object.

## **IV. Significance and Real-World Usage**

The Proxy Design Pattern is crucial for building robust and scalable systems.

- **Ubiquitous in daily use:** This is almost a design pattern that you use in day-to-day life, you must know that you use it daily.
- **Spring Boot Integration:**  Whoever uses Spring Boot knows that whenever we create a bean in Spring Boot, internally it creates a proxy for that bean.) This highlights its internal use in popular frameworks.
- **Chaining Proxies:** Multiple proxies can be chained together, each adding its own layer of functionality or control. A client might interact with Proxy A, which then interacts with Proxy B, which eventually reaches the Real Object. Each proxy in the chain considers the next proxy as its "real object" until the actual real object is reached.

## V. Interview Relevance

The source emphasizes that understanding this pattern is vital for system design interview questions, especially when scenarios involve:

- Centralized access control.
- Caching mechanisms.
- Pre-processing or post-processing operations before/after a core action.

## **VI. Conclusion**

The Proxy Design Pattern is a powerful and versatile structural pattern that provides a substitute or placeholder for another object to control access to it. Its ability to manage access, enhance performance through caching, and centralize pre/post-processing logic makes it an indispensable tool in modern software engineering, used extensively both explicitly and implicitly in various frameworks and applications.