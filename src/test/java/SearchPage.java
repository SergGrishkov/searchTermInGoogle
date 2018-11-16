import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BaseTest {

    //WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"lst-ib\"]")
    private WebElement searchField;

    @FindBy(xpath = "//*[@aria-label=\"Page 2\"]")
    private WebElement page2;


    public SearchPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    private boolean isDisplayedSearchField (){
        return searchField.isDisplayed();
    }

    public void clickPage2(){
        page2.click();
    }

    public boolean isPageLoaded (){
        return webDriver.getCurrentUrl().contains("google.com")
                && webDriver.getTitle().contains("Google")
                && isDisplayedSearchField();
    }

    public void setSearchTerm (String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
    }

//    public void waitUntilElementIsSelected(WebElement webElement){
//        WebDriverWait wait = new WebDriverWait(webDriver, 10);
//        wait.until(ExpectedConditions.elementToBeSelected(searchField));
//    }

    public int  countSearchResult (String searchTerm){
        int count = 0;
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        for (WebElement element : searchResults) {
            if(element.getText().toLowerCase().contains(searchTerm.toLowerCase())){
                count++;
                //System.out.println(element.getText());
            }
        }
        return count;

    }


}
