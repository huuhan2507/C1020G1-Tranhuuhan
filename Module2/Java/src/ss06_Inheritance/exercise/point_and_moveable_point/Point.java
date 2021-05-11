package ss06_Inheritance.exercise.point_and_moveable_point;

import java.util.Arrays;

public class Point {
    public float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0.0f, 0.0f);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] arr = {x, y};
        return arr;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}' + "\n" + "[x,y]= " + Arrays.toString(getXY());
    }

    public static void main(String[] args) {
        Point point = new Point();
        Point point1 = new Point(5, 7);
        System.out.println(point.toString());
        System.out.println(point1.toString());
    }
}
