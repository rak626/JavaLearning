package LLD.LiskovPrinciple.Solution;

import java.util.ArrayList;
import java.util.List;

public class LiskovMainSolution {

    public static void main(String[] args) {
        List<EngineVehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car());
        vehicleList.add(new MotorCycle());
//        vehicleList.add(new Bicycle());

        for (var vehicle : vehicleList) {
            System.out.println(vehicle.noOfWheels().toString());
            System.out.println(vehicle.hasEngine().toString());
        }
    }
}
