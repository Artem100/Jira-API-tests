package api2;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import json.authorization.LoginFields;
import org.testng.Assert;

public class Autorization {
    public static String coockieLogin;


    public static void loginJira(){
        RestAssured.baseURI = "http://jira.hillel.it:8080";

        LoginFields login = JSONFixture.loginToJira("webinar5", "webinar5");
        ValidatableResponse requestLogin = JiraAPIActions.login(login);

        Assert.assertEquals(requestLogin.extract().statusCode(), 200);

        coockieLogin = requestLogin.extract().path("session.value");
    }
}
