package MementoDesignPattern;

public class Client {
    public static void main(String[] args) {

        Editor editor = new Editor();
        Caretaker caretaker = new Caretaker();

        editor.type("Hello");
        Editor.Memento memento = editor.save();
        caretaker.push(memento); // Snapshot

        editor.type("World!");
        System.out.println("The current state of the Editor is: " + editor.toString());

        System.out.println("Undo now - operation-----------------------------------");

        memento = caretaker.pop();
        editor.restore(memento); // undo " World!", Restore the state.

        System.out.println("The current state of the Editor is: " + editor.toString());


    }
}
