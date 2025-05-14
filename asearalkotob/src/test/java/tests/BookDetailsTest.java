package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BookDetailsPage;

import java.time.Duration;

public class BookDetailsTest {

    WebDriver driver;
    BookDetailsPage bookPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.aseeralkotb.com/ar/categories/%D8%B1%D9%88%D8%A7%D9%8A%D8%A7%D8%AA");
        bookPage = new BookDetailsPage(driver);
    }

    @Test(priority = 1)
    public void testBookLink() {
        String initialUrl = driver.getCurrentUrl();
        bookPage.clickBookLink();
        String finalUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(initialUrl, finalUrl, "The book link did not navigate to a new page.");
    }

    @Test(priority = 2)
    public void testImageAltText() {
        String altText = bookPage.getImageAltText();
        Assert.assertEquals(altText, "قهوة كحبك", "The alt text of the image is incorrect.");
    }

    @Test(priority = 3)
    public void testImageUrlFromMeta() {
        String imageUrl = bookPage.getImageUrlFromMeta();
        Assert.assertTrue(imageUrl.contains("قهوة-كحبك"), "The image URL does not contain the expected string.");
    }

    @Test(priority = 4)
    public void testImageDisplayed() {
        Assert.assertTrue(bookPage.isImageDisplayed(), "The image is not displayed.");
    }

    @Test(priority = 5)
    public void testBookUrlFromMeta() {
        String bookUrl = bookPage.getBookUrlFromMeta();
        Assert.assertEquals(bookUrl, "https://www.aseeralkotb.com/ar/books/قهوة-كحبك", "The book URL is incorrect.");
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
