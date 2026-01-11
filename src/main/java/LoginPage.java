import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;

    private final By loginToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By emailInput = By.xpath("//input[@type='text']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By placeOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By loginRegistrationButton = By.xpath("//a[@href='/login']");
    private final By recoverPasswordButton = By.xpath("//a[@href='/forgot-password']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Нажимаем на кнопку <<Войти в аккаунт>>")
    public void clickLoginToAccountButton() {
        webDriver.findElement(loginToAccountButton).click();
    }
    @Step("Вводим данные в поле <<Email>>")
    public void setEmailInput(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }
    @Step("Нажимаем на кнопку <<Войти>>")
    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }
    @Step("Проверяем отображается ли кнопка <<Оформить заказ>>")
    public String placeOrderButton() {
        return webDriver.findElement(placeOrderButton).getText();
    }
    @Step("Нажимаем на кнопку <<Войти>> на странице регистрации")
    public void clickloginRegistrationButton() {
        webDriver.findElement(loginRegistrationButton).click();
    }
    @Step("Нажимаем на кнопку <<Восстановить пароль>> на странице Входа")
    public void clickRecoverPasswordButton() {
        webDriver.findElement(recoverPasswordButton).click();
    }

}
