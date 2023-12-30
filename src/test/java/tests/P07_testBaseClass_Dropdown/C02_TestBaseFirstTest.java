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

    }
}
