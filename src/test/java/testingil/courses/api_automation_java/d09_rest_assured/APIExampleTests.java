package testingil.courses.api_automation_java.d09_rest_assured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class APIExampleTests {
    @Test
    public void get_call_assert_status_and_body() {
        given().
        when().
                get("http://jsonplaceholder.typicode.com/users/1").
        then().
                assertThat().
                statusCode(200).
                body("name", equalTo("Leanne Graham"));
    }

    @Test
    public void get_call_with_logs() {
        given().
                log().all().
        when().
                get("http://jsonplaceholder.typicode.com/users/1").
        then().
                log().all().
                assertThat().statusCode(200);
    }

    @Test
    public void get_call_returns_json() {
        given().when().
            get("http://jsonplaceholder.typicode.com/users/1").
        then().
            assertThat().contentType(ContentType.JSON);
    }

    @Test
    public void get_call_with_query_parameter() {
        given().
                queryParam("userId",1).
        when().
                get("http://jsonplaceholder.typicode.com/posts").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void get_call_with_path_parameter() {
        given().
                pathParam("userId",1).
        when().
                get("http://jsonplaceholder.typicode.com/users/{userId}").
        then().
                assertThat().
                body("name", equalTo("Leanne Graham"));
    }

    @Test
    public void post_with_json_body(){
        String newPost = "{\n" +
                "    \"title\": \"gil-test\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}";
        given().
            contentType(ContentType.JSON).
            body(newPost).
        when().
            post("http://jsonplaceholder.typicode.com/posts").
        then().
               assertThat().statusCode(201);
    }


}
