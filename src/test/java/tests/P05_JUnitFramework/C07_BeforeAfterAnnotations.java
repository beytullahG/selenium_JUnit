package tests.P05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C07_BeforeAfterAnnotations {

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
    public void wisequarterTest(){
        driver.get("https://www.wisequarter.com");
        // title contains "Wise" test
        String expectedTitleContent = "Wise";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Wisequarter test PASSED");
        }else System.out.println("Wisequarter test FAILED");
        ReusableMethods.wait(1);
    }

    @Test
    public void testAutomationTest(){
        /*
            According to JUnit, a test method is considered PASSED
            if it runs without encountering any issues

            For a test to be FAILED in JUnit,
            there must be a problem with the code,
            and the code must not run until the end of the method

            As an example, we used throw new AssertionFailedError() in this method
            to stop the execution when the test fails,
            and JUnit labels this test as FAILED due to the exception
         */

        // Go to testautomationu.com
        driver.get("https://www.testautomationu.com");
        // Check if the title contains "Test Automation"
        String expectedTitleContent = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Test Automation test PASSED");
        }else {
            System.out.println("Test Automation test FAILED");
            throw new AssertionFailedError();
        }
        ReusableMethods.wait(1);

    }

    @Test @Ignore
    public void googleTest(){

        // Go to google.com
        driver.get("https://www.google.com");
        // Check if the URL contains "google"
        String expectedUrlContent = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlContent)){
            System.out.println("Google test PASSED");
        }else System.out.println("Google test FAILED");
        ReusableMethods.wait(1);

    }
}
