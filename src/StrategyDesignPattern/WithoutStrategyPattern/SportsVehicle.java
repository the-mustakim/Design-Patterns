package StrategyDesignPattern.WithoutStrategyPattern;

public class SportsVehicle extends Vehicle{

    @Override
    public void drive() {

        // But the problem is this class does not want to use the parent class drive so it gives it own implementation to it
        System.out.println("sports drive capability");

    }
}
