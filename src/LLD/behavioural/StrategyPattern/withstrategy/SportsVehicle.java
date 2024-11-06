package LLD.behavioural.StrategyPattern.withstrategy;

import LLD.behavioural.StrategyPattern.withstrategy.strategy.SportDriveStrategy;

public class SportsVehicle extends Vehicle {

    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
