package reqres.tests;

import io.qameta.allure.Feature;
import models.registration.RegistrationBodyModel;
import models.registration.RegistrationResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static specifications.Specs.requestSpec;
import static specifications.Specs.responseSpec;

@Feature("Registration")
@DisplayName("Registration api tests")
@Tag("registration_test")
public class RegistrationTest extends TestBase {

    @Test
    @DisplayName("Verify successful registration")
    @Tag("Positive")
    void testSuccessfulRegistration() {
        RegistrationBodyModel requestBody = new RegistrationBodyModel();
        requestBody.setEmail("eve.holt@reqres.in");
        requestBody.setPassword("pistol");

        RegistrationResponseModel response = step("Make request", () -> given(requestSpec)
                .body(requestBody)

                .when()
                .post("/register")

                .then()
                .spec(responseSpec)
                .statusCode(200)
                .body("token", allOf(
                        notNullValue(),
                        matchesPattern(".*[a-zA-Z].*[0-9].*"),
                        hasLength(17)))
                .extract().as(RegistrationResponseModel.class));
        step("Check response", () ->
                assertEquals(4, response.getId()));
    }

    @Test
    @DisplayName("Verify bad email registration")
    @Tag("Negative")
    void testRegisterBadEmail() {
        RegistrationBodyModel requestBody = new RegistrationBodyModel();
        requestBody.setEmail("bad@reqres.in");
        requestBody.setPassword("pistol");

        RegistrationResponseModel response = step("Make request", () -> given(requestSpec)
                .body(requestBody)

                .when()
                .post("/register")

                .then()
                .spec(responseSpec)
                .statusCode(400)
                .extract().as(RegistrationResponseModel.class));
        step("Check response", () ->
                assertEquals("Note: Only defined users succeed registration", response.getError()));
    }

    @Test
    @DisplayName("Verify empty email registration")
    @Tag("Negative")
    void testRegisterEmptyEmail() {
        RegistrationBodyModel requestBody = new RegistrationBodyModel();
        requestBody.setEmail("");
        requestBody.setPassword("pistol");

        RegistrationResponseModel response = step("Make request", () -> given(requestSpec)
                .body(requestBody)

                .when()
                .post("/register")

                .then()
                .spec(responseSpec)
                .statusCode(400)
                .extract().as(RegistrationResponseModel.class));
        step("Check response", () ->
                assertEquals("Missing email or username", response.getError()));
    }

    @Test
    @DisplayName("Verify empty password registration")
    @Tag("Negative")
    void testRegisterEmptyPassword() {
        RegistrationBodyModel requestBody = new RegistrationBodyModel();
        requestBody.setEmail("eve.holt@reqres.in");
        requestBody.setPassword("");

        RegistrationResponseModel response = step("Make request", () -> given(requestSpec)
                .body(requestBody)

                .when()
                .post("/register")

                .then()
                .spec(responseSpec)
                .statusCode(400)
                .extract().as(RegistrationResponseModel.class));
        step("Check response", () ->
                assertEquals("Missing password", response.getError()));
    }

}