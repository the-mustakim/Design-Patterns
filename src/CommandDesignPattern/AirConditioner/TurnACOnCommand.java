package CommandDesignPattern.AirConditioner;

public class TurnACOnCommand implements ICommand{
    AirConditioner ac;

    TurnACOnCommand(AirConditioner ac){
        this.ac=ac;
    }

    public void execute(){
        ac.turnOnAc();
    }
}
