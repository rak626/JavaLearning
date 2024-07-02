package lld.creational.PrototypeDesignPattern.WithoutPrototype;

public class Student {
    String name;
    private  int rollNumber;
    protected int  age;

    public Student() {
    }

    public Student(String name, int rollNumber, int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
    }
}
