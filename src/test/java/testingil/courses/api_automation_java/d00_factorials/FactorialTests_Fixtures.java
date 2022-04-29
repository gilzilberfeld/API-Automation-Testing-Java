package testingil.courses.api_automation_java.d00_factorials;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTests_Fixtures {

    private Factorial factorial;

    @BeforeEach
    public void setup(){
        factorial = new Factorial();
    }

    @Test
    public void factorial_tests() {
        assertEquals(1, factorial.calculate(1));
        assertEquals(2, factorial.calculate(2));
        assertEquals(6, factorial.calculate(3));
    }

    @Disabled
    @Test
    public void negative_factorial() {
        assertEquals(0, factorial.calculate(-3));
    }

    @Test
    public void big_factorial() {
        assertEquals(3628800, factorial.calculate(10));
    }

}
