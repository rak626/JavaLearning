package LLD.behavioural.StrategyPattern.withstrategy.strategy;

public class HeavyDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Heavy Drive");
    }
}
