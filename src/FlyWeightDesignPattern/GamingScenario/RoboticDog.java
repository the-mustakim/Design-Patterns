package FlyWeightDesignPattern.GamingScenario;

public class RoboticDog implements Robot{

    String type;
    Sprites body;

    public RoboticDog(String type, Sprites body){
        this.type = type;
        this.body = body;
    }


    @Override
    public void display(int x, int y) {
        System.out.println("Dog Robot: " +"X-Axis:"+ x + " Y-Axis:"+ y);
    }
}
