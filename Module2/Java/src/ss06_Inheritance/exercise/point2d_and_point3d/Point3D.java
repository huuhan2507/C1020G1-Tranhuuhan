package ss06_Inheritance.exercise.point2d_and_point3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {

    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arr = {getX(), getY(), z};
        return arr;
    }

    public void setXYZ(float x, float y, float z) {

    }

    @Override
    public String toString() {
        return "Point3D: " + "\n" +
                "X: " + getX() + "\n" +
                "Y: " + getY() + "\n" +
                "Z: " + getZ() + "\n" +
                "[X,Y,Z]= " + Arrays.toString(getXYZ());
    }

    public static void main(String[] args) {
        Point3D point3D_1 = new Point3D();
        System.out.println(point3D_1.toString());
        Point3D point3D = new Point3D(6, 8, 3);
        System.out.println(point3D.toString());
    }
}
