import api.UserLogin;
import com.github.javafaker.Faker;
import extensions.BrowserExtensions;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest {
    private WebDriver webDriver;
    Faker faker = new Faker();
    private String email;
    private String password;
    private String name;
    String accessToken;

    @BeforeEach
    public void setUp() {
        this.webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(ofSeconds(3));
        RestAssured.baseURI = "https://stellarburgers.education-services.ru";
        webDriver.get("https://stellarburgers.education-services.ru");
        email = faker.internet().emailAddress();
        password = faker.internet().password(6, 10, true, true, true);
        name = faker.name().firstName();
    }
    @AfterEach
    public void deleteUser() {

        UserLogin userLogin = new UserLogin(email, password);
        Response loginResponse =
                given().header("Content-Type", "application/json")
                        .and().body(userLogin).when().post("/api/auth/login");
        if (loginResponse.statusCode() == 200) {
            String fullToken = loginResponse.jsonPath().getString("accessToken");
            accessToken = fullToken.replace("Bearer ", "");
            given().auth().oauth2(accessToken).header("Content-Type", "application/json")
                    .and().body(userLogin).when().delete("api/auth/user");
        }
    }
    @AfterEach
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
        @Test
        @DisplayName("Успешная регистрация")
        public void successfulRegistration () {
            RegistrationPage registrationPage = new RegistrationPage(webDriver);
            registrationPage.clickCabinetButton();
            registrationPage.clickRegisterButton();
            registrationPage.setNameInput(name);
            registrationPage.setEmailInput(email);
            registrationPage.setPasswordInput(password);
            registrationPage.clickLoginRegisterButton();
            assertEquals("Войти", registrationPage.loginButton());
        }
        @Test
        @DisplayName("Проверка размера пароля")
        public void errorIncorrectPassword () {
            RegistrationPage registrationPage = new RegistrationPage(webDriver);
            registrationPage.clickCabinetButton();
            registrationPage.clickRegisterButton();
            registrationPage.setNameInput(name);
            registrationPage.setEmailInput(email);
            registrationPage.setPasswordInput(faker.internet().password(1, 5, true, true, true));
            registrationPage.clickLoginRegisterButton();
            assertEquals("Некорректный пароль", registrationPage.incorrectPassError());
        }


    }
