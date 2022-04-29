package testingil.courses.api_automation_java.d00_factorials;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTests_Parameterized {

    @Disabled
    @CsvSource({"1, 1",
            "2, 2",
            "3, 6",
            "-3, 0",
            "10, 3628800"})
    @ParameterizedTest
    public void factorial_tests_with_values(int input, int result) {
        Factorial factorial = new Factorial();
        assertEquals(result, Factorial.calculate(input));
    }

    @Disabled
    @MethodSource("factorial_values")
    @ParameterizedTest
    public void factorial_tests_with_method(int input, int result) {
        Factorial factorial = new Factorial();
        assertEquals(result, Factorial.calculate(input));

    }

    public static Stream<Arguments> factorial_values() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(-3, 0),
                Arguments.of(10, 3628800)
        );
    }

    @Disabled
    @CsvFileSource(resources = "/Factorials.csv")
    @ParameterizedTest
    public void factorial_tests_with_file(int input, int result) {
        Factorial factorial = new Factorial();

        assertEquals(result, Factorial.calculate(input));
    }
}
