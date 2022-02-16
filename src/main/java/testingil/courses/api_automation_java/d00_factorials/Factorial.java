package testingil.courses.api_automation_java.d00_factorials;

public class Factorial {
    public static int calculate(int number) {
        int i = 1;
        int result = 1;
        while (i <= number) {
            result = result * i;
            i++;
        }
        return result;
    }
}