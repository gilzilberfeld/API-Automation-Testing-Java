package testingil.courses.api_automation_java.d07_serialization;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import testingil.courses.api_automation_java.d05.xml.XMLExamples;
import testingil.courses.api_automation_java.d07.serialization.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLDeserializationTests {

    @Test
    public void first_name_is_joe() throws Exception{
        XmlMapper xmlMapper = new XmlMapper();
        Person person
                = xmlMapper.readValue(XMLExamples.getPerson(), Person.class);
        assertEquals("Joe", person.FirstName);

    }

    @Test
    public void joe_has_three_children() throws Exception {

    }

    @Test
    public void second_child_name_is_jim() throws Exception {

    }
}
