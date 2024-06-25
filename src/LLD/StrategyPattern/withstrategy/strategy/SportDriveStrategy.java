package LLD.StrategyPattern.withstrategy.strategy;

public class SportDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Sports Drive");
    }
}
