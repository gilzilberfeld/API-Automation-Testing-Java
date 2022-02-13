package testingil.courses.api_automation_java.d03_refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDisplayTests_2 {

    private CalculatorDisplay_2 calc;

    @BeforeEach
    public void setup(){
        calc = new CalculatorDisplay_2();
    }

    @Test
    public void on_start_show_0() {
        assertEquals("0", calc.getDisplay());
    }

    @Test
    public void only_numbers() {
        pressAll("13");
        assertEquals("13", calc.getDisplay());
    }

    @Test
    public void number_and_operation_show_only_number() {
        pressAll("1+");
        assertEquals("1", calc.getDisplay());
    }

    private void pressAll(String keys){
        keys.chars()
                .mapToObj (key ->(char) key)
                .forEach(key -> calc.press (key.toString()));
    }
}
