package BridgeDesignPattern;

public abstract class LivingThings {

    protected BreathImplementor breathImplementor;

    public LivingThings(BreathImplementor breathImplementor){
        this.breathImplementor = breathImplementor;
    }

    abstract public void breathProcess();
}
