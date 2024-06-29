package lld.behavioural.StrategyPattern.withstrategy;

import lld.behavioural.StrategyPattern.withstrategy.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {

    public PassengerVehicle(){
        super(new NormalDriveStrategy());
    }
}
