package LLD.creational.BuilderDesignPattern.example1;

public class BuilderRunner {
    public static void main(String[] args) {
        House baseHouse = House.builder()
                .foundation("Base foundation")
                .roof("Base Roof")
                .interior("Base interior")
                .structure("Base Structure")
                .build();
        System.out.println(baseHouse);
        Car carBuilder = Car.builder()
                .wheelType("Base wheelType")
                .cheesesType("Base chessType")
                .isAutomated(false)
                .build();
        System.out.println(carBuilder);
        Car modernCar = Car.builder()
                .wheelType("Moder Wheel")
                .cheesesType("chess type")
                .isAutomated(true)
                .build();
        System.out.println(modernCar);
    }
}
