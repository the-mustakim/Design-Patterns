package FlyWeightDesignPattern.WordProcessor;

public class Charactor {
    char character;
    String fontType;

    public Charactor(char character, String fontType) {
        this.character = character;
        this.fontType = fontType;
    }

    public void display(int size, int row, int column){
        System.out.println("Letter: " + character +
                " Font: " + fontType +
                " Size: " + size +
                " Row: " + row +
                " Column: " + column);
    }
}
