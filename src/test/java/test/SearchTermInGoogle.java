package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchPage1;
import page.SearchPage2;
import page.SearchPageBase;

import static java.lang.Thread.sleep;


public class SearchTermInGoogle extends BaseTest {

    /**
     * This method do across between page and find searchTerm "Selenium". Also, it compare expected and actual result.
     * @throws - InterruptedException пришлось добавить на самом стерте.
     */
    @Test
    public void basicSearchPage () throws InterruptedException {
        SearchPageBase searchPageBase = new SearchPageBase(webDriver);
        Assert.assertTrue(searchPageBase.isPageLoaded(),"Search page.BasePage is not loaded!");

        SearchPage1 searchPage1 = searchPageBase.setSearchTerm("Selenium");
        sleep(3000);
        Assert.assertTrue(searchPage1.isPageLoaded(),"Search Page1 is not loaded!");
        searchPage1.countSearchResultFromPage1("Selenium");
        Assert.assertEquals(searchPage1.countSearchResultFromPage1("Selenium"),10,"Search result incorrect!");

        SearchPage2 searchPage2 = searchPage1.clickPage1();
        Assert.assertTrue(searchPage2.isPageLoaded(),"Search page is not loaded!");
        searchPage2.countSearchResultFromPage2("Selenium");
        Assert.assertEquals(searchPage2.countSearchResultFromPage2("Selenium"),10,"Search result incorrect!");

    }

}