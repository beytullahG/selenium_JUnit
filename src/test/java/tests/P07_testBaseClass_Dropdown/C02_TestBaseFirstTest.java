package tests.P07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_TestBaseFirstTest extends TestBase {

    @Test
    public void searchTest(){

        // Go to the homepage of testotomasyonu.com
        driver.get("https://www.testotomasyonu.com");

        // Search for "phone"
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // Test if a product can be found in the search results
        WebElement searchResultElement= driver.findElement(By.className("product-count-text"));

        String searchResultCountStr = searchResultElement.getText().replaceAll("\\D","");

        int searchResultCount = Integer.parseInt(searchResultCountStr);

        Assert.assertTrue(searchResultCount > 0);
        ReusableMethods.wait(2);

    }
}
