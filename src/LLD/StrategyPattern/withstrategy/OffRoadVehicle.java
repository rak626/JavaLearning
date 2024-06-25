package LLD.StrategyPattern.withstrategy;

import LLD.StrategyPattern.withstrategy.strategy.SportDriveStrategy;

public class OffRoadVehicle extends Vehicle {

    public OffRoadVehicle(){
        super(new SportDriveStrategy());
    }

}
