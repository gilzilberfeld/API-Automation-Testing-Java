package testingil.courses.api_automation_java.d03_refactoring;

public class CalculatorDisplay {

    String d = "0";
    public String getDisplay() {
        return d;
    }

    public void press(String s) {
        if (d.equals("0")){
            d = s;
        }
        else
            if (!s.equals( "+"))
                d +=s;
    }
}
