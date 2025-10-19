package MementoDesignPattern;


// Originator
public class Editor {
    private String text = "";
    private int cursor;
    private int scroll;

    public void type(String s){
        text += s;
    }

    public void moverCursor(int c){
        cursor= c;
    }

    public void scrollTo(int s){
        scroll = s;
    }

    // Create snapshot
    public Memento save(){
        return new Memento(text,cursor,scroll);
    }

    // Restore snapshot
    public void restore(Memento m){
        this.text = m.text;
        this.cursor = m.cursor;
        this.scroll = m.scroll;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "text='" + text + '\'' +
                ", cursor=" + cursor +
                ", scroll=" + scroll +
                '}';
    }

    // Memento (inner keeps fields hidden from others)
    public static class Memento {
        private final String text;
        private final int cursor, scroll;

        Memento(String t, int c, int s){
            this.text =t;
            this.cursor = c;
            this.scroll=s;
        }
    }



}
