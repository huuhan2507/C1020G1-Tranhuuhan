package ss06_Inheritance.exercise.point2d_and_point3d;

import java.util.Arrays;

public class Point2D {
    private float x, y = 0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {

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
        float[] array = {x, y};
        return array;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D" + "\n" + "X: " + getX() + "\n" +
                "Y: " + getY() + "\n" +
                "[X,Y]= " + Arrays.toString(getXY());
    }

    public static void main(String[] args) {
        Point2D point2D_1 = new Point2D();
        System.out.println(point2D_1.toString());

        Point2D point2D = new Point2D(5, 7);
        System.out.println(point2D.toString());
    }
}
