package testingil.courses.api_automation_java.d08_combo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaulTests {

    String artist_name;
    String instrument;
    private Boolean paul_plays_bass;

    @Test
    public void paul_plays_bass() throws Exception {
        paul_plays_bass = false;

        Element rootElement = getRootElement();
        var artist_list = rootElement.getElementsByTagName("Artist");
        find_paul_in_xml(artist_list);
        assertTrue(paul_plays_bass);

        // reset result
        paul_plays_bass = false;

        find_paul_in_json();
        assertTrue(paul_plays_bass);
    }

    private void find_paul_in_json() throws IOException, JSONException {
        JSONArray jsonArtists = getJsonArtists();
        for (int j = 0; j < jsonArtists.length(); j++) {
            JSONObject jsonArtist = jsonArtists.getJSONObject(j);

            artist_name = jsonArtist.getString("Name");
            instrument = jsonArtist.getString("Plays");

            if (artist_name.equals("Paul McCartney") && instrument.equals("Bass")) {
                paul_plays_bass = true;
                break;
            }
        }
    }

    private JSONArray getJsonArtists() throws IOException, JSONException {
        String json = Files.readString(Path.of(".//src//main//resources//Beatles.JSON"));
        JSONObject jsonBeatles = new JSONObject(json).optJSONObject("Beatles");
        JSONArray jsonArtists = jsonBeatles.getJSONArray("Artists");
        return jsonArtists;
    }

    private void find_paul_in_xml(NodeList artist_list) {
        for (int i = 0; i < artist_list.getLength(); i++) {
            // get the artist element
            var artistElement = (Element) artist_list.item(i);

            artist_name = artistElement.getAttribute("name");

            // get the instrument
            Node instrument_node = artistElement.getElementsByTagName("Plays").item(0);
            instrument = instrument_node.getTextContent();

            if (artist_name.equals("Paul McCartney") && instrument.equals("Bass")) {
                paul_plays_bass = true;
                break;
            }
        }
    }

    private Element getRootElement() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        var db = dbf.newDocumentBuilder();
        var doc = db.parse(new File(".//src//main//resources//Beatles.xml"));
        Element rootElement = doc.getDocumentElement();
        return rootElement;
    }


}
