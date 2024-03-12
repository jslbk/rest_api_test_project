package reqres.tests;

import io.qameta.allure.Feature;
import models.login.LoginBodyModel;
import models.registration.RegistrationResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specifications.Specs.requestSpec;
import static specifications.Specs.responseSpec;

@Feature("Login")
@DisplayName("Check login api")
@Tag("login_test")
public class LoginTest extends TestBase {

    @Test
    @DisplayName("Check user not found login response")
    @Tag("Negative")
    void testUserNotFound() {
        LoginBodyModel requestBody = new LoginBodyModel();
        requestBody.setEmail("bad@reqres.in");
        requestBody.setPassword("cityslicka");

        RegistrationResponseModel response = step("Make request", () -> given(requestSpec)
                .body(requestBody)

                .when()
                .post("/login")

                .then()
                .spec(responseSpec)
                .statusCode(400)
                .extract().as(RegistrationResponseModel.class));
        step("Check response", () ->
                assertEquals("user not found", response.getError()));
    }

    @Test
    @DisplayName("Check successful login response")
    @Tag("Positive")
    void testLoginSuccessful() {
        LoginBodyModel requestBody = new LoginBodyModel();
        requestBody.setEmail("eve.holt@reqres.in");
        requestBody.setPassword("cityslicka");

        step("Make request", () -> given(requestSpec)
                .body(requestBody)

                .when()
                .post("/login")

                .then()
                .spec(responseSpec)
                .statusCode(200)
                .body("token", notNullValue())
                .extract().as(RegistrationResponseModel.class));
    }

}