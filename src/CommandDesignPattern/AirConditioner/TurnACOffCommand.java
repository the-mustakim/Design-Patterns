package CommandDesignPattern.AirConditioner;

public class TurnACOffCommand implements ICommand{
    AirConditioner ac;

    TurnACOffCommand(AirConditioner ac){
        this.ac = ac;
    }

    public void execute(){
        ac.turnOfAC();
    }
}
