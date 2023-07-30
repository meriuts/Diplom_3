package site.stellarburgers.steps.delete;

import static io.restassured.RestAssured.given;
import static site.stellarburgers.config.AppConfig.DELETE_URL;

public class DeleteUser {
    public void deleteUser(String accessToken){
        given()
                .header("Authorization", accessToken)
                .delete(DELETE_URL);
    }
}
