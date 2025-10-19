package StrategyDesignPattern.WithoutStrategyPattern;

public class OffRoadVehicle extends Vehicle{

    @Override
    public void drive() {

        // But the problem is this class does not want to use the parent class drive so it gives it own implementation to it
        // But this implementaion or the feature is similar to the SportsVehicle drive class
        // So, this is the code duplication in the system
        // If there are so many class which are having similar kind of functionality
        // Then, it's a problem and we should use Strategy Design Pattern
        // How we should do that? Refer the WithStrategyPattern Package
        System.out.println("sports drive capability");

    }
}
