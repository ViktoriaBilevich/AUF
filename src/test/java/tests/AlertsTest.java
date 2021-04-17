package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void simpleAlertTest() {

        WebDriver driver = browsersService.getDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement button = driver.findElement(By.xpath("//button[. ='Click for JS Alert']"));
        WebElement result = driver.findElement(By.id("result"));

        button.click();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        Assert.assertEquals(result.getText(), "You successfully clicked an alert");
    }

    @Test
    public void confirmationAlertTest() {

        WebDriver driver = browsersService.getDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement button = driver.findElement(By.xpath("//button[. ='Click for JS Confirm']"));
        WebElement result = driver.findElement(By.id("result"));

        button.click();

        Alert alert = driver.switchTo().alert();

        alert.dismiss();

        Assert.assertEquals(result.getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertTest() {

        WebDriver driver = browsersService.getDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement button = driver.findElement(By.xpath("//button[. ='Click for JS Prompt']"));
        WebElement result = driver.findElement(By.id("result"));

        button.click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Ok");
        alert.accept();

        Assert.assertEquals(result.getText(), "You entered: Ok");
    }
}
