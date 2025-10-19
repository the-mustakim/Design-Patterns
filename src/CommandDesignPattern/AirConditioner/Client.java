package CommandDesignPattern.AirConditioner;

public class Client {

    public static void main(String[] args) {
        //AC object
        AirConditioner airConditioner = new AirConditioner();

        //Remote
        MyRemoteControleInvoker remoteControleInvoker = new MyRemoteControleInvoker();

        //Create the command and press the button
        remoteControleInvoker.setCommand(new TurnACOnCommand(airConditioner));
        remoteControleInvoker.pressButton();

    }
}
