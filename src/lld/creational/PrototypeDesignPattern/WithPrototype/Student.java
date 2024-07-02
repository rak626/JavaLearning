package lld.creational.PrototypeDesignPattern.WithPrototype;

public class Student implements Prototype {
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

    @Override
    public Prototype clone() {
        return new Student(name, rollNumber, age);
    }
}
