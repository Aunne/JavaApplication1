package javaapplication1.tw.edu.nkust.ic.lin;

public class People {
    People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void get() {
        System.out.println(this.age);
    }

    public String name;
    public int age;

}
