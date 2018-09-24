package apiTests;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TryApi {
    String username = "webinar5";
    String password = "webinar5";
    String sessionId;

    @BeforeTest
    public void setupMethod(){
        RestAssured.baseURI = "http://jira.hillel.it";
        RestAssured.port = 8080;
    }

    @Test
    public void loginJira(){
        JSONObject login = new JSONObject();
        login.put("username",username);
        login.put("password",password);

        sessionId = given().header("Content-Type", "application/json").body(login.toString()).
                when().post("/rest/auth/1/session").then().statusCode(200).log().all().
                extract().path("session.value");
    }

}
