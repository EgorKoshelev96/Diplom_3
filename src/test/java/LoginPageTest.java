import api.AuthApi;
import api.dto.CreatingUser;
import api.dto.UserLogin;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {
    private WebDriver webDriver;
    private AuthApi authApi = new AuthApi();
    private Faker faker = new Faker();
    private String email;
    private String password;
    private String name;

    @BeforeEach
    public void setUp() {
        email = faker.internet().emailAddress();
        password = faker.internet().password(6, 10, true, true, true);
        name = faker.name().firstName();

        CreatingUser creatingUser = new CreatingUser(email, password, name);


        this.webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(ofSeconds(3));
        webDriver.get("https://stellarburgers.education-services.ru");
        RestAssured.baseURI = "https://stellarburgers.education-services.ru";
        authApi.registerUser(creatingUser);

        }

    @AfterEach
    public void deleteUser() {
        UserLogin userLogin = new UserLogin(email, password);
        authApi.deleteUser(userLogin);

        }


    @AfterEach
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void entranceOnMain() {
        LoginPage loginPage = new LoginPage(webDriver);
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        loginPage.clickLoginToAccountButton();
        loginPage.setEmailInput(email);
        registrationPage.setPasswordInput(password);
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", loginPage.placeOrderButton());

    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginPersonalAccount() {
        LoginPage loginPage = new LoginPage(webDriver);
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        registrationPage.clickCabinetButton();
        loginPage.setEmailInput(email);
        registrationPage.setPasswordInput(password);
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", loginPage.placeOrderButton());
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void loginRegistrationButton() {
        LoginPage loginPage = new LoginPage(webDriver);
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        loginPage.clickLoginToAccountButton();
        registrationPage.clickRegisterButton();
        loginPage.clickloginRegistrationButton();
        loginPage.setEmailInput(email);
        registrationPage.setPasswordInput(password);
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", loginPage.placeOrderButton());
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginPasswordRecoveryPassword() {
        LoginPage loginPage = new LoginPage(webDriver);
        RegistrationPage registrationPage = new RegistrationPage(webDriver);

        loginPage.clickLoginToAccountButton();
        loginPage.clickRecoverPasswordButton();
        loginPage.clickloginRegistrationButton();
        loginPage.setEmailInput(email);
        registrationPage.setPasswordInput(password);
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", loginPage.placeOrderButton());

    }




}
