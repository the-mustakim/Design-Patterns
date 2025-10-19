# Mediator Design Pattern

https://www.youtube.com/watch?v=bKM2lFPPmmY&t=393s

**Mediator** is a behavioral design pattern that lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.

## **Problem**

Several airplanes in an airport must coordinate their movements and communicate with one another in order to prevent collisions and guarantee safe takeoffs and landings. Direct communication between airplanes might result in complex and error-prone coordination, especially when dealing with multiple aircraft in the same airspace.

## Solution

The mediator pattern suggests that you should cease all direct communication between the components that you want to make independent of each other. Instead, these components must collaborate indirectly, by calling a special mediator object that redirects the calls to appropriate components.

## Online Auction Design System

![image.png](Mediator%20Design%20Pattern/image.png)

![image.png](Mediator%20Design%20Pattern/image%201.png)

## **1. Introduction to Mediator Design Pattern**

The Mediator Design Pattern is a behavioral design pattern that promotes loose coupling between objects. Its core principle is to prevent objects from directly referring to each other, instead enabling them to communicate through a central "mediator" object.

Key Concepts:

**Loose Coupling**: The pattern aims to reduce the dependencies between objects. Instead of object A directly interacting with object B, they both interact with a mediator. This means changes in object A's interface or logic do not necessarily impact object B, as long as the mediator's interaction with them remains consistent.
**Centralized Communication:** All communication between objects (referred to as "colleagues" in the pattern) is channeled through a single mediator. The mediator receives messages from one colleague and passes them on to relevant others.
**Reduced Complexity:** By centralizing communication logic, the pattern helps manage complex interactions among many objects, preventing a "spaghetti code" scenario where every object knows about and directly interacts with many others.
**Examples of Application:** 

Airline Management System: Multiple flights interact with an Airline Management System (the mediator) to coordinate landings, take-offs, and flight paths. Individual planes do not communicate directly with each other.
**Chat Application:** In a low-level design of a chat application, two persons (objects) communicate not directly, but through a central chat mediator.

**How it Works (UML Overview):**

1. **Colleague Interface:** Defines methods that concrete colleague objects must implement (e.g., placeBid, receiveNotification).
2. **Concrete Colleagues:** Implement the Colleague interface. They have a reference to the mediator and use it to communicate.
3. **Mediator Interface:** Defines methods for interaction with colleagues (e.g., addBidder, placeBid).
4. **Concrete Mediator:** Implements the Mediator interface. It maintains a list of colleagues and orchestrates their interactions. It receives messages from one colleague and decides which other colleagues should receive notifications or actions.

## 2. Online Auction System as an Example of Mediator Pattern

The online auction system provides an excellent practical illustration of the Mediator Design Pattern.

Main Themes and Facts:

- Bidders as Colleagues: In an online auction, there are multiple bidders, each acting as a "colleague" object.
- Auction Mediator: A central "auction mediator" object facilitates all interactions between bidders.
- No Direct Bidder-to-Bidder Communication: "These persons... they don't have to directly communicate with each other... they are talking through a mediator." A bidder places a bid, but doesn't directly tell other bidders.
    1. **Bid Placement Process:** A bidder decides to "place a bid" with a certain amount.
    2. Instead of notifying other bidders directly, the bidder tells the **auction mediator**: "hey place a bid of let's say 1,000 rupees."
    3. The auction mediator receives the bid, identifies the bidder, and the bid amount.
    4. The mediator then iterates through its list of all participating bidders (colleagues).
    5. For all bidders *except* the one who placed the current bid, the mediator calls their receiveBidNotification method. This ensures that "other person knows that okay there is a bid which has been placed for 1,000 rupees."
    6. This allows other bidders to "increase it or whether to place a bid with a higher amount or not."
- **Implementation Details:** A Colleague interface is defined, with methods like placeBid and receiveNotification.
- A BidderImpl class implements the Colleague interface, holding a name and a reference to the Mediator.
- A Mediator interface is defined, with methods like addBidder and placeBid.
- An AuctionImpl class implements the Mediator interface. It maintains a list of colleagues (bidders).
- When a bidder is created, it is associated with a specific AuctionMediator and added to its list of participants using auctionMediator.addBidder().
- When bidder.placeBid() is called, it internally calls auctionMediator.placeBid(this, bidAmount).
- The auctionMediator.placeBid() method then iterates through its list of colleagues and sends receiveBidNotification to all bidders except the one who initiated the bid.