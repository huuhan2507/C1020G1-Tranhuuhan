package ss07_abstract_class_and_interface.practice.interface_comparable;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    public ComparableCircle() {

    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return -1;
        else if (getRadius() < o.getRadius()) return 1;
        else return 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
