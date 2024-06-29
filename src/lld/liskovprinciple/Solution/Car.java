package lld.liskovprinciple.Solution;

public class Car extends EngineVehicle {
    public Boolean hasEngine() {
        return true;
    }
    public Integer noOfWheels() {
        return 4;
    }
}
