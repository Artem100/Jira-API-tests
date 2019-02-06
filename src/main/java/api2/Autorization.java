package api2;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import json.authorization.LoginFields;
import org.testng.Assert;

import java.util.ResourceBundle;

public class Autorization {
    public static String coockieLogin;

    private static ResourceBundle credentials = ResourceBundle.getBundle("credentials");


    public static void loginJira(){
        RestAssured.baseURI = "http://jira.hillel.it:8080";

        LoginFields login = JSONFixture.loginToJira((credentials.getString("username")),(credentials.getString("password")));
        ValidatableResponse requestLogin = JiraAPIActions.login(login);

        Assert.assertEquals(requestLogin.extract().statusCode(), 200);

        coockieLogin = requestLogin.extract().path("session.value");
    }
}
