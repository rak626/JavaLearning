package lld.LiskovPrinciple.Problem;

public class Car extends Vehicle {
    public Integer noOfWheels() {
        return 4;
    }
    public Boolean hasEngine() {
        return true;
    }
}
