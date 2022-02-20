package testingil.courses.api_automation_java.d06_JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeatlesJSONTests {


    private JSONObject jsonBeatles;

    @BeforeEach
    public void setup() throws Exception {
        String json = Files.readString(Path.of(".//src//main//resources//Beatles.JSON"));
        jsonBeatles = new JSONObject(json).optJSONObject("Beatles");

    }

    @Test
    public void there_are_four_artists() throws Exception{
        JSONArray jsonArtists = jsonBeatles.getJSONArray("Artists");
        assertEquals(4, jsonArtists.length());
    }

    @Test
    public void two_are_dead_and_two_are_alive() throws  Exception{
        int countAlive = 0;
        int countDead=0;
        JSONArray jsonArtists = jsonBeatles.getJSONArray("Artists");
        for (int i=0; i< jsonArtists.length(); i++){
            String isAliveText = jsonArtists.getJSONObject(i).getString("IsAlive");
            if (isAliveText.equals("Yes"))
                countAlive++;
            if (isAliveText.equals("No"))
                countDead++;
        }
        assertEquals(2, countAlive);
        assertEquals(2,countDead);
    }

    @Test
    public void ringo_plays_drums() throws Exception {
        Boolean ringo_plays_drums = false;
        JSONArray jsonArtists = jsonBeatles.getJSONArray("Artists");
        for (int i=0; i< jsonArtists.length(); i++){
            String name = jsonArtists.getJSONObject(i).getString("Name");
            String instrument = jsonArtists.getJSONObject(i).getString("Plays");
            if (name.equals("Ringo Starr") && instrument.equals("Drums")){
                ringo_plays_drums = true;
                break;
            }
        }
        assertTrue(ringo_plays_drums);
    }
}
