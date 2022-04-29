package testingil.courses.api_automation_java.solutions.d02_calculator_display;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 1. Write tests
// 2. Incremental coding
public class CalculatorDisplayTests {

    @Test
    public void at_start_display_0() {
        CalculatorDisplay cd = new CalculatorDisplay();
        assertEquals(cd.getDisplay(), "0" );
    }

    @Test
    public void pressing_1_displays_1(){
        CalculatorDisplay cd = new CalculatorDisplay();
        cd.press("1");
        assertEquals(cd.getDisplay(), "1");
    }

    @Test
    public void pressing_12_displays_12(){
        CalculatorDisplay cd = new CalculatorDisplay();
        cd.press("1");
        cd.press("2");
        assertEquals(cd.getDisplay(), "12");
    }
}
