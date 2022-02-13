package testingil.courses.api_automation_java.d05.xml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLExamples {

//    <Person>
//          <FirstName>Joe</FirstSmith>
//          <SecondName>Smith</SecondName>
//          <Children>
//              <Child name="Jane"/>
//              <Child name="Jim"/>
//              <Child name="JJ"/>
//          </Children>
//      </Person>

    public static String getPerson(){
        return "<Person>\n" +
                "  <FirstName>Joe</FirstName>\n" +
                "  <SurName>Smith</SurName>\n" +
                "  <Children>\n" +
                "    <Child name=\"Jane\"/>\n" +
                "    <Child name=\"Jim\"/>\n" +
                "    <Child name=\"JJ\"/>\n" +
                "  </Children>  \n" +
                "</Person>";
    }
}
