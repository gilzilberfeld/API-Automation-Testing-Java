package testingil.courses.api_automation_java.solutions.d02_calculator_display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDisplayTests_parameterized_file {
    private CalculatorDisplay cd;

    @BeforeEach
    public void setup(){
        cd = new CalculatorDisplay();
    }

    @Test
    public void at_start_display_0() {
        assertEquals(cd.getDisplay(), "0" );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Calculator.csv")
    public void pressing_keys_and_displays(String keys, String result) throws Exception{
        pressSequence(keys);
        assertEquals(cd.getDisplay(), result);
    }

    private void pressSequence(String sequence) throws Exception {
        sequence.chars().mapToObj(i -> (char) i).forEach(c -> {
            cd.press(c.toString());
        });
    }

}
