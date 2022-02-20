package testingil.courses.api_automation_java.d08_combo;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    public String name;
    public List<String> characters;

    public Movie(String name) {
        this.name = name;
        characters = new ArrayList<String>();
    }

    public Movie withCharacter(String character) {
        characters.add(character);
        return this;
    }
}
