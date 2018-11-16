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

    private boolean isDisplayedSearchField (){
        return searchField2.isDisplayed();
    }

    public boolean isPageLoaded (){
        //waitUntilElementIsSelected(searchField2);
        return webDriver.getCurrentUrl().contains("google.com")
                && webDriver.getTitle().contains("Selenium - Поиск в Google")
                && isDisplayedSearchField();
    }

    public int countSearchResultFromPage2 (String searchTerm){
        int count = 0;
        List<WebElement> searchResultsFromPage2 = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        for (WebElement element : searchResultsFromPage2) {
            if(element.getText().toLowerCase().contains(searchTerm.toLowerCase())){
                count++;
                //System.out.println(element.getText());
            }
        }
        return count;

    }

}
