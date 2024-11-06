package LLD.creational.PrototypeDesignPattern.WithPrototype;

public class PrototypeClient {
    public static void main(String[] args) {
        Student obj = new Student("Rakesh", 20, 12);
        Student cloneObj = (Student) obj.clone();
        System.out.println(cloneObj.age + " " + cloneObj.name);
    }
}
