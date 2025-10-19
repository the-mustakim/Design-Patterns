package CompositeDesignPattern.TeluskoExample;

public class Leaf implements Component{

    private String name;
    private Integer price;

    public Leaf(String name, Integer price){
        this.name = name;
        this.price = price;
    }

    @Override
    public void showPrice() {
        System.out.println("Name:" + name + " Price:" + price);
    }
}
