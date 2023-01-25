package javaapplication1;

public class student {
    int age;
    String name;

    student(int age, String name) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + this.age;
    }
}
