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

    }
}
