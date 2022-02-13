package testingil.courses.api_automation_java.d07.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Artist {
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Plays")
    public String plays;
    @JsonProperty("IsAlive")
    public String isAlive;
}
