package testingil.courses.api_automation_java.d02_calculatordisplay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDisplayTests {

    @Test
    public void first_test(){
        CalculatorDisplay cd = new CalculatorDisplay();
        cd.press("0");
        assertEquals("0", cd.getDisplay());
    }
}
