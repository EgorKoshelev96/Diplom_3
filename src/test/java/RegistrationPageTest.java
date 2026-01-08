import com.github.javafaker.Faker;
import extensions.BrowserExtensions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest {
    Faker faker = new Faker();

    @RegisterExtension
    public BrowserExtensions browserExtensions = new BrowserExtensions();

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());
        registrationPage.clickCabinetButton();
        registrationPage.clickRegisterButton();
        registrationPage.setNameInput(faker.name().firstName());
        registrationPage.setEmailInput(faker.internet().emailAddress());
        registrationPage.setPasswordInput(faker.internet().password(6, 12, true, true, true));
        registrationPage.clickLoginRegisterButton();
        assertEquals("Войти", registrationPage.loginButton());
    }
    @Test
    @DisplayName("Проверка размера пароля")
    public void errorIncorrectPassword() {
        RegistrationPage registrationPage = new RegistrationPage(browserExtensions.getWebDriver());
        registrationPage.clickCabinetButton();
        registrationPage.clickRegisterButton();
        registrationPage.setNameInput(faker.name().firstName());
        registrationPage.setEmailInput(faker.internet().emailAddress());
        registrationPage.setPasswordInput(faker.internet().password(1, 5, true, true, true));
        registrationPage.clickLoginRegisterButton();
        assertEquals("Некорректный пароль", registrationPage.incorrectPassError());
    }


}
