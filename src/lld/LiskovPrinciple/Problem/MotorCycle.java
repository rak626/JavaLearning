package lld.LiskovPrinciple.Problem;

public class MotorCycle extends Vehicle{
    @Override
    public Integer noOfWheels() {
        return 2;
    }
    @Override
    public Boolean hasEngine() {
        return true;
    }
}
