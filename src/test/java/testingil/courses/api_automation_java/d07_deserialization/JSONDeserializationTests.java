package testingil.courses.api_automation_java.d07_deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import testingil.courses.api_automation_java.d07.serialization.Artist;
import testingil.courses.api_automation_java.d07.serialization.Root;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONDeserializationTests {

    @Test
    public void there_are_four_artists() throws Exception{
        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue((Paths.get(".//src//main//resources//Beatles.JSON").toFile()), Root.class);
        assertEquals(4, root.beatles.artists.size());
    }

    @Test
    public void two_are_dead_and_two_are_alive() throws Exception {
        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue((Paths.get(".//src//main//resources//Beatles.JSON").toFile()), Root.class);
        int isDeadCount=0;
        int isAliveCount=0;
        for (int i=0; i<root.beatles.artists.size(); i++){
            Artist artist = root.beatles.artists.get(i);
            if (artist.isAlive.equals("Yes"))
                isAliveCount++;
            if (artist.isAlive.equals("No"))
                isDeadCount++;
        }
        assertEquals(2, isAliveCount);
        assertEquals(2, isDeadCount);
    }

    @Test
    public void ringo_plays_drums() throws Exception {
        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue((Paths.get(".//src//main//resources//Beatles.JSON").toFile()), Root.class);
        Artist ringo = root.beatles.artists.get(3);
        assertEquals("Drums",ringo.plays);
    }
}
