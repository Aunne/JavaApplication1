package javaapplication1.tw.edu.nkust.ic.lin;

public class student1 extends People {
    public student1(String name, double age, String sid) {
        super(name, 30);
        this.sid = sid;
        this.age = age;
    }

    public String sid;
    public double age;
}
