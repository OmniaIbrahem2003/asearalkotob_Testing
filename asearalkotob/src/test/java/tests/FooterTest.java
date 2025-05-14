package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FooterPage;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class FooterTest {
    WebDriver driver;
    FooterPage footerPage;
    String baseUrl = "https://www.aseeralkotb.com/ar/books/%D9%82%D9%87%D9%88%D8%A9-%D9%83%D8%AD%D8%A8%D9%83";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        footerPage = new FooterPage(driver);
    }

    private void scrollToFooter() {
        // Using JavaScriptExecutor to scroll to the footer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footer = driver.findElement(By.tagName("footer"));
        js.executeScript("arguments[0].scrollIntoView();", footer);
    }

    private void testLinks(List<WebElement> links, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 0; i < links.size(); i++) {
            List<WebElement> currentLinks = driver.findElements(locator);
            WebElement link = currentLinks.get(i);
            String href = link.getAttribute("href");
            if (href == null || href.isEmpty()) continue;

            try {
                driver.navigate().to(href);
                wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));

                String currentUrl = driver.getCurrentUrl();
                System.out.println("✅ Opened: " + currentUrl);
                assertTrue(currentUrl.contains("aseeralkotb.com") || currentUrl.startsWith(href));
            } catch (Exception e) {
                System.err.println("❌ Failed to open link: " + href);
                e.printStackTrace();
            } finally {
                driver.navigate().to(baseUrl);
                wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
            }
        }
    }

    @Test
    public void testQuickLinks() {
        scrollToFooter(); // Scroll to footer before checking links
        testLinks(footerPage.getQuickLinks(), By.xpath("//h3[contains(text(),'روابط سريعة')]/following-sibling::ul/li/a"));
    }

    @Test
    public void testSupportLinks() {
        scrollToFooter(); // Scroll to footer before checking links
        testLinks(footerPage.getSupportLinks(), By.xpath("//h3[contains(text(),'روابط الدعم')]/following-sibling::ul/li/a"));
    }



//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}