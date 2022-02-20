package testingil.courses.api_automation_java.d08_combo;

import java.util.ArrayList;
import java.util.List;

public class MCU {

    public List<Movie> movies = new ArrayList<>();
    public void addMovie(Movie name) {
        movies.add(name);
    }
}
