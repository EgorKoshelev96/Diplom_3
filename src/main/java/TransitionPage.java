import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransitionPage {
    private WebDriver webDriver;

    private final By email = By.xpath(".//li[2]//input");
    private final By constructor = By.xpath("//a[@href='/']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By assembleBurger = By.xpath("//h1[text()='Соберите бургер']");
    private final By exitButton = By.xpath("//button[text()='Выход']");
    private final By headerLogin = By.xpath("//h2[text()='Вход']");

    public TransitionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Сверяем полученный и отправленныый email")
    public String getName() {
        return webDriver.findElement(email).getAttribute("value");
    }
    @Step("Нажимаем на кнопку <<Конструктор>>")
    public void clickConstructor() {
        webDriver.findElement(constructor).click();
    }
    @Step("Сверяем полученный с заголовком <<Соберите бургер>>")
    public String getTextAssembleBurger() {
       return webDriver.findElement(assembleBurger).getText();
    }
    @Step("Нажимаем на Логотип")
    public void clickLogo() {
        webDriver.findElement(logo).click();
    }
    @Step("Нажимаем на кнопку <<Выход>>")
    public void exitButton() {
        webDriver.findElement(exitButton).click();
    }
    @Step("Сверяем с заголовком <<Вход>>")
    public String getHeaderLogin() {
        return webDriver.findElement(headerLogin).getText();
    }






}
