package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> convertToStringList(List<WebElement> elementList) {

        List<String> stringList = new ArrayList<>();

        for (WebElement each : elementList) {
            stringList.add(each.getText());
        }

        return stringList;
    }

    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver switchPageWithTitle(WebDriver driver, String targetPageTitle) {

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            String eachTitle = driver.switchTo().window(each).getTitle();
            if (eachTitle.equals(targetPageTitle)) {
                return driver;
            }
        }

        return driver;
    }

    public static String getSecondPageHandleWithFirstPageHandle(WebDriver driver, String firstPageHandle) {

        Set<String> allWindowHandles = driver.getWindowHandles();

        allWindowHandles.remove(firstPageHandle);

        for (String each : allWindowHandles) {
            return each;
        }

        return null; // We know that this line will never be executed
        // It is written only to eliminate Java's concerns
    }

    public static void captureEntirePageScreenshot(WebDriver driver) {

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter desiredFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dynamicFilePath = "target/screenshots/entirePageScreenshot" +
                localDateTime.format(desiredFormat) +
                ".jpg";

        File entirePageScreenshot = new File(dynamicFilePath);

        File temporaryFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile, entirePageScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.wait(5);
    }

    public static void captureEntirePageScreenshot(String testName, WebDriver driver) {

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter desiredFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dynamicFilePath = "target/screenshots/" +
                testName +
                localDateTime.format(desiredFormat) +
                ".jpg";

        File entirePageScreenshot = new File(dynamicFilePath);

        File temporaryFile = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile, entirePageScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.wait(5);
    }

    public static void captureWebElementScreenshot(WebElement targetWebElement) {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter desiredFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dynamicFilePath = "target/screenshots/targetWebElementScreenshot" +
                localDateTime.format(desiredFormat) +
                ".jpg";

        File targetWebElementScreenshot = new File(dynamicFilePath);

        File temporaryFile = ((TakesScreenshot) targetWebElement).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(temporaryFile, targetWebElementScreenshot);
        } catch (IOException e) {
            System.out.println("Screenshot could not be copied");
            throw new RuntimeException(e);
        }
    }
}
