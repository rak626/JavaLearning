package LLD.StrategyPattern.withstrategy;

import LLD.StrategyPattern.withstrategy.strategy.SportDriveStrategy;

public class SportsVehicle extends Vehicle {

    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
