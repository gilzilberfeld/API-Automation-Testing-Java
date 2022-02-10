package testingil.courses.api_automation_java.d01_fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzz_Tests {
    @Test
    public void print_fizz_buzz(){
        FizzBuzz fb = new FizzBuzz();
        String calculate = fb.calculate(0);
        assertEquals ("0", calculate);
    }

}
