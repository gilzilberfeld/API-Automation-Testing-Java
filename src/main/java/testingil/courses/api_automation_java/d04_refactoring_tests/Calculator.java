package testingil.courses.api_automation_java.d04_refactoring_tests;

public class Calculator {
    String display = "";
    int lastArgument = 0;
    int result = 0;
    Boolean newArgument = false;
    Boolean shouldReset = true;

    OperationType lastOperation;


    public void press(String key) {
        if (key.equals("C"))
            display = "";
        else {
            if (key.equals("+")) {
                lastOperation = OperationType.Plus;
                lastArgument = Integer.parseInt(display);
                newArgument = true;
            } else {
                if (key.equals("/")) {
                    lastOperation = OperationType.Div;
                    lastArgument = Integer.parseInt(display);
                    newArgument = true;
                } else if (key.equals("=")) {
                    int currentArgument = Integer.parseInt(display);
                    if (lastOperation == OperationType.Plus) {
                        display = Integer.toString(lastArgument + currentArgument);
                    }
                    if (lastOperation == OperationType.Div && currentArgument == 0) {
                        display = "Division By Zero Error";
                    }
                    shouldReset = true;
                } else {
                    if (shouldReset) {
                        display = "";
                        shouldReset = false;
                    }
                    if (newArgument) {
                        display = "";
                        newArgument = false;
                    }
                    display += key;
                }
            }
        }
    }

    public String getDisplay() {
        if (display.equals(""))
            return "0";
        return display;
    }
}
