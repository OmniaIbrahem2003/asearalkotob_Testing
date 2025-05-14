package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private WebDriver driver;


    private By searchInput = By.cssSelector("input[type='search']");
    private By searchButton = By.cssSelector("button[type='submit']");


    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getSearchInput() {
        return driver.findElement(searchInput);
    }

    public void typeSearchQuery(String query) {
        getSearchInput().sendKeys(query);
    }

    public WebElement getSearchButton() {
        return driver.findElement(searchButton);
    }

    public boolean isSearchInputVisibleAndEnabled() {
        WebElement input = getSearchInput();
        return input.isDisplayed() && input.isEnabled();
    }

    public boolean isSearchButtonVisible() {
        return getSearchButton().isDisplayed();
    }
}
