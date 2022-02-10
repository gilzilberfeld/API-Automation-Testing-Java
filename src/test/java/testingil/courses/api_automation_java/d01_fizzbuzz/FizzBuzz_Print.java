package testingil.courses.api_automation_java.d01_fizzbuzz;

import org.junit.jupiter.api.Test;

public class FizzBuzz_Print {
    @Test
    public void print_fizz_buzz(){
        FizzBuzz fb = new FizzBuzz();
        String result = fb.calculate(0);
        System.out.println(result);
    }

}
