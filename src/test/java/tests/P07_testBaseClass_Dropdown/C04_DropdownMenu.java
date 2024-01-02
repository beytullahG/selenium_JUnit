package tests.P07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_DropdownMenu extends TestBase {

    @Test
    public void dropdowntest(){
        //1. Go to http://zero.webappsecurity.com/
        driver.get("http://zero.webappsecurity.com/");
        //2. Click on the Sign in button
        driver.findElement(By.id("signin_button")).click();
        //3. Type "username" into the login box
        WebElement loginBox = driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username");
        //4. Type "password" into the password box
        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");
        //5. Click the Sign in button, then go back to the page using the back button
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();
        //6. Go to the Pay Bills page from the Online Banking menu
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. Click the "Purchase Foreign Currency" button
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. Select Eurozone from the "Currency" dropdown menu
        WebElement currencyDropdown = driver.findElement(By.id("pc_currency"));
        Select selectCurrency = new Select(currencyDropdown);
        selectCurrency.selectByValue("EUR");

    }
}
