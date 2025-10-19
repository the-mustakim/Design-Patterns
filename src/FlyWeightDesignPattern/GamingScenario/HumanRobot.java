package FlyWeightDesignPattern.GamingScenario;

public class HumanRobot implements Robot{

    //Intrinsic Fields
    String type;
    Sprites body; //Small 2d Map

    public HumanRobot(String type, Sprites body){
        this.type = type;
        this.body = body;
    }

    @Override
    public void display(int x, int y) {
        // Use the object to render at x, y axis
        System.out.println( "Human Robot: "+" X-Axis:"+ x + " Y-Axis:"+ y);
    }
}
