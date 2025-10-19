package BridgeDesignPattern;

public class Tree extends LivingThings{

    public Tree(BreathImplementor breathImplementor){
        super(breathImplementor);
    }

    @Override
    public void breathProcess() {
        breathImplementor.breath();
    }
}
