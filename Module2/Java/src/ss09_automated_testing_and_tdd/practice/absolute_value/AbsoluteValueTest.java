package ss09_automated_testing_and_tdd.practice.absolute_value;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AbsoluteValueTest {
    @Test
    public void Absolute(){
        double firstNumber=-1;
        double testNumber=1;
        double result= AbsoluteValue.Absolute(firstNumber);
        assertEquals(testNumber,result);
    }
    @Test
    public void Absolute1(){
        double firstNumber=1;
        double testNumber=1;
        double result= AbsoluteValue.Absolute(firstNumber);
        assertEquals(testNumber,result);
    }
    @Test
    public void Absolute2(){
        double firstNumber=0;
        double testNumber=0;
        double result= AbsoluteValue.Absolute(firstNumber);
        assertEquals(testNumber,result);
    }

}
