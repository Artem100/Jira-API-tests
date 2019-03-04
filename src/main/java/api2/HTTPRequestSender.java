package api2;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import json.Pojo;
import json.authorization.LoginFields;

import static io.restassured.RestAssured.given;

// Class with API Methods

public class HTTPRequestSender {

    public static ValidatableResponse get(String path) {
        return given().
                contentType(ContentType.JSON).
                header("Cookie", "JSESSIONID=" + Autorization.coockieLogin).
                when().
                get(path).then();
    }

    public static ValidatableResponse post(String path, Pojo body) {
        return given().
                contentType(ContentType.JSON).
                header("Cookie", "JSESSIONID=" + Autorization.coockieLogin).
                when().
                body(body).
                post(path).
                then();
    }

    public static ValidatableResponse put(String path,  Pojo body){

        return given().
                contentType(ContentType.JSON).
                header("Cookie", "JSESSIONID=" + Autorization.coockieLogin).
                body(body).
                when().
                put(path).
                then();

    }

    public static ValidatableResponse delete(String path) {
        return given().
                contentType(ContentType.JSON).
                header("Cookie", "JSESSIONID=" + Autorization.coockieLogin).
                when().
                delete(path).
                then();
    }

}
