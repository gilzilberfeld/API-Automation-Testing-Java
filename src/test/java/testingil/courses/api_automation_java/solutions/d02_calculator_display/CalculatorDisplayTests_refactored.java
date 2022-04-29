package testingil.courses.api_automation_java.solutions.d02_calculator_display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDisplayTests_refactored {
    private CalculatorDisplay cd;

    @BeforeEach
    public void setup(){
        cd = new CalculatorDisplay();
    }

    @Test
    public void at_start_display_0() {
        assertEquals(cd.getDisplay(), "0" );
    }

    @Test
    public void pressing_1_displays_1(){
        cd.press("1");
        assertEquals(cd.getDisplay(), "1");
    }

    @Test
    public void pressing_12_displays_12() throws Exception{
        pressSequence("12");
        assertEquals(cd.getDisplay(), "12");
    }

    private void pressSequence(String sequence) throws Exception {
        sequence.chars().mapToObj(i -> (char) i).forEach(c -> {
            cd.press(c.toString());
        });
    }

}
