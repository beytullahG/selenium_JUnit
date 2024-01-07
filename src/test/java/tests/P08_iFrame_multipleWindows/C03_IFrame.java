package tests.P08_iFrame_multipleWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_IFrame extends TestBase {

    @Test
    public void test01(){
        // Go to http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");
        // Accept Cookies
        // Since the cookies are in an iframe,
        // switch to that iframe first
        WebElement cookiesIFrame = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(cookiesIFrame);
        driver.findElement(By.xpath("//*[text()='Accept All']")).click();

        // Find the number of iframes on the page
        List<WebElement> iFrameList = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iframes on the page: " + iFrameList.size());

        // Click on the play button in the first iframe (YouTube)
        WebElement playIFrame = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(playIFrame);

        driver.findElement(By.xpath("//button[@title='Play']")).click();
        ReusableMethods.wait(2);

        // Return to the main page from the first iframe
        driver.switchTo().defaultContent();

        ReusableMethods.wait(3);
    }
}
