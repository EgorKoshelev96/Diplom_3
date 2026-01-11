import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver webDriver;

    private final By cabinetButton = By.xpath("//a[@href='/account']");
    private final By registerButton = By.xpath("//a[@href='/register']");
    private final By nameInput = By.xpath("//input[@name='name']");
    private final By emailInput = By.xpath(".//fieldset[2]//input");
    private final By passwordInput = By.xpath("//input[@type='password']");
    private final By loginRegisterButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By incorrectPassword = By.xpath("//p[text()='Некорректный пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    public RegistrationPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    @Step("Нажимаем на кнопку <<Личный кабинет>>")
    public void clickCabinetButton() {
        webDriver.findElement(cabinetButton).click();
    }
    @Step("Нажимаем на кнопку <<Зарегистрироваться>>")
    public void clickRegisterButton() {
        webDriver.findElement(registerButton).click();
    }
    @Step("Вводим данные в поле <<Имя>>")
    public void setNameInput(String name) {
        webDriver.findElement(nameInput).sendKeys(name);
    }
    @Step("Вводим данные в поле <<Email>>")
    public void setEmailInput(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }
    @Step("Вводим данные в поле <<Пароль>>")
    public void setPasswordInput(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }
    @Step("Нажимаем на кнопку <<Зарегистрироваться>> на странице Регистрация")
    public void clickLoginRegisterButton() {
        webDriver.findElement(loginRegisterButton).click();
    }
    @Step("Проверяем полученную запись об ошибке пароля")
    public String incorrectPassError() {
        return webDriver.findElement(incorrectPassword).getText();
    }
    @Step("Проверяем отображение кнопки <<Войти>>")
    public String loginButton() {
        return webDriver.findElement(loginButton).getText();
    }

}
