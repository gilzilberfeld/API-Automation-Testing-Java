package testingil.courses.api_automation_java.d06_JSON;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import testingil.courses.api_automation_java.d05.xml.XMLExamples;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonJSONTests {
    @Test
    public void root_element_is_person() throws Exception {
        JSONObject json = new JSONObject(JSONExamples.getPerson());
        JSONObject jsonPerson = json.getJSONObject("Person");
        System.out.println(jsonPerson);
    }

    @Test void first_name_is_joe() throws Exception {
        JSONObject json = new JSONObject(JSONExamples.getPerson());
        JSONObject jsonPerson = json.getJSONObject("Person");
        String firstName = jsonPerson.getString("FirstName");
        assertEquals("Joe", firstName);

    }
    @Test void joe_has_three_children() throws Exception {
        JSONObject json = new JSONObject(JSONExamples.getPerson());
        JSONObject jsonPerson = json.getJSONObject("Person");
        int num_of_children = jsonPerson.getJSONArray("Children").length();
        assertEquals(3, num_of_children);
    }


    @Test void second_child_name_is_jim() throws Exception {
        JSONObject json = new JSONObject(JSONExamples.getPerson());
        JSONObject jsonPerson = json.getJSONObject("Person");

        JSONObject second_child = jsonPerson.getJSONArray("Children").getJSONObject(1);
        String child_name = second_child.getString("child");
        assertEquals("Jim", child_name);
    }
}
