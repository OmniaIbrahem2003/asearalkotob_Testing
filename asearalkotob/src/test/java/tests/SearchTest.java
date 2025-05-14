package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SearchPage;

import java.util.List;

public class SearchTest {
    WebDriver driver;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aseeralkotb.com/");
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testSearchBoxIsVisibleAndUsable() {
        Assert.assertTrue(searchPage.isSearchInputVisibleAndEnabled());
        searchPage.typeSearchQuery("العبرات");
        Assert.assertTrue(searchPage.isSearchButtonVisible());
    }
   // @AfterMethod
    //public void tearDown() {
      //  if (driver != null) {
        //    driver.quit();
        //}
    //}
}
