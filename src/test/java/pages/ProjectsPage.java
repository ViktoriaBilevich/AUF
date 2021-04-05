package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/overview";

    //описание селекторов
    protected static final By successLabelBy = By.className("message-success");
    protected static final By title = By.className("page_title");
    protected static final By addProjectName1 = By.xpath("//a[text()='VBilevich_1']");
    protected static final By addProjectName2 = By.xpath("//a[text()='VBilevich_2']");
    protected static final By addProjectName3 = By.xpath("//a[text()='VBilevich_3']");

    public ProjectsPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTitle().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    // Методы для WebElement-ов

    public WebElement getTitle(){
        return driver.findElement(title);
    }
    public String getSuccessLabelText(){
        return driver.findElement(successLabelBy).getText();
    }
    public String getAddProjectName1(){return driver.findElement(addProjectName1).getText();}
    public String getAddProjectName2(){return driver.findElement(addProjectName2).getText();}
    public String getAddProjectName3(){return driver.findElement(addProjectName3).getText();}

}
