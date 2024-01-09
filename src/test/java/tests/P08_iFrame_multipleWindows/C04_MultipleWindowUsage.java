package tests.P08_iFrame_multipleWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_MultipleWindowUsage extends TestBase {

    @Test
    public void test01(){

        // In all the operations we perform with the driver,
        // we work in the same window by default.
        // Therefore, the driver searches for every action we perform
        // in the same window. If you want, you can create a new tab or window.

        driver.get("https://www.testotomasyonu.com");
        System.out.println(driver.getWindowHandle());

        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());

        driver.navigate().back();
        System.out.println(driver.getWindowHandle());

        // We are back on the test automation page.
        // Let's click on the "Electronics" link.

        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        System.out.println(driver.getWindowHandle());

    }
}

