package LLD.behavioural.StrategyPattern.withstrategy;

import LLD.behavioural.StrategyPattern.withstrategy.strategy.SportDriveStrategy;

public class OffRoadVehicle extends Vehicle {

    public OffRoadVehicle(){
        super(new SportDriveStrategy());
    }

}
