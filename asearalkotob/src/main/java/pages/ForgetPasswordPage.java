package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgetPasswordPage {
    WebDriver driver;
    WebDriverWait wait;

    private final By emailField = By.id("email");
    private final By submitButton = By.xpath("//button[contains(text(),'ارسل رابط تعيين كلمة المرور')]");
    private final By successMessage = By.xpath("//div[contains(text(),'تم إرسال رابط ')]");

    public ForgetPasswordPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    public void clickSubmitButton() {
        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButtonElement.click();
    }

    public  boolean isSuccessMessageDisplayed() {
        try {
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return successMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

