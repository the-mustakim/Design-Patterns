package FlyWeightDesignPattern.GamingScenario;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {

    public static Map<String,Robot> cacheMap = new HashMap<>();

    public static Robot createRobot(String robotType){
        if(cacheMap.containsKey(robotType)){
            return cacheMap.get(robotType);
        }
        if(robotType.equals("HUMANOID")){
            Sprites sprites = new Sprites();
            Robot humanRobot = new HumanRobot(robotType,sprites);
            cacheMap.put(robotType, humanRobot);
            return  humanRobot;
        }
        if(robotType.equals("ROBOTICDOG")){
            Sprites sprites = new Sprites();
            Robot roboticDog = new RoboticDog(robotType,sprites);
            cacheMap.put(robotType, roboticDog);
            return  roboticDog;
        }
        return null;
    }

}
