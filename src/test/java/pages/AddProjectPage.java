package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private static String END_POINT = "index.php?/admin/projects/add/1";

    //описание селекторов
    protected static final By nameInputBy = By.id("name");
    protected static final By announcementInputBy = By.id("announcement");
    protected static final By showAnnouncement = By.id("show_announcement");
    protected static final By singleForAllCasesType = By.id("suite_mode_single");
    protected static final By singleWithBaselineType = By.id("suite_mode_single_baseline");
    protected static final By multipleType = By.id("suite_mode_multi");
    protected static final By acceptButtonBy = By.id("accept");

//Инициализация класса
    public AddProjectPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
    driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return  getAcceptButton().isDisplayed();
        }catch (Exception ex){
        return false;}
    }

    // Методы для WebElement-ов

    public WebElement getNameInput(){
        return driver.findElement(nameInputBy);
    }
    public WebElement getAnnouncementInput(){
        return driver.findElement(announcementInputBy);
    }
    public WebElement getShowAnnouncement(){
        return driver.findElement(showAnnouncement);
    }
    public WebElement getSingleForAllCasesType(){
        return driver.findElement(singleForAllCasesType);
    }
    public WebElement getSingleWithBaselineType(){
        return driver.findElement(singleWithBaselineType);
    }
    public WebElement getmultipleType(){
        return driver.findElement(multipleType);
    }
    public WebElement getAcceptButton(){
        return driver.findElement(acceptButtonBy);
    }
}
