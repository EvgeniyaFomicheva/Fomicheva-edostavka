package by.edostavka.api;

import by.edostavka.data.Utils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginWithPasswordTest {
        private final String LOGIN_ENDPOINT = "https://edostavka.by/api/v2?path=auth\n";

    @Test
    public void loginWithSpecificIncorrectDataApi() {
        String requestBody = "{\"phone\":\"293119231\",\"password\":\"bhg\"}";

        given()
                .header("Content-Type", "application/json;charset=UTF-8")
                .body(requestBody)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .log().all()
                .statusCode(401)
                .body("unauthorized", equalTo(true));
    }
}
