package oldApiTests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import json.authorization.LoginFields;
import json.issues.JqlRequest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TryApi2 {

    public static JqlRequest jqlRequest;
    public static LoginFields login;
    String sessionId;
/*
    @BeforeSuite
    public void setupMethod(){
        RestAssured.baseURI = "http://jira.hillel.it";
        RestAssured.port = 8080;

        login = new LoginFields("webinar5","webinar5");

        sessionId = given().
                header("Content-Type", "application/json").
                body(login).
                when().
                post("/rest/auth/1/session").
                then().log().all().statusCode(200).
                extract().path("session.value");
    }

    @Test
    public void searchIssueJQL(){
                jqlRequest = new JqlRequest();
                jqlRequest.setJqlRequest("project = QAAUT6");


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
        String nameGroups = "picker";

        ValidatableResponse responsegetIssuePriority = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("/rest/api/2/groups/"+nameGroups).
                then().
                statusCode(200).log().all();
    }

*/
}
