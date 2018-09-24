package framework;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class RestConfiguration {

    @BeforeSuite(alwaysRun = true)
    public void configure(){
        RestAssured.baseURI= "http://jira.hillel.it";
        RestAssured.port =8080;
        //RestAssured.basePath="/people";
    }
}
