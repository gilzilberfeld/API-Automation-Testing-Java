package testingil.courses.api_automation_java.solutions.d02_calculator_display;

public class CalculatorDisplay {
    String display = "0";

    public String getDisplay() {
        return display;
    }

    public void press(String key) {
        if (display.equals("0"))
            display = key;
        else
            display += key;
    }
}

