package tests.P07_testBaseClass_Dropdown;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C03_DropdownMenu extends TestBase {

    @Test
    public void dropdownTest(){
        //● Go to the https://testotomasyonu.com/form address.
        driver.get("https://testotomasyonu.com/form");

        //	1. Select '5' from the birthdate day options using index
        // - First step: Locate and save the dropdown element we will use
        WebElement birthDayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        // - Second step: Create a Select object
        //                 Pass the located dropdown as a parameter to the Select object
        Select selectGun = new Select(birthDayDdm);
        // - Third step: Perform the desired operations with the created Select object
        selectGun.selectByIndex(5);

    }
}