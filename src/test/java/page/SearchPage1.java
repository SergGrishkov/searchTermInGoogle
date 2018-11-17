package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage1 extends BasePage {

    @FindBy(xpath = "//*[@class=\"gLFyf gsfi\"]")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div[10]/div[1]/div[2]/div/div[5]/div/span[1]/div/table/tbody/tr/td[3]/a")
    private WebElement linkPage2;


    public SearchPage1(WebDriver webDriver){
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
     * Method, which click second Page and returned new Page.
     * @return - returned new page.SearchPage2
     */
    public SearchPage2 clickPage1(){
        waitUntilElementIsClickable(linkPage2);
        linkPage2.click();
        return new SearchPage2(webDriver);
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
     * Method for find blocks with searchTerm on Page1 and count find block with searchTerm.
     * @param - find text searchTerm.
     * @return - count find block with searchTerm.
     */
    public int  countSearchResultFromPage1 (String searchTerm){
        int count = 0;
        List<WebElement> searchResultsFromPage1 = webDriver.findElements(By.xpath("//div[@class='g']"));

        for (WebElement element : searchResultsFromPage1) {
            if(element.getText().toLowerCase().contains(searchTerm.toLowerCase())){
                count++;

            }
        }
        System.out.println("*****************************////******" + count);
        return count;

    }


}
