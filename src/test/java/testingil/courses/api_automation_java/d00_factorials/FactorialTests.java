package testingil.courses.api_automation_java.d00_factorials;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTests {
    @Test
    public void factorial_tests() {
        Factorial factorial = new Factorial();
        assertEquals(1, factorial.calculate(1));
        assertEquals(2, factorial.calculate(2));
        assertEquals(6, factorial.calculate(3));

    }

    @Disabled
    @Test
    public void negative_factorial() {
        Factorial factorial = new Factorial();
        assertEquals(0, factorial.calculate(-3));
    }

    @Test
    public void big_factorial() {
        Factorial factorial = new Factorial();
        assertEquals(3628800, factorial.calculate(10));
    }

}

