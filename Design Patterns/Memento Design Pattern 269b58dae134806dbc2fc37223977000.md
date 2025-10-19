# Memento Design Pattern

https://www.youtube.com/watch?v=nTo7e2lpGZ4

## Problem (Jisme hum phas jaate hain)

Socho tum ek **Text Editor** bana rahe ho (MS Word jaisa).

- User text likh sakta hai, format kar sakta hai, images dal sakta hai.
- Ab user ko **Undo** ka option chahiye (jo sab expect karte hain).

### Humari soch (direct approach):

- Har operation se pehle **Editor ka pura state copy** karke kahin save kar lo.
- Baad mein Undo karna ho to woh saved state se restore kar do.

### Issue #1: Private fields

- Editor ke andar bahut saare **private variables** hain (text, cursor, scroll, formatting).
- Bahar se state copy karna matlab unhe **public karna**.
- Agar public kar doge to **encapsulation break** ho jaayegi (private ka fayda khatam).

### Issue #2: Fragile design

- Agar future mein Editor class change ki (new fields add/old remove) →
    
    Toh saare snapshot handling classes ko bhi modify karna padega.
    
- Yeh design **bahut tight coupled** ho jaata hai → fragile system.

### Issue #3: Security

- Snapshot agar dusri classes ke paas hoga, toh woh Editor ke andar ke private states dekh bhi paayengi aur chhed bhi paayengi.

👉 Matlab: Either tum sab kuch public karke Undo banao (encapsulation khatam) ya Undo ban hi nahi paayega. **Yehi real problem hai.**

## Solution (Memento Pattern)

Memento pattern bolta hai:

**“State ko save karne ka kaam usi object ko karne do jiske paas wo state hai.”**

### Kaise solve karta hai?

1. **Originator (Editor)**
    - Apna ek special object banata hai → `Memento`.
    - `Memento` ke andar Editor ka pura private state save ho jaata hai.
    - Sirf Editor hi is state ko likh/seekh sakta hai. Koi aur nahi.
2. **Memento**
    - Yeh ek **snapshot container** hai.
    - Yeh Editor ke state ko hold karta hai, par dusre objects usko directly read/write nahi kar sakte.
    - Dusre log sirf basic info dekh sakte hain jaise “kis time pe save hua”.
3. **Caretaker (History)**
    - Iske paas ek **stack/list** hoti hai Mementos ki.
    - Jab bhi koi operation hota hai → Editor ek snapshot deta hai aur Caretaker usse store kar leta hai.
    - Jab user **Undo** maangta hai → Caretaker apna last Memento nikal ke Editor ko wapas de deta hai.
    - Editor usse apna pura state restore kar leta hai.

---

## ⚖️ Example — Text Editor

- **Before typing “World”** → Editor apna snapshot (`Hello`) create karta hai.
- History (Caretaker) me save ho jaata hai.
- Editor ne `Hello World` likh diya.

Undo:

- Caretaker se last snapshot nikalo (`Hello`).
- Editor apna state wapas us snapshot se set karega.
- Text fir se `Hello` ban jaata hai.

![image.png](Memento%20Design%20Pattern/image.png)

![image.png](Memento%20Design%20Pattern/image%201.png)

## I. Core Purpose and Definition

The Memento design pattern is a **behavioral pattern** primarily used for **storing the history of an object**. Its most common application is to implement **undo functionality**. The pattern allows for taking a "snapshot" of an object's state at a particular time, which can then be used to revert the object back to that previous state. It is also known as the **"snapshot design pattern."**

**Key characteristics:**

- **Undo functionality:** "Whenever you want to build the undo functionality then always think about this pattern."
- **Snapshot capability:** "whenever you want you can take a snapshot and keep it... whenever you required you can revert back or go back or undo to that particular snapshot."
- **Encapsulation of internal implementation:** A crucial benefit is that "it do not expose the object internal implementation." This means the object's internal workings for saving and restoring its state are hidden from external callers.

### II. Major Components

The Memento pattern comprises three main components:

1. **Originator:**
    - **Role:** This is the actual object for which we want to maintain a history. "Originator is the object actually for which we want to maintain a history."
    - **Responsibility:** It "represent the object for which state need to be saved and restored."
    - **Methods:** It exposes two primary methods:
    - createMemento(): This method captures the originator's current state and encapsulates it within a Memento object. The originator "has the logic what to save in the momento."
    - restoreMemento(Memento memento): This method allows the originator to revert its state based on the provided Memento object. It "knows that okay from this momento object what all things I need to read so that I can go back to the previous state."
2. **Memento:**
    - **Role:** An object that "actually holds the state of what of originator."
    - **Responsibility:** It stores a particular snapshot or state of the originator. "Whenever we take a particular snapshot or a particular State save a particular state of the originator... it holds it holds the state of the originator momento."
    - **Content:** It contains "all the variables which are required to save a state of a originator." The structure of the Memento can directly mirror the originator's relevant member variables, or it can be a more specific set of fields.
3. **Caretaker:**
    - **Role:** Manages the list of Memento objects, essentially maintaining the history. "Caretaker is nothing but you can say that list of momento."
    - **Responsibility:** "Caretaker manage those list of MOS."
    - **Methods:** It typically exposes methods like:
        - addMemento(Memento memento): Adds a new Memento object to its history list. "If you want to add more it expose method give me the momento I will add it into this list."
        - undo(): Retrieves the last Memento from its history (and often removes it), allowing the client to restore the originator to a previous state. "Take out the last Memento from this list and return it and remove that Memento from this list."

### III. Interaction and Flow (UML Diagram Concept)

1. The Originator object changes its internal state.
2. When a snapshot is required, the client (or an external entity) asks the Originator to createMemento().
3. The Originator creates a Memento object, populating it with the necessary internal state data, and returns it. Critically, the Originator controls what state is saved, thus preventing external exposure of its internal structure. "Originator do not expose the implementation how to save this state it knows that what is required for me what all what else what all things I need to save my state."
4. The client then passes this Memento object to the Caretaker to addMemento(), storing it in a history list.
5. When an undo operation is needed, the client requests an undo() from the Caretaker.
6. The Caretaker retrieves the appropriate Memento (typically the last one added) from its list and returns it to the client.
7. The client then passes this retrieved Memento object to the Originator via the restoreMemento() method.
8. The Originator uses the data within the Memento to revert its own internal state to what it was when that Memento was created.

### VI. Conclusion

The Memento design pattern offers a robust and encapsulated way to implement undo/redo functionality and manage object history. Its ability to capture and restore an object's state without exposing its internal structure makes it a powerful tool in object-oriented design, particularly when dealing with complex objects whose states need to be saved and restored. As stated, it is "very simple... but very, very effective when an interview is asking you to maintain a history of a particular object so that you can develop the undo functionality."