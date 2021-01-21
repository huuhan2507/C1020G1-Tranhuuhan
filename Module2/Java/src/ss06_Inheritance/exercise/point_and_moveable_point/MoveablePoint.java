package ss06_Inheritance.exercise.point_and_moveable_point;

import java.util.Arrays;

public class MoveablePoint extends Point {
    private float xSpeed, ySpeed;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] arr = {xSpeed, ySpeed};
        return arr;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public String toString() {
        return "(x,y) = (" + getX() + "," + getY() + ")" + "\n" + "Speed= " + Arrays.toString(getSpeed());
    }

    public String move() {
        x += xSpeed;
        y += ySpeed;
        return "Speed(x+xSpeed,y+ySpeed)= " + "(" + x + "," + y + ")";
    }

    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint.toString() + "\n" + moveablePoint.move());
        MoveablePoint moveablePoint1 = new MoveablePoint(5,9,6,6);
        System.out.println(moveablePoint1.toString() + "\n" + moveablePoint1.move());
    }

}
