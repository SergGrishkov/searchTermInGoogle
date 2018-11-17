package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageBase extends BasePage {

    @FindBy(xpath = "//*[@class=\"gLFyf gsfi\"]")
    private WebElement searchField;


    public SearchPageBase(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Method for identification field on display.
     * @return - true/false DisplayedSearchField
     */
    private boolean isDisplayedSearchField (){
        return searchField.isDisplayed();
    }

    /**
     * Method for validation Page loaded.
     * @return - true/false PageLoaded
     */
    public boolean isPageLoaded (){
        return webDriver.getCurrentUrl().contains("google.com")
                && webDriver.getTitle().contains("Google")
                && isDisplayedSearchField();
    }

    /**
     * Method, which transmits searchTerm, click Find searchTerm and returned new Page.
     * @param - find text searchTerm.
     * @return - returned new page.SearchPage1
     */
    public SearchPage1 setSearchTerm (String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new SearchPage1(webDriver);

    }

}
