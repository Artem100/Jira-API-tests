package apiTests;

import api2.Autorization;
import api2.JSONFixture;
import api2.JiraAPIActions;
import io.restassured.response.ValidatableResponse;
import json.authorization.LoginFields;
import json.issues.AddComment;
import json.issues.CreateIssue;
import json.issues.JqlRequest;
import json.updatePriority.UpdateFieldsPriority;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class JiraApi {

    String project="QAAUT6";
    String issueId;
    private static ResourceBundle credentials = ResourceBundle.getBundle("credentials");



    @BeforeSuite
    public void setup() { Autorization.loginJira(); }

    @Test
    public void loginPositive(){
        LoginFields login = JSONFixture.loginToJira((credentials.getString("username")),
                (credentials.getString("username")));
        ValidatableResponse requestLogin = JiraAPIActions.login(login);
        Assert.assertEquals(requestLogin.extract().statusCode(), 200);
    }

    @Test
    public void wrongLogin(){
        LoginFields login = JSONFixture.loginToJira((credentials.getString("incorrectUsername")),
                (credentials.getString("password")));
        ValidatableResponse requestLogin = JiraAPIActions.login(login);
        Assert.assertEquals(requestLogin.extract().statusCode(), 401);
    }

    @Test
    public void wrongPassword(){
        LoginFields login = JSONFixture.loginToJira((credentials.getString("username")),
                (credentials.getString("incorrectPassword")));
        ValidatableResponse requestLogin = JiraAPIActions.login(login);
        Assert.assertEquals(requestLogin.extract().statusCode(), 401);
    }

    @Test
    public void createIssue(){
        String summary = "Created issue used to API";
        String assigne ="Artem Stolbtsov";
        String issueType = "10105";

        CreateIssue issue = JSONFixture.createDefaultIssue(project, summary, issueType, assigne);
        ValidatableResponse responseCreateIssue = JiraAPIActions.createIssue(issue);
        Assert.assertEquals(responseCreateIssue.extract().statusCode(), 201);

        issueId = responseCreateIssue.extract().path("id");
    }

    @Test(dependsOnMethods = {"createIssue"})
    public void infoIssue(){
        ValidatableResponse responseInfoIssue=JiraAPIActions.infoIssue(issueId).log().all();
        Assert.assertEquals(responseInfoIssue.extract().statusCode(), 200);
    }


    @Test(dependsOnMethods = {"createIssue"})
    public void addCommentToIssue(){
        String comment = "Added comment use to API";

        AddComment addComment = JSONFixture.addComment(comment);
        ValidatableResponse responseAddComment = JiraAPIActions.addComment(addComment, issueId).log().all();
        Assert.assertEquals(responseAddComment.extract().statusCode(), 201);
        Assert.assertEquals(responseAddComment.extract().path("body"),"Added comment use to API");
    }

    @Test(dependsOnMethods = {"createIssue"})
    public void updatePriority(){
        String priority = "1";

        UpdateFieldsPriority updateFieldsPriority = JSONFixture.updatepriority(priority);
        ValidatableResponse responseUpdatePriority = JiraAPIActions.updatePriority(updateFieldsPriority, issueId).log().all();
        Assert.assertEquals(responseUpdatePriority.extract().statusCode(), 204);
    }

    @Test (dependsOnMethods = "updatePriority")
    public void getIssuePriority(){
        ValidatableResponse responseGetPriorityIssue=JiraAPIActions.getPriority(issueId).log().all();
        Assert.assertEquals(responseGetPriorityIssue.extract().path("fields.priority.id"),"1");
    }

    @Test
    public void searchIssueJQL(){
        String jql = "project = QAAUT6";

        JqlRequest jqlRequest = JSONFixture.findUseToJQL(jql);
        ValidatableResponse responseSearchIssueJql=JiraAPIActions.searchIssueJQL(jqlRequest);
        Assert.assertEquals(responseSearchIssueJql.extract().statusCode(), 200);
    }

    @Test
    public void getUser(){
        String user = "Artem Stolbtsov";

        ValidatableResponse responseGetUser=JiraAPIActions.getUser(user);
        Assert.assertEquals(responseGetUser.extract().statusCode(), 200);
    }

    @Test
    public void getProject() {
        ValidatableResponse responseGetProject = JiraAPIActions.getProject(project);
        Assert.assertEquals(responseGetProject.extract().statusCode(), 200);
    }

    public void getGroups() {
        String nameGroup = "picker";

        ValidatableResponse responseGetGroup = JiraAPIActions.getGroup(nameGroup);
        Assert.assertEquals(responseGetGroup.extract().statusCode(), 200);

    }

    @AfterTest
    public void deleteIssue(){
        ValidatableResponse responseDeleteIssue = JiraAPIActions.deleteIssue(issueId).log().all();
        Assert.assertEquals(responseDeleteIssue.extract().statusCode(), 204);
    }

    @AfterSuite
    public void checkDeletedIssue(){
        ValidatableResponse responseDeletedIssue = JiraAPIActions.deleteIssue(issueId);
        Assert.assertEquals(responseDeletedIssue.extract().statusCode(), 404);
    }


}
