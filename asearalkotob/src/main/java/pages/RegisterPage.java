package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By createAccountButton = By.xpath("//button[@type='submit' and contains(text(),'إنشاء الحساب')]");
    private final By alreadyHaveAccountLink = By.xpath("//a[contains(text(),'لديك حساب ')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Proper initialization
    }

    public void enterName(String name) {
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys(name);
    }

    public void enterUsername(String username) {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(username);
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordField = driver.findElement(By.id("password_confirmation"));
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickAlreadyHaveAccount() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(alreadyHaveAccountLink));
        link.click();
    }

    public void clickCreateAccount() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        button.click();
    }
}
