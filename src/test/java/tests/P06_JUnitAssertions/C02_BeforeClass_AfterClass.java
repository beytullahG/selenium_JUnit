package tests.P06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class C02_BeforeClass_AfterClass {
    // 3 different test methods
    // Complete the given tasks below
    // 1- Go to testotomasyonu.com, test that the URL contains testotomasyonu
    // 2- Search for phone and test that a product is found in the search results
    // 3- Click on the first product, test that the product description contains "phone" case-insensitively

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        System.out.println("BeforeClass executed");
    }

    @AfterClass
    public static void teardown() {
        System.out.println("AfterClass executed");
        driver.quit();
    }

    @Test
    public void test01() {
        // URL test
        // 1- Go to testotomasyonu.com, test that the URL contains testotomasyonu
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlContent = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        assertTrue("URL test failed", actualUrl.contains(expectedUrlContent));
        System.out.println("URL test passed");
    }

    @Test
    public void test02() {
        // Search test
        // 2- Search for phone and test that a product is found in the search results
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));

        String searchResultCountStr = searchResultElement.getText().replaceAll("\\D", "");
        int searchResultCount = Integer.parseInt(searchResultCountStr);

        assertTrue("Search test failed", searchResultCount > 0);
        System.out.println("Search test passed");
    }

    @Test
    public void test03() {
        // Product detail test
        // 3- Click on the first product, test that the product description contains "phone" case-insensitively
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();

        WebElement productDescriptionElement = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedProductContent = "phone";
        String productDescription = productDescriptionElement.getText().toLowerCase();

        assertTrue("Product test failed", productDescription.contains(expectedProductContent));
        System.out.println("Product test passed");
    }
}
