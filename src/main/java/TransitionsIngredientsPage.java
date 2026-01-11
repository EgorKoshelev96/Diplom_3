import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class TransitionsIngredientsPage {

    private WebDriver webDriver;

    private final By buns = By.xpath("//div[contains(@class, 'tab_tab') and .//span[text()='Булки']]");
    private final By sauces = By.xpath("//div[contains(@class, 'tab_tab') and .//span[text()='Соусы']]");
    private final By fillings = By.xpath("//div[contains(@class, 'tab_tab') and .//span[text()='Начинки']]");

    private final String transitionsActive = "tab_tab_type_current__2BEPc";

    public TransitionsIngredientsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Нажимаем на раздел <<Булки>>")
    public void clickBuns() {
        webDriver.findElement(buns).click();
    }
    @Step("Нажимаем на раздел <<Соусы>>")
    public void clickSauces() {
        webDriver.findElement(sauces).click();
    }
    @Step("Нажимаем на раздел <<Начинки>>")
    public void clickFillings() {
        webDriver.findElement(fillings).click();
    }
    @Step("Проверяет активный ли сейчас класс у булок")
    public boolean bunsTransitionsActive() {
        WebElement tab = webDriver.findElement(buns);
        return Objects.requireNonNull(tab.getAttribute("class")).contains(transitionsActive);
    }
    @Step("Проверяет активный ли сейчас класс у соусов")
    public boolean saucesTransitionsActive() {
        WebElement tab = webDriver.findElement(sauces);
        return Objects.requireNonNull(tab.getAttribute("class")).contains(transitionsActive);
    }
    @Step("Проверяет активный ли сейчас класс у начинок")
    public boolean fillingsTransitionsActive() {
        WebElement tab = webDriver.findElement(fillings);
        return Objects.requireNonNull(tab.getAttribute("class")).contains(transitionsActive);
    }




}
