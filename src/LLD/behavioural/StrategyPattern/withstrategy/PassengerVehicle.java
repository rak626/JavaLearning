package LLD.behavioural.StrategyPattern.withstrategy;

import LLD.behavioural.StrategyPattern.withstrategy.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {

    public PassengerVehicle(){
        super(new NormalDriveStrategy());
    }
}
