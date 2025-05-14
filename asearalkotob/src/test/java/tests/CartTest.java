package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CartPage;

public class CartTest {

    WebDriver driver;
    CartPage cartPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aseeralkotb.com/books/");
        cartPage = new CartPage(driver);
    }

    @Test
    public void testAddToCartButton() throws InterruptedException {
        cartPage.clickAddToCart();
        Thread.sleep(2000);
        Assert.assertTrue(cartPage.isAddToCartSuccessful(), "فشل في الإضافة إلى السلة!");
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}