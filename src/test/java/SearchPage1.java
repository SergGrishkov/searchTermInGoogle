import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage1 extends BaseTest {

    //WebDriver webDriver;

    @FindBy(xpath = "//*[@class=\"gLFyf gsfi\"]")
    private WebElement searchField;

    @FindBy(xpath = "//*[@aria-label=\"Page 2\"]")
    private WebElement linkPage2;


    public SearchPage1(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    private boolean isDisplayedSearchField (){
        return searchField.isDisplayed();
    }

    public SearchPage2 clickPage1(){
        linkPage2.click();
        //waitUntilElementIsClickable(linkPage2);
        return new SearchPage2(webDriver);
    }

    public boolean isPageLoaded (){
        //waitUntilElementIsSelected(searchField);
        return webDriver.getCurrentUrl().contains("google.com")
                && webDriver.getTitle().contains("Google")
                && isDisplayedSearchField();
    }

    public SearchPage2 setSearchTerm (String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        //waitUntilElementIsClickable(linkPage2);
        return new SearchPage2(webDriver);

    }

//    public void waitUntilElementIsSelected(WebElement webElement){
//        WebDriverWait wait = new WebDriverWait(webDriver, 10);
//        wait.until(ExpectedConditions.elementToBeSelected(searchField));
//    }

    public int  countSearchResultFromPage1 (String searchTerm){
        int count = 0;
        List<WebElement> searchResultsFromPage1 = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        for (WebElement element : searchResultsFromPage1) {
            if(element.getText().toLowerCase().contains(searchTerm.toLowerCase())){
                count++;
                //System.out.println(element.getText());
            }
        }
        return count;

    }


}
