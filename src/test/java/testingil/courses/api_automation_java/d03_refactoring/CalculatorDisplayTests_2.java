package testingil.courses.api_automation_java.d03_refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDisplayTests_2 {

    private CalculatorDisplay_2 calc;
    private String result;

    @BeforeEach
    public void setup(){
        calc = new CalculatorDisplay_2();
    }

    @Test
    public void on_start_show_0() {
        result = calc.getDisplay();
        assertEquals("0", result);
    }

    @Test
    public void only_numbers() {
        pressAll("13");
        result = calc.getDisplay();
        assertEquals("13", result);
    }

    @Test
    public void number_and_operation_show_only_number() {
        pressAll("1+");
        result = calc.getDisplay();
        assertEquals("1", result);
    }

    private void pressAll(String keys){
        keys.chars()
                .mapToObj (key ->(char) key)
                .forEach(key -> calc.press (key.toString()));
    }
}
