package tests.P05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;



public class C06_DriverCreationWithMethod {

    WebDriver driver;

    public void createDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void wisequarterTest(){
        createDriver();
        driver.get("https://www.wisequarter.com");
        // Check if the title contains "Wise"
        String expectedTitleContent = "Wise";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Wisequarter test PASSED");
        } else {
            System.out.println("Wisequarter test FAILED");
        }
        ReusableMethods.wait(1);
        driver.quit();
    }

    @Test
    public void testAutomationTest(){
        createDriver();
        // Go to testautomationu.com
        driver.get("https://www.testautomationu.com");
        // Check if the title contains "Test Automation"
        String expectedTitleContent = "Test Automation";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Test Automation test PASSED");
        } else {
            System.out.println("Test Automation test FAILED");
        }
        ReusableMethods.wait(1);
        driver.quit();
    }

    @Test
    public void googleTest(){
        createDriver();
        // Go to google.com
        driver.get("https://www.google.com");
        // Check if the URL contains "google"
        String expectedUrlContent = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlContent)){
            System.out.println("Google test PASSED");
        } else {
            System.out.println("Google test FAILED");
        }
        ReusableMethods.wait(1);
        driver.quit();
    }
}
