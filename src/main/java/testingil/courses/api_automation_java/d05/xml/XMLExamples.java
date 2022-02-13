package testingil.courses.api_automation_java.d05.xml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLExamples {

    public static String getPerson(){
        return "<Person>\n" +
                "  <FirstName>Joe</FirstName>\n" +
                "  <SecondName>Smith</SecondName>\n" +
                "  <Children>\n" +
                "    <Child name=\"Jane\"/>\n" +
                "    <Child name=\"Jim\"/>\n" +
                "    <Child name=\"JJ\"/>\n" +
                "  </Children>  \n" +
                "</Person>";
    }
}
