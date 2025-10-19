package DecoratorDesignPattern;

public class MushroomTopping extends ToppingDecrator{

    private BasePizza basePizza;

    public MushroomTopping(BasePizza pizza){
        this.basePizza = pizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 10;
    }
}
