package LLD.behavioural.StrategyPattern.withstrategy;

import LLD.behavioural.StrategyPattern.withstrategy.strategy.HeavyDriveStrategy;

public class GoodsVehicle extends Vehicle {

    public GoodsVehicle(){
        super(new HeavyDriveStrategy());
    }
}
