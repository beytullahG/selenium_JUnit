package tests.P05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_TestAnnotations {

    // More than one independent test can run within a class.
    // When working with JUnit, if there are multiple tests in a class,
    // WE CANNOT DETERMINE or CONTROL the order in which they will run collectively.

    @Test
    public void runTestAutomation() { // Test methods should not be static
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to testautomationu.com
        driver.get("https://www.testautomationu.com");
        // Verify that the title contains "Test Automation"
        String expectedTitleContent = "Test Automation";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleContent)) {
            System.out.println("Test Automation test PASSED");
        } else {
            System.out.println("Test Automation test FAILED");
        }
        ReusableMethods.wait(1);
        driver.quit();
    }

    @Test
    public void runWiseQuarterTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to wisequarter.com
        driver.get("https://www.wisequarter.com");
        // Verify that the title contains "Wise"
        String expectedTitleContent = "Wise";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleContent)) {
            System.out.println("WiseQuarter test PASSED");
        } else {
            System.out.println("WiseQuarter test FAILED");
        }
        ReusableMethods.wait(1);
        driver.quit();
    }

    @Test
    public void runGoogleTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to google.com
        driver.get("https://www.google.com");
        // Verify that the URL contains "google"
        String expectedUrlContent = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlContent)) {
            System.out.println("Google test PASSED");
        } else {
            System.out.println("Google test FAILED");
        }
        ReusableMethods.wait(1);
        driver.quit();
    }
}
