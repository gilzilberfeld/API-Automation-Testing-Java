package testingil.courses.api_automation_java.solutions.d01_fizzbuzz;

public class FizzBuzz {
    public String calculate(int i) {
        if (i % 15 == 0)
            return "fizzbuzz";
        if (i % 3 ==0)
            return "fizz";
        if (i % 5 ==0)
            return "buzz";
        return Integer.toString(i);
    }
}
