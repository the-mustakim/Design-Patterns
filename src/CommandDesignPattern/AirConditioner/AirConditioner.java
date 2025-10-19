package CommandDesignPattern.AirConditioner;

public class AirConditioner {
    boolean isOn;
    int temperature;

    public void turnOnAc(){
        isOn = true;
        System.out.println("AC is ON");
    }

    public void turnOfAC(){
        isOn = false;
        System.out.println("AC is OFF");
    }

    public void setTemplate(int temp){
        this.temperature = temp;
        System.out.println("Temperature changed to: " + temperature);
    }
}
