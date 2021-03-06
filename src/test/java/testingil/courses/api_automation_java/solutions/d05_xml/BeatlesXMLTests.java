package testingil.courses.api_automation_java.solutions.d05_xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeatlesXMLTests {

    private Document doc;
    private Element rootElement;

    @BeforeEach
    public void setup() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        var db = dbf.newDocumentBuilder();
        doc = db.parse(new File(".//src//main//resources//Beatles.xml"));
        rootElement = doc.getDocumentElement();
    }

    @Test
    public void there_are_four_artists(){
        var artist_list = rootElement.getElementsByTagName("Artist");
        assertEquals(4, artist_list.getLength());
    }

    @Test
    public void two_are_dead_and_two_are_alive(){
        var artist_list = rootElement.getElementsByTagName("Artist");
        int countAlive = 0;
        int countDead=0;
        for (int i=0; i< artist_list.getLength(); i++){
            var artist = (Element) artist_list.item(i);
            String isAliveText = artist.getElementsByTagName("IsAlive").item(0).getTextContent();
            if (isAliveText.equals("Yes"))
                countAlive++;
            if (isAliveText.equals("No"))
                countDead++;
        }
        assertEquals(2, countAlive);
        assertEquals(2, countDead);

    }

    @Test
    public void ringo_plays_drums(){
        Boolean ringo_plays_drums = false;
        var artist_list = rootElement.getElementsByTagName("Artist");
        for (int i=0; i< artist_list.getLength(); i++) {
            var artist = (Element) artist_list.item(i);
            String name = artist.getAttribute("name");
            if (name.equals("Ringo Starr")) {
                if (artist.getElementsByTagName("Plays").item(0).getTextContent().equals("Drums"))
                    ringo_plays_drums = true;
                break;
            }
        }
        assertTrue(ringo_plays_drums);
    }
}
