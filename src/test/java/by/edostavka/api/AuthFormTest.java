package by.edostavka.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthFormTest {
    final String AuthFormPage_URL = "https://edostavka.by/api/v2?path=sms-send";

    @Test
    public void testEmptyPhoneNumber(){
        String requestBody = "{\n" +
                "  \"phone\": \" \"\n" +
                "}";

        given()
                .header("Content-Type", "application/json;charset=UTF-8")
                .body(requestBody)
                .when()
                .post(AuthFormPage_URL)
                .then()
                .log().all()
                .statusCode(401)
                .body("unauthorized", equalTo(true));
    }


    @Test
    public void testNotRegistratedPhoneNumber(){
        String requestBody = "{\n" +
                "  \"phone\": \"296657147\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json;charset=UTF-8")
                .body(requestBody)
                .when()
                .post(AuthFormPage_URL)
                .then()
                .log().all()
                .statusCode(401)
                .body("unauthorized", equalTo(true));
    }
}



