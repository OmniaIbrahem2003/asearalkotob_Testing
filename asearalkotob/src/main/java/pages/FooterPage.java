package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class FooterPage {
    WebDriver driver;

    // XPath لكل أنواع الروابط في الفوتر
    By quickLinks = By.xpath("//h3[contains(text(),'روابط سريعة')]/following-sibling::ul/li/a");
    By supportLinks = By.xpath("//h3[contains(text(),'روابط الدعم')]/following-sibling::ul/li/a");

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getQuickLinks() {
        return driver.findElements(quickLinks);
    }

    public List<WebElement> getSupportLinks() {
        return driver.findElements(supportLinks);
    }


}