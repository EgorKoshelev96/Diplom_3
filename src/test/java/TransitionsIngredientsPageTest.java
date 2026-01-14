import extensions.BrowserExtensions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransitionsIngredientsPageTest {

    @RegisterExtension
    public BrowserExtensions browserExtensions = new BrowserExtensions();

    @Test
    @DisplayName("Проверь, что работают переходы к разделу «Соусы»")
    public void checkTransitionToSauces() {
        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());
        TransitionsIngredientsPage transitionsIngredientsPage = new TransitionsIngredientsPage(browserExtensions.getWebDriver());

        loginPage.clickLoginToAccountButton();
        loginPage.setEmailInput("QWEQRE@EQ.RU");
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        transitionsIngredientsPage.clickSauces();
        assertTrue(transitionsIngredientsPage.saucesTransitionsActive(), "Переход по вкладке 'Соусы' не состоялся, вкладка не активна");
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделу «Булки»")
    public void checkTransitionToBuns() {
        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());
        TransitionsIngredientsPage transitionsIngredientsPage = new TransitionsIngredientsPage(browserExtensions.getWebDriver());

        loginPage.clickLoginToAccountButton();
        loginPage.setEmailInput("QWEQRE@EQ.RU");
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        transitionsIngredientsPage.clickSauces();
        transitionsIngredientsPage.clickBuns();
        assertTrue(transitionsIngredientsPage.bunsTransitionsActive(), "Переход по вкладке 'Булки' не состоялся, вкладка не активна");
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделу «Начинки»")
    public void checkTransitionToFillings() {
        LoginPage loginPage = new LoginPage(browserExtensions.getWebDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());
        TransitionsIngredientsPage transitionsIngredientsPage = new TransitionsIngredientsPage(browserExtensions.getWebDriver());

        loginPage.clickLoginToAccountButton();
        loginPage.setEmailInput("QWEQRE@EQ.RU");
        registrationPage.setPasswordInput("123456b");
        loginPage.clickLoginButton();
        transitionsIngredientsPage.clickFillings();
        assertTrue(transitionsIngredientsPage.fillingsTransitionsActive(), "Переход по вкладке 'Начинки' не состоялся, вкладка не активна");
    }



}
