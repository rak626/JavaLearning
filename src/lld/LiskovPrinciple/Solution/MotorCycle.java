package lld.LiskovPrinciple.Solution;

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
