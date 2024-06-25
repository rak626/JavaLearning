package LLD.LiskovPrinciple.Solution;

public class Bicycle extends Vehicle {
    @Override
    public Integer noOfWheels() {
        return 2;
    }
}
