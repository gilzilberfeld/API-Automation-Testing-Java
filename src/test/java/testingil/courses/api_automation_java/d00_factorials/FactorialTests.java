package testingil.courses.api_automation_java.d00_factorials;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTests {
    @Test
    public void test_factorial(){
        int input = 3;
        int expected = 6;
        int result = Factorial.calculate(input);
        assertEquals(expected, result);
    }
}

