package testingil.courses.api_automation_java.d03_refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDisplayTests_1 {

    @Test
    public void test1(){
        CalculatorDisplay_1 cd = new CalculatorDisplay_1();
        String result = cd.getDisplay();
        assertEquals("0", result);
    }

    @Test
    public void test2(){
         CalculatorDisplay_1 cd = new CalculatorDisplay_1();
         cd.press("1");
         cd.press("3");
         String result = cd.getDisplay();
         assertEquals("13", result);
    }

    @Test
    public void test3(){
        CalculatorDisplay_1 cd = new CalculatorDisplay_1();
        cd.press("1");
        cd.press("+");
        String result = cd.getDisplay();
        assertEquals("1", result);
    }

}
