package tests.P08_iFrame_multipleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {

    @Test
    public void basicAuthenticationTest(){

        //1- Create a class: BasicAuthentication
        //2- Go to https://testotomasyonu.com/basicauth page
        // driver.get("https://testotomasyonu.com/basicauth");
        //3- Authenticate using the following method and test data
        //
        //HTML command: https://username:password@URL
        //  Username: membername
        //  Password: sunflower
        //

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        //4- Verify that the page is successfully accessed

        WebElement successfulLoginTextElement = driver.findElement(By.tagName("h3"));

        String expectedText = "Congratulations! You are logged in as: membername";
        String actualText = successfulLoginTextElement.getText();

        Assert.assertEquals(expectedText, actualText);
    }
}

