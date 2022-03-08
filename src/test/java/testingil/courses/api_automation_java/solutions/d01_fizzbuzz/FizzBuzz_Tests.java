package testingil.courses.api_automation_java.solutions.d01_fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzz_Tests {
    @Test
    public void print_fizz_buzz(){
        FizzBuzz fb = new FizzBuzz();
        assertEquals ("1", fb.calculate(1));
        assertEquals ("fizz", fb.calculate(6));
        assertEquals ("buzz", fb.calculate(10));
        assertEquals ("fizzbuzz", fb.calculate(30));

    }

}
