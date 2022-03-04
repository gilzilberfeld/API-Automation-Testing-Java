package testingil.courses.api_automation_java.d09_rest_assured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class APIExampleTests2 {
    @Test
    public void capture_body_in_variable(){
        String userData =
                given().when().
                        get("http://jsonplaceholder.typicode.com/users/1").
                        then().
                        extract().asString();
        System.out.println("userData is: " + userData);
        assertThat(userData,containsString("Leanne Graham"));
    }

    @Test
    public void send_body_as_serialized_object(){
        Post newPost = new Post();
        newPost.title="gil-test";
        newPost.body = "bar";
        newPost.userId = 1;

        given().
                contentType(ContentType.JSON).
                body(newPost).
        when().
                post("http://jsonplaceholder.typicode.com/posts").
        then().
                assertThat().statusCode(201);
    }

    @Test
    public void load_response_body_into_object(){
        Post post =
                given().
                        pathParam("userId",1).
                when().
                        get("http://jsonplaceholder.typicode.com/posts/{userId}").
                        as(Post.class);
        assertThat(post.id, equalTo(1));
    }
    
    // jsonpath example
    // xmlpath example
    // put in both brances
    // then exercises

}