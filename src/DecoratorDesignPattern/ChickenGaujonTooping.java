package DecoratorDesignPattern;

public class ChickenGaujonTooping extends ToppingDecrator{

    BasePizza basePizza;

    public ChickenGaujonTooping(BasePizza pizza){
        basePizza=pizza;
    }

    public int getCost(){
        return basePizza.getCost() + 30;
    }
}
