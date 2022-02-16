package testingil.courses.api_automation_java.d07_deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import testingil.courses.api_automation_java.d07.serialization.Root;

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
    public void two_are_dead_and_two_are_alive(){

    }

    @Test
    public void ringo_plays_drums(){

    }
}
