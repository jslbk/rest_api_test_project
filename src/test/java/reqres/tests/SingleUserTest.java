package reqres.tests;

import io.qameta.allure.Feature;
import models.UserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specifications.Specs.requestSpec;
import static specifications.Specs.responseSpec;

@Feature("User data verification")
@DisplayName("Single user api tests")
@Tag("user_test")
public class SingleUserTest extends TestBase {

    @Test
    @DisplayName("Verify not found response for specific user")
    @Tag("Negative")
    void testSpecificUserNotFound() {
        step("Make request and check status", () -> given(requestSpec)

                .when()
                .get("/users/23")

                .then()
                .statusCode(404));
    }

    @Test
    @DisplayName("Verify response data for specific user")
    @Tag("Positive")
    void testSpecificUserData() {
        UserResponseModel response = step("Make request", () -> given(requestSpec)

                .when()
                .get("/users/4")

                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(UserResponseModel.class));
        step("Check response", () -> {
            assertEquals("eve.holt@reqres.in", response.getData().getEmail());
            assertEquals("Eve", response.getData().getFirstName());
            assertEquals("Holt", response.getData().getLastName());
            assertEquals("https://reqres.in/img/faces/4-image.jpg", response.getData().getAvatar());
        });
    }

}
