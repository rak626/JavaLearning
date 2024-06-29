package lld.behavioural.StrategyPattern.withstrategy;

import lld.behavioural.StrategyPattern.withstrategy.strategy.HeavyDriveStrategy;

public class GoodsVehicle extends Vehicle {

    public GoodsVehicle(){
        super(new HeavyDriveStrategy());
    }
}
