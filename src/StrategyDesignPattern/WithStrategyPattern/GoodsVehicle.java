package StrategyDesignPattern.WithStrategyPattern;

import StrategyDesignPattern.WithStrategyPattern.Strategy.DriveStrategy;
import StrategyDesignPattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{

    GoodsVehicle() {
        super( new NormalDriveStrategy());
    }
}
