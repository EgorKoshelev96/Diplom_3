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

    public void clickLoginToAccountButton() {
        webDriver.findElement(loginToAccountButton).click();
    }

    public void setEmailInput(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public String placeOrderButton() {
        return webDriver.findElement(placeOrderButton).getText();
    }

    public void clickloginRegistrationButton() {
        webDriver.findElement(loginRegistrationButton).click();
    }

    public void clickRecoverPasswordButton() {
        webDriver.findElement(recoverPasswordButton).click();
    }

}
