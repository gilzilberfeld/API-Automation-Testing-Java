package testingil.courses.api_automation_java.d06_JSON;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeatlesJSONTests {


    private JSONObject jsonBeatles;

    @BeforeEach
    public void setup() throws Exception {
        String json = Files.readString(Path.of(".//src//main//resources//Beatles.JSON"));
        jsonBeatles = new JSONObject(json).optJSONObject("Beatles");

    }

    @Test
    public void there_are_four_artists() throws Exception{

    }

    @Test
    public void two_are_dead_and_two_are_alive() {

    }

    @Test
    public void ringo_plays_drums() {

    }
}
