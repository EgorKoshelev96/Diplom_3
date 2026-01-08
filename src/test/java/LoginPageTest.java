import extensions.BrowserExtensions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {

    @RegisterExtension
    public BrowserExtensions browserExtensions = new BrowserExtensions();

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void entranceOnMain() {
        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());

        loginPage.clickLoginToAccountButton();
        loginPage.setEmailInput("QWEQRE@EQ.RU");
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", loginPage.placeOrderButton());
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginPersonalAccount() {
        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());

        registrationPage.clickCabinetButton();
        loginPage.setEmailInput("QWEQRE@EQ.RU");
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", loginPage.placeOrderButton());
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void loginRegistrationButton() {
        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());

        loginPage.clickLoginToAccountButton();
        registrationPage.clickRegisterButton();
        loginPage.clickloginRegistrationButton();
        loginPage.setEmailInput("QWEQRE@EQ.RU");
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", loginPage.placeOrderButton());
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginPasswordRecoveryPassword() {
        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());

        loginPage.clickLoginToAccountButton();
        loginPage.clickRecoverPasswordButton();
        loginPage.clickloginRegistrationButton();
        loginPage.setEmailInput("QWEQRE@EQ.RU");
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        assertEquals("Оформить заказ", loginPage.placeOrderButton());

    }




}
