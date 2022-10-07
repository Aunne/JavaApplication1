package javaapplication1;

public class Point {
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x = 0;
    private int y = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
