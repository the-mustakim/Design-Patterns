package DecoratorDesignPattern;

public class Test {
    public static void main(String[] args) {
        BasePizza pizza = new VegPizza();

        System.out.println("Cost of the pizza with not toppings is: " + pizza.getCost());

        BasePizza baseWithMushroom = new MushroomTopping(pizza);

        System.out.println("Cost of the pizza with 1 topping: mushroom is: " + baseWithMushroom.getCost());

        BasePizza baseWithMushroomWithChicken = new ChickenGaujonTooping(baseWithMushroom);
        System.out.println("Cost of the pizza with 2 toppings: mushroom and chicken is: " + baseWithMushroomWithChicken.getCost());
    }
}
