package testingil.courses.api_automation_java.d03_refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDisplayTests {

    @Test
    public void test1(){
        CalculatorDisplay cd = new CalculatorDisplay();
        String result = cd.getDisplay();
        assertEquals("0", result);
    }

    @Test
    public void test2(){
         CalculatorDisplay cd = new CalculatorDisplay();
         cd.press("1");
         cd.press("3");
         String result = cd.getDisplay();
         assertEquals("13", result);
    }

    @Test
    public void test3(){
        CalculatorDisplay cd = new CalculatorDisplay();
        cd.press("1");
        cd.press("+");
        String result = cd.getDisplay();
        assertEquals("1", result);
    }

}
