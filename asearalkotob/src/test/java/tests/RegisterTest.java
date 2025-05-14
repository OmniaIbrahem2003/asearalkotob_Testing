package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;

public class RegisterTest {
    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aseeralkotb.com/ar/register");
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void testSuccessfulRegistration() {
        registerPage.enterName("weddd123");
        registerPage.enterUsername("wed");
        registerPage.enterEmail("wi1137@fayoum.edu.eg");
        registerPage.enterPassword("Password#123");
        registerPage.enterConfirmPassword("Password#123");
        registerPage.clickCreateAccount();
    }

    @Test
    public void testHaveAccountLink() {
        registerPage.clickAlreadyHaveAccount();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.aseeralkotb.com/ar/login");
    }

//    @AfterTest
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
