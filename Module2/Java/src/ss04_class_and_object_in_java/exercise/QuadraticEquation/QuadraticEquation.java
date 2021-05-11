package ss04_class_and_object_in_java.exercise.QuadraticEquation;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return getB() * getB() - 4 * getA() * getC();
    }

    public double getRoot1() {
        return (-getB() + Math.sqrt(getDiscriminant())) / 2 * getA();
    }

    public double getRoot2() {
        return (-getB() - Math.sqrt(getDiscriminant())) / 2 * getA();
    }

}
