package testingil.courses.api_automation_java.d10_ra_exercises;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import testingil.courses.api_automation_java.d09_rest_assured.Todo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RA_Tests {

    // JsonPlaceHolder api
    // use body("size()") in the body to query the array size
    @Test
    public void number_of_total_posts_is_100(){
    }

    @Test
    public void title_of_first_post_for_userid_1_contains_facere(){
    }

    // apichallenges api
    @Test
    public void create_todo_and_get_it_by_its_id(){
        String request_body="{\n" +
                "            \"title\": \"My Todo\",\n" +
                "            \"doneStatus\": false,\n" +
                "            \"description\": \"dognabbit\"\n" +
                "        }";

    }

    // use body("Y", hasItem(X)); to find if the ID was added.
    @Test
    public void create_todo_and_check_if_added_to_todos(){
        String request_body="{\n" +
                "            \"title\": \"My Todo\",\n" +
                "            \"doneStatus\": false,\n" +
                "            \"description\": \"dognabbit\"\n" +
                "        }";

    }

    // use object for serialization
    // Update the description field
    @Test
    public void create_update_delete_todo(){
       Todo new_todo = new Todo();
       new_todo.title = "new title";
       new_todo.description = "new description";
       new_todo.doneStatus = false;

    }
}
