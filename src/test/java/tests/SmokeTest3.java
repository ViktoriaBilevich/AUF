package tests;

import core.BrowsersService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

public class SmokeTest3 {
    @Test
    public void LoginTest(){

        /*1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard*/
       /* ReadProperties readProperties = new ReadProperties();
        System.out.println(readProperties.getURL());
        System.out.println(readProperties.getBrowserName());*/

        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();

    //    driver.get(new ReadProperties().getURL());

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com","QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(driver.getTitle(), "All Projects - TestRail");
        driver.quit();

    }
    @Test
    public void LoginTestWithIncorrectCredentials(){

        /*1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard*/

        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();

    //    driver.get(new ReadProperties().getURL());

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com","qweqwe");

        Assert.assertEquals(loginPage.getErrorText(),"Email/Login or Password is incorrect. Please try again.");
        driver.quit();
    }

    @Test
    public void AddNewProjectTest(){

        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

      //  driver.get(new ReadProperties().getURL());

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com","QqtRK9elseEfAk6ilYcJ");

       dashboardPage.getSidebarProjectsAddButton().click();
        driver.quit();
    }
}
