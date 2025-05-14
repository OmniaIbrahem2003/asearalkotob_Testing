package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CategoriesPage;

import java.time.Duration;

public class CategoriesTest {

    WebDriver driver;
    CategoriesPage categoriesPage;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aseeralkotb.com/ar/books/readable");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        categoriesPage = new CategoriesPage(driver, wait);
    }

    @Test(priority = 1)
    public void filterByLanguage() {
        categoriesPage.filterByLanguage();
        System.out.println(" تم تصفية الكتب حسب اللغة بنجاح.");
    }

    @Test(priority = 2)
    public void openSortMenuOnly() {
        categoriesPage.openSortMenu();
        System.out.println(" تم فتح قائمة ترتيب حسب بنجاح .");
    }

    @Test(priority = 3)
    public void filterBySection() {
        try {
            categoriesPage.filterBySection();
            System.out.println(" تم تصفية الكتب حسب القسم 'كتب متنوعة'.");
        } catch (NoSuchElementException e) {
            Assert.fail(" لم يتم العثور على قسم 'كتب متنوعة'.");
        }
    }

    @Test(priority = 4)
    public void filterByPublisher() {
        try {
            categoriesPage.filterByPublisher();
            System.out.println(" تم اختيار الناشر بنجاح.");
        } catch (NoSuchElementException e) {
            Assert.fail(" لم يتم العثور على 'كلمات للنشر والتوزيع'.");
        }
    }

    @Test(priority = 5)
    public void verifyBooksDisplayed() {
        boolean booksDisplayed = categoriesPage.verifyBooksDisplayed();
        Assert.assertTrue(booksDisplayed, " لم يتم عرض أي كتب.");
        System.out.println(" تم عرض الكتب بنجاح.");
    }


//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @AfterMethod
    public void waitBetweenTests() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
    }
}
