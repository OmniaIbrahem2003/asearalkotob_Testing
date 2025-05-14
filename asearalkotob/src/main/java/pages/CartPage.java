package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddToCart() {
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[wire\\:click='addToCart']"));
        addToCartButton.click();
    }

    public boolean isAddToCartSuccessful() {
        WebElement button = driver.findElement(By.cssSelector("button[wire\\:click='addToCart']"));
        String titleAttr = button.getAttribute("title");
        boolean isDisabled = button.getAttribute("disabled") != null;

        return isDisabled && titleAttr.contains("تمت الإضافة");



    }
}