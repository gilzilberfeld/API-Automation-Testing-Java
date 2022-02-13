package testingil.courses.api_automation_java.d04_refactoring_tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class CalculatorTests {


    @Test
    void calc_test1() {
        Calculator calc = new Calculator();
        assertEquals("0", calc.getDisplay());

        calc.press("3");
        assertEquals("3", calc.getDisplay());
    }

    @Test
    void calc_test2() {
        Calculator calc = new Calculator();
        assertEquals("0", calc.getDisplay());

        calc.press("3");
        calc.press("+");
        assertEquals("3", calc.getDisplay());
    }

    @Test
    void calc_test3() {
        Calculator calc = new Calculator();
        assertEquals("0", calc.getDisplay());

        calc.press("3");
        calc.press("C");
        assertEquals("0", calc.getDisplay());
    }

}
