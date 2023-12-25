package tests.P06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C06_CheckBox {

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
    public void checkboxTest(){
        //	a. Go to the given web page: https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Select the Back Pain and Chest Pain checkboxes
        WebElement backPainCheckBox = driver.findElement(By.id("gridCheck5"));
        backPainCheckBox.click();

        WebElement chestPainCheckBox = driver.findElement(By.id("gridCheck4"));
        WebElement chestPainTextElement = driver.findElement(By.xpath("//*[@for='gridCheck4']"));
        chestPainTextElement.click();




    }
}
