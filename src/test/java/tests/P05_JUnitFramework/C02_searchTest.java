package tests.P05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_searchTest {
    public static void main(String[] args) throws InterruptedException {
        /*
            1- go to the homepage of testautomation.com.
            2- Locate the search box.
            3- Perform a search with the keyword "phone."
            4- Print the number of search results found.
            5- Click on the first product.
            6- Test if the product is in stock.
        */


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- go to the homepage of testautomation.com.
        driver.get("https://www.testotomasyonu.com");

        //2- Locate the search box.
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='global-search']"));

        // 3- Perform a search with the keyword "phone."
        searchBox.sendKeys("phone" + Keys.ENTER);

        // 4- Print the number of search results found.
        WebElement resultTextElement=driver.findElement(By.className("product-count-text"));
        System.out.println(resultTextElement.getText());

        // 5- Click on the first product.
        driver.findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]")).click();

        // 6- Test if the product is in stock.
        WebElement productStockElement=driver.findElement(By.xpath("//span[@class='heading-xs ']"));
        System.out.println(productStockElement.getText());


        Thread.sleep(3000);
        driver.quit();
    }
}
