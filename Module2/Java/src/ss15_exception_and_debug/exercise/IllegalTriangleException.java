package ss15_exception_and_debug.exercise;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(){
        super("The sum of 2 edges is less than the other side");
    }
    public IllegalTriangleException(String msg){
        super(msg);
    }
}
