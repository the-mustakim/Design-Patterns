package BridgeDesignPattern;

public class Fish extends LivingThings{

    public Fish(BreathImplementor breathImplementor){
        super(breathImplementor);
    }

    @Override
    public void breathProcess() {
        breathImplementor.breath();
    }
}
