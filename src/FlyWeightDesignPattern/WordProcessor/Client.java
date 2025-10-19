package FlyWeightDesignPattern.WordProcessor;

public class Client {
    public static void main(String[] args) {

        // This is the data we want to write into the word processor

        // Total = 58 characters
        // t= 7 times
        // h = 3 times
        // a = 3 times and so on....

        // Basically, the characters which are repeating might take unnecessary memory we need to optimize it

        // Example: writing the word
        String text = "This is the data we want to write into the word processor";
        int row = 1;

        for (int i = 0; i < text.length(); i++) {
            Charactor ch = CharacterFactory.getCharactor(text.charAt(i));
            // Extrinsic: size=12, row=row, column=i
            ch.display(12, row, i);
        }

        // Reuse: second "l" will NOT create a new object
        System.out.println("Cache size: " + CharacterFactory.cacheMap.size());


    }
}
