package CompositeDesignPattern.TeluskoExample;

public class CompositeTest {
    public static void main(String[] args) {
        Component mouse = new Leaf("Mouse", 4000);
        Component keyboard = new Leaf("keyboard", 800);
        Component ram = new Leaf("ram", 1200);
        Component cpu = new Leaf("cpu", 399);

        Composite cabinate = new Composite("Cabinet");
        Composite periPherals = new Composite("PeriPherals");

        cabinate.addComponent(ram);
        cabinate.addComponent(cpu);

        periPherals.addComponent(mouse);
        periPherals.addComponent(keyboard);

        Composite computer = new Composite("Computer");
        computer.addComponent(periPherals);
        computer.addComponent(cabinate);

        computer.showPrice();

    }
}
