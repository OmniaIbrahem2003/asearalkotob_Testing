package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ForgetPasswordPage;
import java.time.Duration;

public class ForgetPasswordTest {

    private ForgetPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aseeralkotb.com/ar/forgot-password");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        forgotPasswordPage = new ForgetPasswordPage(driver, wait);
    }

    @Test
    public void testForgotPassword() {
        String email = "oi1152@fayoum.edu.eg";
        forgotPasswordPage.enterEmail(email);
        forgotPasswordPage.clickSubmitButton();
        forgotPasswordPage.isSuccessMessageDisplayed();
    }
}

