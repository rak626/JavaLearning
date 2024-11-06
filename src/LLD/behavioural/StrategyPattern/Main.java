package LLD.behavioural.StrategyPattern;

import LLD.behavioural.StrategyPattern.withstrategy.PassengerVehicle;
import LLD.behavioural.StrategyPattern.withstrategy.Vehicle;

public class Main {

    public static void main(String[] args) {
//        Vehicle vehicle = new SportsVehicle();
//        Vehicle vehicle = new OffRoadVehicle();
//        Vehicle vehicle = new GoodsVehicle();
        Vehicle vehicle = new PassengerVehicle();
        vehicle.drive();
    }
}
