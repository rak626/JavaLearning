package LLD.StrategyPattern.withstrategy;

import LLD.StrategyPattern.withstrategy.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {

    public PassengerVehicle(){
        super(new NormalDriveStrategy());
    }
}
