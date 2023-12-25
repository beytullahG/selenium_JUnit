package tests.P07_testBaseClass_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_RadioButton {

    // Set up the necessary structure and complete the task below.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void radioButtonBoxTest() {
        //	a. Go to the given web page: https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Locate the Gender Radio button elements and
        //     select the one that suits you by checking the radio button
        WebElement femaleRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement maleRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement otherRadioButton = driver.findElement(By.id("inlineRadio3"));

        ReusableMethods.wait(2);
        maleRadioButton.click();
        //	c. Test if the selected radio button is selected, and the others are not selected
        Assert.assertTrue(maleRadioButton.isSelected());
        Assert.assertFalse(femaleRadioButton.isSelected());
        Assert.assertFalse(otherRadioButton.isSelected());
        ReusableMethods.wait(2);
    }
}