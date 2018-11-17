import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage2 extends BaseTest {

    @FindBy(xpath = "//*[@class=\"gLFyf gsfi\"]")
    private WebElement searchField2;

    public SearchPage2(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Method for identification field on display.
     * @return - true/false DisplayedSearchField
     */
    private boolean isDisplayedSearchField (){
        return searchField2.isDisplayed();
    }

    /**
     * Method for validation Page loaded.
     * @return - true/false PageLoaded
     */
    public boolean isPageLoaded (){
        return webDriver.getCurrentUrl().contains("google.com")
                && webDriver.getTitle().contains("Selenium - Поиск в Google")
                && isDisplayedSearchField();
    }
    /**
     * Method for find blocks with searchTerm on Page2 and count find block with searchTerm.
     * @param - find text searchTerm.
     * @return - count find block with searchTerm.
     */
    public int countSearchResultFromPage2 (String searchTerm){
        int count = 0;
        List<WebElement> searchResultsFromPage2 = webDriver.findElements(By.xpath("//div[@class='g']"));

        for (WebElement element : searchResultsFromPage2) {
            if(element.getText().toLowerCase().contains(searchTerm.toLowerCase())){
                count++;
            }
        }
        System.out.println("*****************************////******" + count);
        return count;

    }

}
