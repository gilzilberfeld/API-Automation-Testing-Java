package testingil.courses.api_automation_java.solutions.d08_combo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import testingil.courses.api_automation_java.d08_combo.MCU;
import testingil.courses.api_automation_java.d08_combo.Movie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AvengerTests {

    @Test
    public void mcu_films() throws JsonProcessingException, JSONException {
        MCU mcu = new MCU();
        mcu.addMovie(new Movie("Thor").withCharacter("Thor"));
        mcu.addMovie(new Movie("Captain America - The First Avenger").withCharacter("Cap"));
        mcu.addMovie(new Movie("Black Widow").withCharacter("Black Widow"));
        mcu.addMovie(new Movie("The Avengers")
                .withCharacter("Thor")
                .withCharacter("Cap")
                .withCharacter("Black Widow")
                .withCharacter("Hawkeye")
                .withCharacter("Hulk")
                .withCharacter("Iron Man"));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(mcu);
        assertTrue(json.contains("Cap"));
        assertTrue(json.contains("Hawkeye"));
        assertTrue(!json.contains("Ant-Man"));

        // the last one is not exact
        JSONObject jsonModel = new JSONObject(json);
        JSONObject jsonAvengers = jsonModel.getJSONArray("movies").getJSONObject(3);
        JSONArray jsonCharacters = jsonAvengers.getJSONArray("characters");
        Boolean isAntManThere = false;
        for (int i = 0; i< jsonCharacters.length(); i++){
            String characterName = jsonCharacters.getString(i);
            if (characterName.equals("Ant-Man")){
                isAntManThere = true;
                break;
            }
        }
        assertFalse(isAntManThere);

    }

}
