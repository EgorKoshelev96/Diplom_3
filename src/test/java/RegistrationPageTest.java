import api.AuthApi;
import api.dto.UserLogin;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.RestAssured;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest {
    private WebDriver webDriver;
    private AuthApi authApi = new AuthApi();
    Faker faker = new Faker();
    private String email;
    private String password;
    private String name;

    @BeforeEach
    public void setUp() {
        this.webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(ofSeconds(3));
        webDriver.get("https://stellarburgers.education-services.ru");
        RestAssured.baseURI = "https://stellarburgers.education-services.ru";
        email = faker.internet().emailAddress();
        password = faker.internet().password(6, 10, true, true, true);
        name = faker.name().firstName();
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
            UserLogin userLogin = new UserLogin(email, password);
            authApi.deleteUser(userLogin);
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
