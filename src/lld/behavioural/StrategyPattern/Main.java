package lld.behavioural.StrategyPattern;

import lld.behavioural.StrategyPattern.withstrategy.PassengerVehicle;
import lld.behavioural.StrategyPattern.withstrategy.Vehicle;

public class Main {

    public static void main(String[] args) {
//        Vehicle vehicle = new SportsVehicle();
//        Vehicle vehicle = new OffRoadVehicle();
//        Vehicle vehicle = new GoodsVehicle();
        Vehicle vehicle = new PassengerVehicle();
        vehicle.drive();
    }
}
