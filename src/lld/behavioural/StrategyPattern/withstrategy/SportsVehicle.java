package lld.behavioural.StrategyPattern.withstrategy;

import lld.behavioural.StrategyPattern.withstrategy.strategy.SportDriveStrategy;

public class SportsVehicle extends Vehicle {

    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
