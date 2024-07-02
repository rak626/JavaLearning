package lld.creational.PrototypeDesignPattern.WithoutPrototype;

public class StudentMainRunner {
    public static void main(String[] args) {
        Student obj = new Student("Rakesh", 20, 12);

        Student cloneObj = new Student();
        cloneObj.name = obj.name;
        cloneObj.age = obj.age;
//        cloneObj.rollNumber = obj.rollNumber;
    }
}

/*
 * can't able to clone as rollNumber is private
 * that means client have no access to clone my previous object
 * */