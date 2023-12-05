package tests.P06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClass_AfterClass {

    // Create 3 different test methods to perform the following tasks
    // 1- Go to testautomation.com page,
    //    and test if the URL contains testautomation
    // 2- Perform a search for the phone,
    //    and test if the product can be found in the search results
    // 3- Click on the first product,
    //    and test if the word "phone" is mentioned in the product description without case sensitivity

    /*
        For these tasks to be performed correctly,
        - test methods must run in the correct order
        - the driver object must be created before all methods
          and closed after all methods are executed

          To achieve this, we use @BeforeClass and @AfterClass annotations
          HOWEVER, the methods using these annotations MUST BE STATIC

     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("before executed");
    }

    @AfterClass
    public static void teardown(){
        System.out.println("after executed");
        driver.quit();
    }


    @Test
    public void test01(){
        // URL test
        // 1- Go to testautomation.com page,
        //    and test if the URL contains testautomation
        driver.get("https://www.testautomation.com");

        String expectedUrlContent = "testautomation";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlContent)){
            System.out.println("URL test PASSED");
        }else{
            System.out.println("URL test FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test02(){
        // Search test
        // 2- Perform a search for the phone,
        //    and test if the product can be found in the search results
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));

        String searchResultCountStr = searchResultElement.getText().replaceAll("\\D","");
        int searchResultCount = Integer.parseInt(searchResultCountStr);

        if (searchResultCount > 0){
            System.out.println("Search test PASSED");
        }else{
            System.out.println("Search test FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test03(){
        // First product detail test
        // 3- Click on the first product,
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();
        //    and test if the word "phone" is mentioned in the product description without case sensitivity
        WebElement productDescriptionElement = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedProductContent = "phone";
        String productDescription = productDescriptionElement.getText().toLowerCase();

        if (productDescription.contains(expectedProductContent)){
            System.out.println("First product test PASSED");
        }else {
            System.out.println("First product test FAILED");
            throw new AssertionFailedError();
        }
    }
}
