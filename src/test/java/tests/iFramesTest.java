package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Waits;

import java.util.List;

public class iFramesTest extends BaseTest {

    @Test
    public void switchToFrameTest() {

        WebDriver driver = browsersService.getDriver();

        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");

        WebElement textInputArea = driver.findElement(By.cssSelector("#tinymce > p"));

        textInputArea.clear();
        textInputArea.sendKeys("Some text for the frame");

        driver.switchTo().parentFrame();

        WebElement alignCenterButton = driver.findElement(By.cssSelector("button[aria-label='Align center'] svg"));
        alignCenterButton.click();
    }

    @Test
    public void findProductInFrameTest() {

        WebDriver driver = browsersService.getDriver();
        driver.get("https://www.onliner.by/");

        WebElement fastSearchInput = driver.findElement(By.className("fast-search__input"));

        fastSearchInput.click();
        fastSearchInput.sendKeys("Тостер");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-iframe")));

        driver.switchTo().frame(driver.findElement(By.className("modal-iframe")));

        List<WebElement> products = driver.findElements(By.cssSelector(".product__title .product__title-link"));
        WebElement firstProduct = products.get(0);

        WebElement searchInput = driver.findElement(By.className("search__input"));
        WebElement searchCloseButton = driver.findElement(By.className("search__close"));

        String firstProductName = firstProduct.getText();

        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(firstProductName);

        searchCloseButton.click();
    }
}
