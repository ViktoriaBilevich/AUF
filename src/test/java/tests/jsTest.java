package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class jsTest extends BaseTest {

    @Test
    public void jsTest() {
        WebDriver driver = browsersService.getDriver();
        driver.get("https://www.onliner.by/");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
