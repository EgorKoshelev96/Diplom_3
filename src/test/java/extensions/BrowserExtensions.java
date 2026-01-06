package extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.cert.Extension;

import static java.time.Duration.ofSeconds;

public class BrowserExtensions implements BeforeEachCallback, AfterEachCallback {

    private WebDriver webDriver;

    @Override
    public void afterEach(ExtensionContext context) {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(ofSeconds(3));
        webDriver.get("https://stellarburgers.education-services.ru/");

    }

    @Override
    public void beforeEach(ExtensionContext context) {
        webDriver.quit();
    }
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
