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

        Assert.assertTrue(anIframeTextElement.isEnabled());
        System.out.println(anIframeTextElement.getText());
        //   - Type "Merhaba Dunya!" into the text box.

        /*
            The text box is inside an iframe.
            To access elements inside an iframe:
            - First, locate the iframe as a WebElement.
            - Switch to the iframe using switchTo().

            After switching to the iframe:
            The driver will stay inside the iframe.
            If you want to perform an action on the main page again,
            you should switch back to the main page.

            driver.switchTo().parentFrame(); - Switch to the parent iframe if there are nested iframes.
            driver.switchTo().defaultContent(); - Directly switch to the main page.

         */

        WebElement iFrameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameElement);

        WebElement textBoxElement = driver.findElement(By.tagName("p"));
        textBoxElement.clear();
        textBoxElement.sendKeys("Merhaba Dunya");
        //   - Verify if the text "Elemental Selenium" below the TextBox is visible, and print it in the console.

        // driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        WebElement elementalSeleniumElement = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSeleniumElement.isDisplayed());

        System.out.println(elementalSeleniumElement.getText());

        ReusableMethods.wait(3);
    }
}

