package testingil.courses.api_automation_java.d07.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Beatles {
    @JsonProperty("Artists")
    public ArrayList<Artist> artists;
}
