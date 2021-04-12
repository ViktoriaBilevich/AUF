package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginSteps;
import steps.ProjectSteps;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SmokeTest1 extends BaseTest {

    @Test(groups = {"smoke", "regression"}, timeOut = 5000l)
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

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com","QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");

    }

    @Test (groups = "regression", description = "Логин с некорректными данными")
    public void LoginTestWithIncorrectCredentials(){

        /*1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard*/

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com","qweqwe");

        Assert.assertEquals(loginPage.getErrorText(),"Email/Login or Password is incorrect. Please try again.");
    }

    @Test(enabled = false)
    public void AddNewProjectTest(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com","QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

        Project project = new Project();
        project.setName("Test Project AT");
        project.setAnnouncement("Test Project Definition");
        project.setShowAnnouncement(true);
        project.setType(ProjectType.MULTIPLE);

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.AddProject(project);

    }
    @Test
    public void waitTest() {
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.getEmailInput().sendKeys("atrostyanko+0401@gmail.com");
        loginPage.getPasswordInput().sendKeys("QqtRK9elseEfAk6ilYcJ");
        loginPage.getLogInButton().click();

        long start = new Date().getTime();
        WebElement element = waits.waitForVisibility(
                new DashboardPage(browsersService,false).getSidebarProjectsAddButton());
        long stop = new Date().getTime();
        System.out.println("Duration:" + (stop - start));

        Assert.assertTrue(element.isDisplayed());

        browsersService.getDriver().navigate().refresh();

        Wait<WebDriver> fluent = new FluentWait<>(browsersService.getDriver())
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(20, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        start = new Date().getTime();
        WebElement foo = fluent.until(driver -> browsersService.getDriver().findElement(By.id("sidebar-projects-add")));
        Assert.assertTrue(foo.isDisplayed());
        stop = new Date().getTime();
        System.out.println("Duration:" + (stop - start));
        browsersService.getDriver().navigate().refresh();

        WebElement foo1 = fluent.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidebar-projects-add")));
        Assert.assertTrue(foo1.isDisplayed());
    }

    @Test
    public void actionTest(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com","QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

        WebElement icon = waits.waitForVisibility(By.className("icon-markdown-table"));
        WebElement anon = waits.waitForVisibility(By.id("announcement"));

        Actions actions = new Actions(browsersService.getDriver());
        actions.moveToElement(icon).build().perform();
        Assert.assertTrue(waits.waitForAttributeContains(By.id("tooltip"), "style", "display: block"));

        actions
                .moveToElement(anon)
                .click()
                .sendKeys("Test")
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
           //     .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .sendKeys(Keys.ARROW_RIGHT)
          //      .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .build()
                .perform();




        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
