package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    //) Go to https://www.bestbuy.com/
    // Create different test methods to perform the following tests
    //		○ urlTest => Test if the page URL is equal to https://www.bestbuy.com/
    //		○ titleTest => Test if the page title does not contain "Rest"
    //		○ logoTest => Test if the BestBuy logo is displayed
    //		○ francaisLinkTest => Test if the French link is displayed

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void urlTest(){
        //		○ Test if the page URL is equal to https://www.bestbuy.com/

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void titleTest(){
        //		○ Test if the page title does not contain "Rest"

        String unexpectedContent = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedContent));
    }


}
