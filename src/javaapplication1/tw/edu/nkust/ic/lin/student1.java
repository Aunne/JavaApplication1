package javaapplication1.tw.edu.nkust.ic.lin;

public class student1 extends People {

    public student1(String name, int age, String sid) {
        super(name,age);
        this.sid = sid;
    }

    public String sid;
}
