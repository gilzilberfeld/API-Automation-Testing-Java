package testingil.courses.api_automation_java.d06_JSON;

public class JSONExamples {

    public static String getPerson(){
        return "{\n" +
                "  \"Person\": {\n" +
                "    \"FirstName\": \"Joe\",\n" +
                "    \"SurName\": \"Smith\",\n" +
                "    \"Children\": [\n" +
                "      {\n" +
                "        \"child\": \"Jane\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"child\": \"Jim\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"child\": \"JJ\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }
}
