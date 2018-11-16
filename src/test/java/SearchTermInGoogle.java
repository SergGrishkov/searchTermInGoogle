import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class SearchTermInGoogle extends BaseTest{

    @Test
    public void basicSearchTest () throws InterruptedException {
        SearchPage searchPage = new SearchPage(webDriver);
        Assert.assertTrue(searchPage.isPageLoaded(),"Search page is not loaded!");
        searchPage.setSearchTerm("Selenium");

        sleep(9000);
        searchPage.countSearchResult("Selenium");
        Assert.assertEquals(searchPage.countSearchResult("Selenium"),9,"Result incorrect!");
        System.out.println(searchPage.countSearchResult("Selenium"));

        searchPage.clickPage2();
        sleep(9000);
        searchPage.countSearchResult("Selenium");
        Assert.assertEquals(searchPage.countSearchResult("Selenium"),10,"Result incorrect!");
        System.out.println(searchPage.countSearchResult("Selenium"));

    }

}