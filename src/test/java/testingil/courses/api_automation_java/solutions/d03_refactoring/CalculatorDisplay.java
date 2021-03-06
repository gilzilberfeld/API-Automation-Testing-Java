package testingil.courses.api_automation_java.solutions.d03_refactoring;

public class CalculatorDisplay {

    String result = "0";

    public String getDisplay() {
        return result;
    }

    public void press(String key) {
        if (resultIs("0")) {
            result = key;
            return;
        }
        if (isNotOperation(key))
            result += key;
    }

    private boolean resultIs(String aResult) {
        return result.equals(aResult);
    }

    private boolean isNotOperation(String key) {
        return !key.equals("+");
    }
}
