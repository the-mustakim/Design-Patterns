package FlyWeightDesignPattern.GamingScenario;

public class Client {
    public static void main(String[] args) {
        Robot humanRobot1 = RobotFactory.createRobot("HUMANOID");
        humanRobot1.display(1,2);
        Robot humanRobot2 = RobotFactory.createRobot("HUMANOID");
        humanRobot1.display(10,20);

        Robot dogRobot1 = RobotFactory.createRobot("ROBOTICDOG");
        dogRobot1.display(11,12);
        Robot dogRobot2 = RobotFactory.createRobot("ROBOTICDOG");
        dogRobot2.display(14,15);
    }
}
