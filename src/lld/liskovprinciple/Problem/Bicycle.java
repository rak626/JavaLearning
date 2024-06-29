package lld.liskovprinciple.Problem;

public class Bicycle extends Vehicle{
    @Override
    public Integer noOfWheels() {
        return 2;
    }
    @Override
    public Boolean hasEngine() {
        return null;
    }
}
