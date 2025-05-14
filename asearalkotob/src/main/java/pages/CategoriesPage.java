package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class CategoriesPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//label[contains(text(),'الكتب عربية')]/preceding-sibling::input")
    WebElement arabicCheckbox;

    @FindBy(xpath = "//button[contains(., 'ترتيب حسب')]")
    WebElement sortDropdown;

    @FindBy(xpath = "//*[contains(text(),'كتب متنوعة')]")
    WebElement sectionOption;

    @FindBy(xpath = "//label[contains(.,'كلمات للنشر والتوزيع')]//input[@type='checkbox']")
    WebElement publisherCheckbox;

    @FindBy(css = "div.grid > div")
    List<WebElement> books;


    public CategoriesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void filterByLanguage() {
        if (!arabicCheckbox.isSelected()) {
            arabicCheckbox.click();
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.grid")));
    }

    public void openSortMenu() {
        sortDropdown.click();
    }


    public void filterBySection() {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionOption);
            sectionOption.click();
        } catch (TimeoutException e) {
            throw new NoSuchElementException("لم يتم العثور على قسم 'كتب متنوعة'", e);
        }
    }

    // Method to filter by publisher
    public void filterByPublisher() {
        try {
            if (!publisherCheckbox.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", publisherCheckbox);
            }
        } catch (TimeoutException e) {
            throw new NoSuchElementException("لم يتم العثور على 'كلمات للنشر والتوزيع'", e);
        }
    }

    // Method to verify if books are displayed after filtering
    public boolean verifyBooksDisplayed() {
        return books.size() > 0;
    }
}
