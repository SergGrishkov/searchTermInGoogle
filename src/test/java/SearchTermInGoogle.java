import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class SearchTermInGoogle extends BaseTest{

    @Test
    public void basicSearchPage1 () throws InterruptedException {
        SearchPageBase searchPageBase = new SearchPageBase(webDriver);
        Assert.assertTrue(searchPageBase.isPageLoaded(),"Search BasePage is not loaded!");

        SearchPage1 searchPage1 = searchPageBase.setSearchTerm("Selenium");
        //sleep(3000);
        Assert.assertTrue(searchPage1.isPageLoaded(),"Search Page1 is not loaded!");
        //searchPage1 = searchPage1.setSearchTerm("Selenium");

        //sleep(3000);
        searchPage1.countSearchResultFromPage1("Selenium");
        //Assert.assertEquals(searchPage1.countSearchResult("Selenium"),10,"Result incorrect!");
        //System.out.println(searchPage1.countSearchResultFromPage1("Selenium"));

        SearchPage2 searchPage2 = searchPage1.clickPage1();
        //sleep(3000);
        Assert.assertTrue(searchPage2.isPageLoaded(),"Search page is not loaded!");
        searchPage2.countSearchResultFromPage2("Selenium");
        //Assert.assertEquals(searchPage2.countSearchResult("Selenium"),10,"Result incorrect!");
        //System.out.println(searchPage2.countSearchResultFromPage2("Selenium"));

        Assert.assertEquals(searchPage2.countSearchResultFromPage2("Selenium"),10,"Result incorrect!");
        Assert.assertEquals(searchPage1.countSearchResultFromPage1("Selenium"),10,"Result incorrect!");

    }

}