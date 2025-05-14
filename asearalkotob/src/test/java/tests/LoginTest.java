package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import java.time.Duration;
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aseeralkotb.com/ar/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.enterEmail("by1127@fayoum.edu.eg");
        loginPage.enterPassword("Password#123");
        loginPage.clickLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.aseeralkotb.com/ar");
    }

    @Test
    public void testRegisterButtonClick() {
        loginPage.clickRegisterButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.aseeralkotb.com/ar/register");
    }
    @Test
    public void testForgotPassword() {
        loginPage.clickForgotPasswordLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.aseeralkotb.com/ar/forgot-password");
    }

}
