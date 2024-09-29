package lld.creational.BuilderDesignPattern.example2;

public class BuilderRunner {
    /**
     * simple Builder example
     */
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();
        Car build = builder.id(21122)
                .brand("Mahindra")
                .model("Thar")
                .color("Grey")
                .build();
    }
}
