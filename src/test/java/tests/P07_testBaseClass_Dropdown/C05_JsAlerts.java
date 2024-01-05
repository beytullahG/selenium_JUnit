package tests.P07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_JsAlerts extends TestBase {

    // Create 3 test methods and complete the following tasks

    @Test
    public void jsBasicAlert(){
        // Test 1
        //   - Go to https://testotomasyonu.com/javascriptAlert
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //   - Click on the first alert
        driver.findElement(By.xpath("//*[@onclick = 'jsAlert()']")).click();
        //   - Test that the text in the alert is "I am a JS Alert"
        String expectedAlertText = "I am a JS Alert";
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText, actualAlertText);
        //   - Click on the OK button to close the alert
        ReusableMethods.wait(3);
        driver.switchTo().alert().accept();
    }


}
