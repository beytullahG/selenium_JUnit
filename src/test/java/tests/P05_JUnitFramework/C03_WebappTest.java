package tests.P05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebappTest {
    // 1. Navigate to the http://zero.webappsecurity.com page
    // 2. Click the Signin button
    // 3. Enter "username" into the login field
    // 4. Enter "password" into the password field
    // 5. Click the Sign-in button
    // 6. Go back to the previous page
    // 7. Navigate to the Pay Bills page from the Online Banking menu
    // 8. Enter any amount you want to deposit in the amount field
    // 9. Type "2023-09-10" into the date field
    // 10. Click the Pay button
    // 11. Test if the message "The payment was successfully submitted." is displayed


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Navigate to the http://zero.webappsecurity.com page
        driver.get("http://zero.webappsecurity.com");

        // 2. Click the Signin button
        driver.findElement(By.id("signin_button")).click();

        // 3. Enter "username" into the login field
        WebElement loginBox = driver.findElement(By.id("user_login"));
        loginBox.sendKeys("username");

        // 4. Enter "password" into the password field
        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");

        // 5. Click the Sign-in button
        driver.findElement(By.xpath("//*[@*='Sign in']")).click();

        // 6. Go back to the previous page
        driver.navigate().back();

        // 7. Navigate to the Pay Bills page from the Online Banking menu
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        // 8. Enter any amount you want to deposit in the amount field
        WebElement amountBox = driver.findElement(By.id("sp_amount"));
        amountBox.sendKeys("200");

        // 9. Type "2023-09-10" into the date field
        driver.findElement(By.id("sp_date")).sendKeys("2023-09-10");

        // 10. Click the Pay button
        driver.findElement(By.id("pay_saved_payees")).click();

        // 11. Test if the message "The payment was successfully submitted." is displayed
        WebElement messageElement = driver.findElement(By.id("alert_content"));

        String expectedResult = "The payment was successfully submitted.";
        String actualResultMessage = messageElement.getText();

        if (expectedResult.equals(actualResultMessage)) {
            System.out.println("Payment test PASSED");
        } else {
            System.out.println("Payment test FAILED");
        }

        driver.quit();
    }
}
