package BridgeDesignPattern;

public class Demo {
    public static void main(String[] args) {
        BreathImplementor wateBreath = new LandBreath();
        LivingThings dog = new Dog(wateBreath);
        dog.breathProcess();
    }
}
