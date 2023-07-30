package site.stellarburgers.steps.register;

import static io.restassured.RestAssured.given;
import static site.stellarburgers.config.AppConfig.REGISTER_URL;

public class RegisterUser {
    public void registerNewUser(Object body){
        given()
                .header("Content-type", "application/json")
                .body(body)
                .post(REGISTER_URL);
    }
}
