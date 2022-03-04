package testingil.courses.api_automation_java.d09_rest_assured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class APIExampleTests2 {
    @Test
    public void capture_body(){
        String userData =
                given().when().
                        get("http://jsonplaceholder.typicode.com/users/1").
                        then().
                        extract().asString();
        System.out.println("userData is: " + userData);
        assertThat(userData,containsString("Leanne Graham"));
    }


    // JSON serialization and deserialization
    // jsonpath example
    // xmlpath example
    // put in both brances
    // then exercises

}
