package lld.creational.BuilderDesignPattern.example2;

public class Car {
    private final int id;
    private final String brand;
    private final String model;
    private final String color;

    Car(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }
}
