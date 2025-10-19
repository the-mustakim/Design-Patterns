package MementoDesignPattern;


import java.util.ArrayDeque;
import java.util.Deque;

// This will hold our memento's or history's
public class Caretaker {

    private final Deque<Editor.Memento> stack = new ArrayDeque<>();

    public void push(Editor.Memento m){stack.push(m);}

    public Editor.Memento pop(){return stack.pop();}
}
