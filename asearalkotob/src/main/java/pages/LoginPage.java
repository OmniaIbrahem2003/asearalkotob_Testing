package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    private final By clickLoginButton = By.xpath("//button[@type='submit' and contains(text(),'دخول')]");
    private final By forgotPasswordLink = By.xpath("//a[contains(text(),'هل فقدت كلمة المرور؟')]");
    private final By registerButton = By.cssSelector("a[title='تسجيل عضوية جديدة']");



    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickLoginButton));
        button.click();
    }
    public void clickForgotPasswordLink() {
        WebElement forgotPasswordLinkElement = wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLinkElement.click();
    }
    public WebElement getRegisterButton() {
        return driver.findElement(registerButton);
    }
    public void clickRegisterButton() {
        getRegisterButton().click();
    }


}
