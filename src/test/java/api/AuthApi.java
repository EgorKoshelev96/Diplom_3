package api;

import api.dto.UserLogin;
import api.dto.CreatingUser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi {

    public void registerUser(CreatingUser creatingUser) {
        given().log().all().header("Content-Type", "application/json")
                .body(creatingUser).when().post("/api/auth/register").then()
                .statusCode(200).log().all();
    }

    public void deleteUser(UserLogin userLogin) {
        Response loginResponse = given().log().all().header("Content-Type", "application/json")
                .body(userLogin).post("/api/auth/login");

        if (loginResponse.statusCode() != 200) {
            throw new RuntimeException("Авторизация не удалась. Статус: " + loginResponse.statusCode());
        }

        String fullToken = loginResponse.jsonPath().getString("accessToken");
        String accessToken = fullToken.replace("Bearer ", "");

        given().auth().oauth2(accessToken).header("Content-Type", "application/json")
                .body(userLogin).delete("/api/auth/user").then().statusCode(202);
    }
}
