package testingil.courses.api_automation_java.d05_xml;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import testingil.courses.api_automation_java.d05.xml.XMLExamples;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonXMLTests {


    @Test
    public void root_element_is_person() throws Exception {
        Document doc = read_xml(XMLExamples.getPerson());
        String root = doc.getDocumentElement().getNodeName();
        assertEquals("Person", root);
    }

    @Test void first_name_is_joe() throws Exception {
        Document doc = read_xml(XMLExamples.getPerson());
        Element rootElement = doc.getDocumentElement();
        String firstNameTag = rootElement.getElementsByTagName("FirstName").item(0).getNodeName();
        String firstName = rootElement.getElementsByTagName("FirstName").item(0).getTextContent();
        assertEquals("FirstName", firstNameTag);
        assertEquals("Joe", firstName);

    }

    @Test void joe_has_three_children() throws Exception {
        Document doc = read_xml(XMLExamples.getPerson());
        Element rootElement = doc.getDocumentElement();
        int num_of_children = rootElement.getElementsByTagName("Child").getLength() ;
        assertEquals(3, num_of_children);
    }

    @Test void second_child_name_is_jim() throws Exception {
        Document doc = read_xml(XMLExamples.getPerson());
        Element rootElement = doc.getDocumentElement();
        Node second_child_element = rootElement.getElementsByTagName("Child").item(1);
        String child_name = second_child_element.getAttributes().item(0).getTextContent() ;
        assertEquals("Jim", child_name);
    }

    private Document read_xml(String content) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        var db = dbf.newDocumentBuilder();
        Document doc = db.parse(new InputSource(new StringReader(content)));
        return doc;
    }
}
