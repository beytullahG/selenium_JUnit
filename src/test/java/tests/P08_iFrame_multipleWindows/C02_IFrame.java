package tests.P08_iFrame_multipleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_IFrame extends TestBase {

    @Test
    public void test01() {
        // 1) Go to https://the-internet.herokuapp.com/iframe.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2) Create a method: iframeTest
        //   - Test if the text "An IFrame containing…" is accessible and print it in the console.
        WebElement anIframeTextElement = driver.findElement(By.tagName("h3"));


    }
}

