# Adapter Design Pattern

https://www.youtube.com/watch?v=eR22JuwTa54&t=17s

![image.png](Adapter%20Design%20Pattern/image.png)

![image.png](Adapter%20Design%20Pattern/image%201.png)

![image.png](Adapter%20Design%20Pattern/image%202.png)

![image.png](Adapter%20Design%20Pattern/image%203.png)

![image.png](Adapter%20Design%20Pattern/image%204.png)

## **What is Adapter Design Pattern?**

Two incompatible interfaces or systems can cooperate by using the adapter design pattern, a structural design pattern. Because of incompatible interfaces, it serves as a bridge between two classes that would not otherwise be able to communicate. The adapter approach is very helpful when attempting to incorporate third-party libraries or legacy code into a new system.

## **Real-World Example of Adapter Design Pattern**

Let's understand this concept using a simple example:

*Suppose you have two buddies, one of them speaks French exclusively and the other English exclusively. The language barrier prevents them from communicating the way you want them to.*

- You act as an adapter, translating messages between them. Your role allows the English speaker to convey messages to you, and you convert those messages into French for the other person.
- In this way, despite the language difference, your adaptation enables smooth communication between your friends.
- This role you play is similar to the Adapter design pattern, bridging the gap between incompatible interfaces.

## **When to use the Adapter Design Pattern?**

Use the adapter design pattern when:

- We need to connect systems or components that weren’t built to work together. The adapter allows these incompatible interfaces to communicate, making integration smoother.
- Many times, we have existing code or libraries that we want to use, but they don’t match our current system. The adapter helps us incorporate this old code without having to rewrite it.
- As projects grow, new components are frequently added. An adapter allows you to integrate these new pieces without affecting the existing code, keeping the system flexible and adaptable.
- By isolating the changes needed for compatibility in one place, the adapter makes it easier to maintain the code. This reduces the risk of bugs that might arise from changing multiple parts of the system.