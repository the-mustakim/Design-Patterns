package FlyWeightDesignPattern.WordProcessor;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    public static Map<Character,Charactor> cacheMap = new HashMap<>();

    public static Charactor getCharactor(Character letter){
     return cacheMap.computeIfAbsent(letter, l -> new Charactor(l,"ARIAL"));
    }
}
