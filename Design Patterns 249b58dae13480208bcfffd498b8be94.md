# Design Patterns

Design Patterns are the solutions for commonly occurring problems in software development; they are like pre-made blueprints that you can customize to solve recurring design problems in your code. 

We can’t just find a pattern and copy it into a program, the way we import or reuse libraries in our code. The pattern is not a specific piece of code, but a general concept.

It can be followed to implement a solution according to the need.

## What does the pattern consist of?

Most patterns are described very formally so people can produce them in many contexts.

Sections Below:

1. Intent: Briefly describe both the problem and the solution.
2. Motivation: It explains the problem, and the solution pattern makes it possible.
3. Structure: Structure shows each part of the pattern and how they are related.
4. Code Example: It will help to grasp the idea behind the pattern.

## **History of patterns**

Who invented patterns?

That’s a good, but not a very accurate, question. Design patterns aren’t obscure, sophisticated concepts—quite the opposite. Patterns are typical solutions to common problems in object-oriented design. 

When a solution gets repeated over and over in various projects, someone eventually puts a name to it and describes the solution in detail. That’s basically how a pattern gets discovered.

Christopher Alexander described the idea of patterns in his book “*A Pattern Language: Towns, Buildings, Construction.”* 

The idea was picked up by four authors: Erich Gamma, John Vlissides, Ralph Johnson, and Richard Helm. In 1994, they published [**Design Patterns: Elements of Reusable Object-Oriented Software**](https://refactoring.guru/gof-book), 

Due to its lengthy name, people started to call it “the book by the gang of four” which was soon shortened to simply “the GoF book”.

## **Why should I learn patterns?**

The truth is that you can spend your life as a programmer without learning patterns. Even in that case, though, you might be implementing them without knowing them in your job or projects. So what’s the point of learning them? Seems a waste of time, right?

Here why:

1. Design patterns are a set of tried and tested solutions that occur in software development. Even if you never encounter such problems, knowing patterns would still be useful because it teaches you how to solve all sorts of problems using principles of object-oriented design.
2. Design patterns define a common language between you and fellow dev’s. You can simply say “Oh…use a Singleton Design Pattern” without explaining what the Singleton design pattern means.

## **Classification of patterns**

Design patterns can be different in how complex they are, how detailed they get, and how much of the whole system they affect. Think of it like building roads: to make an intersection safer, you could just put up some traffic lights, or you could build a big multi-level interchange with tunnels for people to walk underground.

The simplest patterns are called **idioms**. These usually work only in one specific programming language.

The biggest and most general patterns are called **architectural patterns**. These can be used with almost any programming language. Unlike other patterns, they help design the structure of a whole application.

In addition, all patterns can be categorized by their intent, or purpose. We will cover three main groups of patterns:

**Creational Patterns**: This pattern provides an object creation mechanism that increases flexibility and reusability of the existing code.

**Structural Patterns:** This pattern explains how to assemble objects and classes into a larger structure by keeping the structure flexible and efficient.

**Behavioral Patterns:** This pattern takes care of effective communication and the assignment of responsibilities between objects.

![The Catalog of Design Patterns - visual selection.png](Design%20Patterns/The_Catalog_of_Design_Patterns_-_visual_selection.png)

## **The Catalog of Design Patterns**

Creational Patterns:

1. Factory Method
2. Abstract Factory
3. Builder
4. Prototype
5. Singleton

Structural Patterns:

1. Adapter
2. Bridge
3. Composite
4. Decorator
5. Facade
6. Flyweight
7. Proxy

Behavioral Patterns:

1. Chain of Responsibility
2. Command
3. Iterator
4. Mediator
5. Memento
6. Observer
7. State
8. Strategy
9. Template Method
10. Visitor

Let’s learn each one by one:

### Creational Patterns:

[**Factory Method**](Design%20Patterns/Factory%20Method%2024cb58dae134809c9e2ff56c56a7cbcf.md)

[Abstract Factory](Design%20Patterns/Abstract%20Factory%2024cb58dae1348057ba07f794f0fac77a.md)

[**Builder Design Pattern - for Complex Object**](Design%20Patterns/Builder%20Design%20Pattern%20-%20for%20Complex%20Object%2024fb58dae134801989b8e80b870c379a.md)

[**Prototype Design Pattern**](Design%20Patterns/Prototype%20Design%20Pattern%20251b58dae1348083951ac396c4073e83.md)

[**Singleton Design Pattern**](Design%20Patterns/Singleton%20Design%20Pattern%20254b58dae13480938a8cee1ca402e10c.md)

### Structural Patterns:

[**Adapter Design Pattern**](Design%20Patterns/Adapter%20Design%20Pattern%20254b58dae13480e39e2dcb60e83fa4a0.md)

[Bridge Design Pattern](Design%20Patterns/Bridge%20Design%20Pattern%20255b58dae13480a5b1e3c72bb9e339cf.md)

[Composite Design Pattern](Design%20Patterns/Composite%20Design%20Pattern%20256b58dae1348047a8bad74b8c9c76b6.md)

[**Decorator Design Pattern**](Design%20Patterns/Decorator%20Design%20Pattern%20256b58dae1348089b7a5c80497042d25.md)

[Facade Design Pattern](Design%20Patterns/Facade%20Design%20Pattern%20256b58dae13480d2aa18ee155f7b2737.md)

[**Flyweight Design Pattern - Memory Optimization**](Design%20Patterns/Flyweight%20Design%20Pattern%20-%20Memory%20Optimization%2025db58dae1348070a1b4faab615dd3da.md)

[Proxy Design Pattern](Design%20Patterns/Proxy%20Design%20Pattern%2025fb58dae13480b38249d6d7b3ec0e75.md)

### Behavioral Patterns:

[Chain of Responsibility Design Pattern](Design%20Patterns/Chain%20of%20Responsibility%20Design%20Pattern%2025fb58dae134805dbfa5c967f364ea75.md)

[Command Design Pattern](Design%20Patterns/Command%20Design%20Pattern%20262b58dae1348052a91cd4fc5a3eeb74.md)

[**Iterator Design Pattern**](Design%20Patterns/Iterator%20Design%20Pattern%20265b58dae134806e8510d76003abab9e.md)

[**Mediator Design Pattern**](Design%20Patterns/Mediator%20Design%20Pattern%20265b58dae134808987e0efcffbd91a26.md)

[**Memento Design Pattern**](Design%20Patterns/Memento%20Design%20Pattern%20269b58dae134806dbc2fc37223977000.md)

[**Observer Design Pattern**](Design%20Patterns/Observer%20Design%20Pattern%20269b58dae134800ba851f42ba9560602.md)

[**State Design Pattern**](Design%20Patterns/State%20Design%20Pattern%2026ab58dae13480a683abf3fe4acd71fd.md)

[**Strategy Design Pattern**](Design%20Patterns/Strategy%20Design%20Pattern%2026cb58dae1348042a61cf2e2ef30fed3.md)

[Template Method Design Pattern](Design%20Patterns/Template%20Method%20Design%20Pattern%20271b58dae13480e9ae55cd0826a0f417.md)

[**Visitor Design Pattern**](Design%20Patterns/Visitor%20Design%20Pattern%20272b58dae1348052bcccfcd89668a107.md)