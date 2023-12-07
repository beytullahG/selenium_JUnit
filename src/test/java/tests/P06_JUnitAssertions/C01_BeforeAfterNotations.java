package tests.P06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_BeforeAfterNotations {

    // Create 3 different test methods to perform the following tests
    // 1- Go to the testautomation.com website
    // 2- Search for phone, shoes, and dress
    // 3- Test if the product can be found in the search results
    // 4- Close the page

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void performPhoneTest(){
        // 1- Go to the testautomation.com website
        driver.get("https://www.testautomation.com");
        // 2- Search for phone
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);
        // 3- Test if the product can be found in the search results
        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));
        String searchResultCountStr = searchResultElement.getText().replaceAll("\\D", "");
        int searchResultCount = Integer.parseInt(searchResultCountStr);

        if (searchResultCount > 90){
            System.out.println("Phone test PASSED");
        } else {
            System.out.println("Phone test FAILED");
            throw new AssertionFailedError();
        }
        ReusableMethods.wait(2);
    }

    @Test
    public void performDressTest(){
        // 1- Go to the testautomation.com website
        driver.get("https://www.testautomation.com");
        // 2- Search for dress
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("dress" + Keys.ENTER);
        // 3- Test if the product can be found in the search results
        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));
        String searchResultCountStr = searchResultElement.getText().replaceAll("\\D", "");
        int searchResultCount = Integer.parseInt(searchResultCountStr);

        if (searchResultCount > 0){
            System.out.println("Dress test PASSED");
        } else {
            System.out.println("Dress test FAILED");
            throw new AssertionFailedError();
        }
        ReusableMethods.wait(2);
    }
}