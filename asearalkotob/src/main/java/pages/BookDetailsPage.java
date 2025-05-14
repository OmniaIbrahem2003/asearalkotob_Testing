package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BookDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public BookDetailsPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "a.flex.relative.flex-shrink-0")
    WebElement bookLink;

    @FindBy(css = "picture img")
    WebElement bookImage;

    @FindBy(css = "meta[itemprop='image']")
    WebElement imageMetaTag;

    @FindBy(css = "meta[itemprop='url']")
    WebElement urlMetaTag;


    public void clickBookLink() {
        wait.until(ExpectedConditions.elementToBeClickable(bookLink)).click();
    }


    public String getImageAltText() {
        return bookImage.getAttribute("alt");
    }

    public String getImageUrlFromMeta() {
        return imageMetaTag.getAttribute("content");
    }


    public String getBookUrlFromMeta() {
        return urlMetaTag.getAttribute("content");
    }

    public boolean isImageDisplayed() {
        return bookImage.isDisplayed();
    }
}
