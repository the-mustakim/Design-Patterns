package CommandDesignPattern.AirConditioner;

public class MyRemoteControleInvoker {
    ICommand command;

    MyRemoteControleInvoker(){
    }

    public void setCommand(ICommand command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}
