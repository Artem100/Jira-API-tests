package oldApiTests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import json.issues.AddComment;
import json.issues.Fields;
import json.issues.Issue;
import json.authorization.LoginFields;
import json.updatePriority.Priority;
import json.updatePriority.Update;
import json.updatePriority.UpdateFieldsPriority;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TryApi {
    String sessionId;
    String issueId;
    String commentId;
    String set;

    public static LoginFields login;

/*
    @BeforeSuite
    public void setupMethod(){
        RestAssured.baseURI = "http://jira.hillel.it";
        RestAssured.port = 8080;

        login = new LoginFields("webinar5","webinar5");
        //authorization.setLogin("webinar5");
        //authorization.setPassword("webinar5");

        sessionId = given().
        header("Content-Type", "application/json").
        body(login).
        when().
        post("/rest/auth/1/session").
        then().log().all().statusCode(200).
        extract().path("session.value");

        System.out.println(sessionId);
    }

    @Test
    public void loginJira(){
        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("rest/api/2/issue/createmeta").
                then().
                log().all().
                statusCode(200);
    }

    @Test
    public void wrongLogin() {
        login = new LoginFields("webinar15","webinar5");

        ValidatableResponse responseWrongPass = given().
                header("Content-Type", "application/json").
                body(login).
                when().
                post("/rest/auth/1/session").
                then().
                statusCode(401);
    }

    @Test
    public void wrongPassword() {
        login = new LoginFields("webinar5","webinar15");

        ValidatableResponse responseWrongPass = given().
                header("Content-Type", "application/json").
                body(login).
                when().
                post("/rest/auth/1/session").
                then().
                statusCode(401);
    }

    @Test
    public void createIssue(){

        Fields fields = new Fields();
        fields.setAssigne("webinar5");
        fields.setIssueType("10105");
        fields.setProject("QAAUT6");
        fields.setSummary("Issue summary from the Automation Test");

        Issue issue = new Issue(fields);

        issueId = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                body(issue).
                when().
                post("/rest/api/2/issue").
                then().
                log().all().
                statusCode(201).extract().path("id");

    }

    @Test(dependsOnMethods = {"createIssue"})
    public void addComment(){

        AddComment addComment = new AddComment();
        addComment.setComment("Added comment use to API");

        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                body(addComment).
                when().
                post("/rest/api/2/issue/"+issueId+"/comment").
                then().log().all().
                statusCode(201);

        Assert.assertEquals(response.extract().path("body"),"Added comment use to API");
    }

    @Test(dependsOnMethods = {"createIssue"})
    public void infoIssue(){
        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                when().
                get("/rest/api/2/issue/"+ issueId).then().statusCode(200);
    }

    @Test(dependsOnMethods = {"createIssue"})
    public void updatePriority(){

        //{"update":{"priority":[{"set":{"id":1}}]}}

        Priority priority = new Priority("1");
        priority.set("1");
        Update update = new Update();
        update.setPriority(priority);
        UpdateFieldsPriority updateFields = new UpdateFieldsPriority(update);

        ValidatableResponse response=given().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + sessionId).
                body(updateFields).
                when().
                put("/rest/api/2/issue/"+issueId).
                then().log().all().
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

    */

}
