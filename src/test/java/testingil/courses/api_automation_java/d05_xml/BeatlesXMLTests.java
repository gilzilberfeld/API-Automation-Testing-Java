package testingil.courses.api_automation_java.d05_xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class BeatlesXMLTests {

    private Document doc;

    @BeforeEach
    public void setup() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        var db = dbf.newDocumentBuilder();
        doc = db.parse(new File(".//src//main//resources//Beatles.xml"));
    }

    @Test
    public void there_are_four_artists(){
    }

    @Test
    public void two_are_dead_and_two_are_alive(){

    }

    @Test
    public void ringo_plays_drums(){

    }
}
