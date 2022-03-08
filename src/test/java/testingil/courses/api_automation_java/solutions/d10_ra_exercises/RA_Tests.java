package testingil.courses.api_automation_java.solutions.d10_ra_exercises;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import testingil.courses.api_automation_java.d09_rest_assured.Todo;

import static io.restassured.RestAssured.given;
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

    // use hasItem to find if the ID was added.
    @Test
    public void create_todo_and_check_if_added_to_todos(){
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
        when().
                get("http://apichallenges.herokuapp.com/todos").
        then().
                body("todos.id", hasItem(id));
    }

    // use object for serialization
    // Update the description field
    @Test
    public void create_update_delete_todo(){
       Todo new_todo = new Todo();
       new_todo.title = "new title";
       new_todo.description = "new description";
       new_todo.doneStatus = false;

       int id =
                given().
                        body(new_todo).
                when().
                        post("http://apichallenges.herokuapp.com/todos").
                then().
                        statusCode(201).
                        extract().path("id");

       new_todo.doneStatus = true;

        given().
                pathParam("todoId", id).
                contentType(ContentType.JSON).
                body(new_todo).
        when().
                post("http://apichallenges.herokuapp.com/todos/{todoId}").
        then().
                statusCode(200).
                body("doneStatus", is(true));

        given().
                pathParam("todoId", id).
        when().
                delete("http://apichallenges.herokuapp.com/todos/{todoId}").
        then().
                statusCode(200);

    }
}
