import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageBase extends BaseTest{

    @FindBy(xpath = "//*[@class=\"gLFyf gsfi\"]")
    private WebElement searchField;

    @FindBy(xpath = "//*[@aria-label=\"Поиск в Google\"]")
    private WebElement ariaLabel;


    public SearchPageBase(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    private boolean isDisplayedSearchField (){
        return searchField.isDisplayed();
    }

    public boolean isPageLoaded (){
        return webDriver.getCurrentUrl().contains("google.com")
                && webDriver.getTitle().contains("Google")
                && isDisplayedSearchField();
    }

    public SearchPage1 setSearchTerm (String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new SearchPage1(webDriver);

    }

}
