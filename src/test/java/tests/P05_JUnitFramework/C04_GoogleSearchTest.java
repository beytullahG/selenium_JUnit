package tests.P05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_GoogleSearchTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to the address https://www.google.com/
        driver.get("https://www.google.com/");
        // 3. Close the cookies warning by accepting it
        ReusableMethods.wait(10);
        driver.findElement(By.xpath("//*[text()='Accept all']")).click();
        // 4. Test if the page title contains the expression "Google"
        String expectedTitleContent = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleContent)){
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
        }

        // 5. Type "Nutella" in the search bar and search
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        // 6. Print the number of results found
        WebElement resultStatsElement = driver.findElement(By.id("result-stats"));
        String resultStatsText = resultStatsElement.getText();
        System.out.println("Result stats: " + resultStatsText);
        // 7. Test if the number of results is more than 10 million
        // Example: About 163,000,000 results (0.39 seconds)
        String[] resultStatsArray = resultStatsText.split(" ");

        String resultCountStr = resultStatsArray[1]; // "163,000,000"

        // resultCountStr = resultCountStr.replace(",", "");
        resultCountStr = resultCountStr.replaceAll("\\D", ""); // "163000000"

        int resultCountInt = Integer.parseInt(resultCountStr);

        if (resultCountInt > 10000000){
            System.out.println("Search result count test PASSED");
        } else {
            System.out.println("Search result count test FAILED");
        }

        // 8. Close the page
        ReusableMethods.wait(2);
        driver.quit();
    }
}
