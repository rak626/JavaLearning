package lld.behavioural.StrategyPattern.withstrategy;

import lld.behavioural.StrategyPattern.withstrategy.strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        driveStrategy.drive();
    }
}
