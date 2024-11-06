package LLD.liskovprinciple.Solution;

public class MotorCycle extends EngineVehicle {
    @Override
    public Integer noOfWheels() {
        return 2;
    }
    @Override
    public Boolean hasEngine() {
        return true;
    }
}
