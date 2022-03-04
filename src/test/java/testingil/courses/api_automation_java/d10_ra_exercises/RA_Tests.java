package testingil.courses.api_automation_java.d10_ra_exercises;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RA_Tests {

    // JsonPlaceHolder api
    // use size() in the body to query the array size
    @Test
    public void number_of_total_posts_is_100(){
        given().
        when().
                get("http://jsonplaceholder.typicode.com/posts").
                then().
                body("size()", equalTo(100));
    }

    // JsonPlaceHolder api
    @Test
    public void title_of_first_post_for_userid_1_contains_facere(){
        given().
        when().
                get("http://jsonplaceholder.typicode.com/posts/1").
        then().
                body("title", containsString("facere"));
    }

    // apichallenges api
    @Test
    public void create_todo_and_get_it_by_its_id(){
        String request_body="{\n" +
                "            \"title\": \"My Todo\",\n" +
                "            \"doneStatus\": false,\n" +
                "            \"description\": \"dognabbit\"\n" +
                "        }";

        int id =
                given().
                    body(request_body).
                when().
                    post("http://apichallenges.herokuapp.com/todos").
                then().
                   statusCode(201).
                   extract().path("id");

        given().
                queryParam("id", id).
        when().
                get("http://apichallenges.herokuapp.com/todos").
        then().
                statusCode(200).
                log().all().
                body("todos[0].title", equalTo("My Todo"));
    }
}
