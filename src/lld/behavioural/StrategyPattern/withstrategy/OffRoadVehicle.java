package lld.behavioural.StrategyPattern.withstrategy;

import lld.behavioural.StrategyPattern.withstrategy.strategy.SportDriveStrategy;

public class OffRoadVehicle extends Vehicle {

    public OffRoadVehicle(){
        super(new SportDriveStrategy());
    }

}
