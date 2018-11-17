package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver webDriver;

    /**
     * Method for connect FirefoxDriver and navigate to links "https://www.google.com".
     */
    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.google.com");
    }

    /**
     * Method, which closed browser after work.
     */
    @AfterMethod
    public void afterMethod () {
        webDriver.quit();
    }

}
