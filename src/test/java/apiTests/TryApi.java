package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import json.data.MappperJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.SampleMapper;

import static io.restassured.RestAssured.given;

public class TryApi {
    String username = "webinar5";
    String password = "webinar5";
    String sessionId;
    String issueId;
    String commentId;

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
    public void loginJira(){
        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("rest/api/2/issue/createmeta").
                then().
                statusCode(200);

        String issueKey = response.extract().asString();
    }

    @Test
    public void wrongLogin() {
        JSONObject login = new JSONObject();
        login.put("username", "blabla");
        login.put("password", password);

        ValidatableResponse responseWrongPass = given().
                header("Content-Type", "application/json").
                body(login.toString()).
                when().
                post("/rest/auth/1/session").
                then().
                statusCode(401);
    }

    @Test
    public void wrongPassword() {
        JSONObject login = new JSONObject();
        login.put("username", username);
        login.put("password", "pass");

        ValidatableResponse responseWrongPass = given().
                header("Content-Type", "application/json").
                body(login.toString()).
                when().
                post("/rest/auth/1/session").
                then().
                statusCode(401);
    }

    @Test
    public void createIssue(){
        /*String fieldProject="QAAUT6";
        String fieldSummary = "API test4";
        String fieldIssueType = "10105";
        String fieldAssigneeUser = "Artem Stolbtsov";

        JSONObject project = new JSONObject();
        JSONObject fields = new JSONObject();
        JSONObject issueType = new JSONObject();
        JSONObject assignee = new JSONObject();
        JSONObject issueCreate = new JSONObject();

        project.put("key", fieldProject);
        issueType.put("id", fieldIssueType);
        assignee.put("name", fieldAssigneeUser);
        fields.put("project",project);
        fields.put("issuetype", issueType);
        fields.put("assignee",assignee);
        fields.put("summary", fieldSummary);
        issueCreate.put("fields", fields);*/

        SampleMapper sampleMapper = new SampleMapper();

        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                body(SampleMapper.testMapper).
                when().
                post("/rest/api/2/issue").
                then().
                statusCode(201);

        issueId = response.extract().path("id");

    }

    @Test(dependsOnMethods = {"createIssue"})
    public void addComment(){
        JSONObject issueComment = new JSONObject();

        issueComment.put("body", "Added comment use to API");

        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                body(issueComment.toString()).
                when().
                post("/rest/api/2/issue/"+issueId+"/comment").
                //post("/rest/api/2/issue/34249/comment").
                then().
                statusCode(201);

        commentId = response.extract().path("id");
        Assert.assertEquals(response.extract().path("body"),"Added comment use to API");
    }

    @Test(dependsOnMethods = {"createIssue"})
    public void infoIssue(){
        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("/rest/api/2/issue/34249").then().statusCode(200);
    }

    @Test(dependsOnMethods = {"createIssue"})
    public void updatePriority(){
        //{"update":{"priority":[{"set":{"id":1}}]}}
        JSONObject changePriority = new JSONObject();
        JSONObject update =new JSONObject();
        JSONArray priority = new JSONArray();
        JSONObject inArray = new JSONObject();
        JSONObject set = new JSONObject();

        changePriority.put("update", update);
        update.put("priority", priority);
        priority.add(inArray);
        inArray.put("set", set);
        set.put("id","1");

        ValidatableResponse response=given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                body(changePriority.toString()).
                when().
                put("/rest/api/2/issue/"+issueId).
                //put("/rest/api/2/issue/34249").
                then().
                statusCode(204);

        String responseBody = response.extract().asString();
    }

    @Test (dependsOnMethods = "updatePriority")
    public void getIssuePriorityTest() {
        ValidatableResponse responsegetIssuePriority = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("/rest/api/2/issue/" + issueId ).
                then().
                statusCode(200);
        Assert.assertEquals(responsegetIssuePriority.extract().path("fields.priority.id"),"1");
    }


    @AfterTest
    public void deleteIssueTest() {
        ValidatableResponse responseDelete = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                delete("/rest/api/2/issue/" + issueId).
                then().
                statusCode(204).log().all();
    }

}
