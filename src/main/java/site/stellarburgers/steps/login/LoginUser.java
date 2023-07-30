package site.stellarburgers.steps.login;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static site.stellarburgers.config.AppConfig.LOGIN_URL;

public class LoginUser {
    public Response loginNewUser(Object body){
        return given()
                .header("Content-type", "application/json")
                .body(body)
                .post(LOGIN_URL);
    }
}
