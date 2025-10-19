package CompositeDesignPattern.TeluskoExample;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

    private List<Component> components = new ArrayList<>();

    private String name;

    public Composite(String name){
        this.name = name;
    }

    public void addComponent(Component composite){
        components.add(composite);
    }

    @Override
    public void showPrice() {
        System.out.println("Name of the component: " + name);
        for(Component composite: components){
            composite.showPrice();
        }
    }
}
