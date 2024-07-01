package lld.creational.builderdesignpattern;

public class Car {
    private String wheelType;
    private String cheesesType;
    private Boolean isAutomated;

    private Car(CarBuilder carBuilder) {
        this.wheelType = carBuilder.wheelType;
        this.cheesesType = carBuilder.cheesesType;
        this.isAutomated = carBuilder.isAutomated;
    }

    public static CarBuilder builder(){
        return new CarBuilder();
    }
    public static class CarBuilder{
        private String wheelType;
        private String cheesesType;
        private Boolean isAutomated;

        CarBuilder() {
        }
        public CarBuilder wheelType(String wheelType){
            this.wheelType = wheelType;
            return this;
        }
        public CarBuilder cheesesType(String cheesesType){
            this.cheesesType = cheesesType;
            return this;
        }
        public CarBuilder isAutomated(Boolean isAutomated){
            this.isAutomated = isAutomated;
            return this;
        }
        public Car build(){
            return new Car(this);
        }

        @Override
        public String toString(){
            return "Car ( wheelType = " + this.wheelType + " cheesesType " + this.cheesesType + " isAutomated " + this.isAutomated + ")";
        }
    }
    public String getWheelType() {
        return wheelType;
    }

    public String getCheesesType() {
        return cheesesType;
    }

    public Boolean getAutomated() {
        return isAutomated;
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheelType='" + wheelType + '\'' +
                ", cheesesType='" + cheesesType + '\'' +
                ", isAutomated=" + isAutomated +
                '}';
    }
}
