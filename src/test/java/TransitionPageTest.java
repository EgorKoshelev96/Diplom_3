import extensions.BrowserExtensions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransitionPageTest {
   String email = "qweqre@eq.ru";

    @RegisterExtension
    public BrowserExtensions browserExtensions = new BrowserExtensions();

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет».")
    public void CheckingClickThroughRatePersonalAccount() {

        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());
        TransitionPage transitionPage = new TransitionPage(browserExtensions.getWebDriver());

        loginPage.clickLoginToAccountButton();
        loginPage.setEmailInput(email);
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        registrationPage.clickCabinetButton();
        assertEquals(email, transitionPage.getName());
    }

    @Test
    @DisplayName("Проверь переход по клику на «Конструктор»")
    public void checkTransitionClickingConstructor() {
        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());
        TransitionPage transitionPage = new TransitionPage(browserExtensions.getWebDriver());


        loginPage.clickLoginToAccountButton();
        loginPage.setEmailInput(email);
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        registrationPage.clickCabinetButton();
        transitionPage.clickConstructor();
        assertEquals("Соберите бургер", transitionPage.getTextAssembleBurger());
    }

    @Test
    @DisplayName("Проверь переход по клику на логотип Stellar Burgers")
    public void checkTransitionClickingLogo() {
        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());
        TransitionPage transitionPage = new TransitionPage(browserExtensions.getWebDriver());

        loginPage.clickLoginToAccountButton();
        loginPage.setEmailInput(email);
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        registrationPage.clickCabinetButton();
        transitionPage.clickLogo();
        assertEquals("Соберите бургер", transitionPage.getTextAssembleBurger());
    }

    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете")
    public void checkLogoutClickingLogoutButton() {

        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());
        TransitionPage transitionPage = new TransitionPage(browserExtensions.getWebDriver());

        loginPage.clickLoginToAccountButton();
        loginPage.setEmailInput(email);
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        registrationPage.clickCabinetButton();
        transitionPage.exitButton();
        assertEquals("Вход", transitionPage.getHeaderLogin());
    }




}
