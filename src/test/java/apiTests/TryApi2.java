package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TryApi2 {
    String username = "webinar5";
    String password = "webinar5";
    String sessionId;

    @BeforeSuite
    public void setupMethod(){
        RestAssured.baseURI = "http://jira.hillel.it";
        RestAssured.port = 8080;
        JSONObject login = new JSONObject();
        login.put("username",username);
        login.put("password",password);

        sessionId = given().
                header("Content-Type", "application/json").
                body(login.toString()).
                when().
                post("/rest/auth/1/session").
                then().
                extract().path("session.value");
    }

    @Test
    public void searchIssueJQL(){

        JSONObject jqlRequest = new JSONObject();

        jqlRequest.put("jql", "project = QAAUT6");

        ValidatableResponse responseJQL=given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                body(jqlRequest).
                when().
                post("/rest/api/2/search").
                then().
                statusCode(200);
    }

    @Test
    public void getUser(){
        String User = "Artem Stolbtsov";

        ValidatableResponse responsegetIssuePriority = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("/rest/api/2/user/search?username=" + User).
                then().
                statusCode(200);
    }

    @Test
    public void getProject(){
        String nameProject = "QAAUT6";

        ValidatableResponse responsegetIssuePriority = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("/rest/api/2/project/" + nameProject).
                then().
                statusCode(200);
    }

    @Test
    public void getGroups(){
        String nameGroups = "jira-software-users";

        ValidatableResponse responsegetIssuePriority = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("/rest/api/2/groups/picker").
                then().
                statusCode(200).log().all();
    }


}
