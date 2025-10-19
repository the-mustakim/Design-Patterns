# Template Method Design Pattern

https://www.youtube.com/watch?v=kwy-G1DEm0M

The Template Method design pattern is a behavioral pattern frequently used in software development, often without developers explicitly recognizing it. Its core purpose is to define the skeleton of an algorithm in a base class, allowing subclasses to override specific steps of the algorithm without changing its overall structure. This pattern ensures that all classes follow a specific sequence of operations while providing the flexibility for each class to implement those individual operations with its own unique logic.

## I. Problem

Imagine that you’re creating a data mining application that analyzes corporate documents. Users feed the app documents in various formats (PDF, DOC, CSV), and it tries to extract meaningful data from these documents in a uniform format.

The first version of the app could work only with DOC files. In the following version, it was able to support CSV files. A month later, you “taught” it to extract data from PDF files.

![image.png](Template%20Method%20Design%20Pattern/image.png)

At some point, you noticed that all three classes have a lot of similar code. While the code for dealing with various data formats was entirely different in all classes, the code for data processing and analysis is almost identical. Wouldn’t it be great to get rid of the code duplication, leaving the algorithm structure intact?

There was another problem related to client code that used these classes. It had lots of conditionals that picked a proper course of action depending on the class of the processing object. If all three processing classes had a common interface or a base class, you’d be able to eliminate the conditionals in client code and use polymorphism when calling methods on a processing object.

## II. Main Themes and Core Concepts

**A. Behavioral Design Pattern:** The Template Method is categorized as a behavioral design pattern. This means it focuses on algorithms and the assignment of responsibilities between objects.

**B. Core Problem Solved:** The pattern addresses two primary requirements:

1. **Ensuring Specific Steps are Followed:** "When you want all classes to follow the specific steps to process the task..."
2. **Providing Flexibility for Individual Step Logic:** "...but also you need to provide the flexibility that each class can have its own logic in those specific steps."

**C. The "Template Method" Itself:** The "template method" is a concrete method (often declared final) in an abstract base class. This method defines the invariant parts of an algorithm and the sequence of its steps. It calls abstract (or hook) methods that are to be implemented by subclasses. Making the template method final prevents subclasses from altering the algorithm's structure.

**D. Abstract Base Class and Subclasses:**

- An **abstract base class** (e.g., PaymentFlow) contains the template method and declares abstract methods for the steps that vary.
- **Subclasses** (e.g., PayToFriendFlow, PayToMerchantFlow) extend the abstract base class and provide concrete implementations for the abstract methods, customizing the varying steps of the algorithm.

## III. Key Ideas and Facts

**A. Why it's Required and When to Use:** The Template Method pattern is essential when:

- You have a common algorithm or process that needs to be executed across multiple related classes.
- The overall sequence of steps in that algorithm must remain consistent.
- However, the specific implementation details of *some* of those steps vary depending on the particular class.

**B. Example Scenario:** 

**Payment Flow:** The source uses a payment example to illustrate the pattern:

- **Task:** sendMoney
    
    **Common Steps (fixed order as per the template):**
    
    1. validateRequest
    2. debitAmount
    3. calculateFees
    4. creditAmount

**Varying Implementations:** 

- **Pay to Friend Flow:** Validation might be simple; 0% fees; credit the full amount.
- **Pay to Merchant Flow:** Validation might be more complex; 2% fees; credit amount minus fees.

![image.png](Template%20Method%20Design%20Pattern/image%201.png)

**C. Implementation Details:**

1. **Abstract Class:** An abstract class (PaymentFlow) is created to define the common structure.
2. **Abstract Methods:** Abstract methods (e.g., validateRequest(), debitAmount(), calculateFees(), creditAmount()) are declared in the abstract class. These are the "hooks" that subclasses will implement.
3. **Template Method (final concrete method):** A concrete, final method (e.g., sendMoney()) is defined in the abstract class. This method calls the abstract methods in a predefined order. "This template method here if you see that it is providing a shity that this send money task like and I have created Final that no child class can override it so they have to follow this order." (Source)
4. **Subclass Customization:** Subclasses (e.g., PayToFriendFlow, PayToMerchantFlow) override the abstract methods to provide their specific logic for each step. "Now all child classes like pay to friend flow pay to Merchant flow right all the child classes can overwrite this one because they are child of this right they have to provide the implementation of this now they can provide their own implementation..." (Source)
5. **Guaranteed Order:** Because the template method is final, the order of operations for any sendMoney call is guaranteed, regardless of which subclass object is used. "This is the only method which would be available in the parent right no child class can override it they can just use this as it is." (Source)

**D. Real-World Application:** The source emphasizes that this pattern is "very frequently used pattern in the industry" and provides a "real world example" with the payment flow.

## IV. Conclusion

The Template Method design pattern provides a robust and elegant solution for implementing algorithms where the overall structure is constant, but specific steps can be customized by different implementations. By leveraging abstract classes, abstract methods, and a final template method, it enforces a consistent workflow while maintaining high flexibility and extensibility. Developers often use this pattern intuitively, making it a fundamental concept in object-oriented design.