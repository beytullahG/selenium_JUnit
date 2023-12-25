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

        //	c. Test if the Back Pain and Chest Pain checkboxes are selected
        Assert.assertTrue(backPainCheckBox.isSelected());
        Assert.assertTrue(chestPainCheckBox.isSelected());

        chestPainCheckBox.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.wait(3);
        //	d. Test if the Diabetes and Epilepsy checkboxes are not selected
        WebElement diabetesCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsyCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assert.assertFalse(diabetesCheckBox.isSelected());
        Assert.assertFalse(epilepsyCheckBox.isSelected());

    }
}
