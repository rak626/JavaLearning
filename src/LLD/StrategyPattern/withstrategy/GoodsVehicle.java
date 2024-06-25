package LLD.StrategyPattern.withstrategy;

import LLD.StrategyPattern.withstrategy.strategy.HeavyDriveStrategy;

public class GoodsVehicle extends Vehicle {

    public GoodsVehicle(){
        super(new HeavyDriveStrategy());
    }
}
