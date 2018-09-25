package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TryApi2 {

    String username = "webinar5";
    String password = "webinar5";

    @Test
    public void wrongPassword() {
        RestAssured.baseURI = "http://jira.hillel.it";
        RestAssured.port = 8080;
        JSONObject login = new JSONObject();
        login.put(username, username);
        login.put(password, password);

        ValidatableResponse responseWrongPass = given().
                header("Content-Type", "application/json").
                body(login.toString()).
                when().
                post("/rest/auth/1/session").
                then().
                statusCode(400).log().all();
    }

}
