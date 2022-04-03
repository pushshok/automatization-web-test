package ru.geekbrains.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DemoqaTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("user-agent=Googlebot/2.1; (+http://www.google.com/bot.html)");
//        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/automation-practice-form");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("close-fixedban")));
        driver.findElement(By.id("close-fixedban")).click();
//        driver.findElement(By.xpath("//div[contains(@class, 'adplus-anchor')]")).clear();
//        driver.findElement(By.xpath("//div[contains(@class, 'leaderboard')]")).clear();
//        driver.findElement(By.xpath("//div[contains(@class, 'row-container')]")).clear();


//        ((JavascriptExecutor)driver).executeScript("window,open");
//        driver.getWindowHandle();
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        System.out.println(tabs.toString());

//        driver.switchTo().parentFrame();


//        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Testing");
        driver.findElement(By.id("lastName")).sendKeys("Test");
        driver.findElement(By.id("userEmail")).sendKeys("firsting@first.ru");



        ((JavascriptExecutor)driver).executeScript("var badTableEval = document.evaluate (" +
                "'//footer', " + "document.documentElement, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);" +
                "if (badTableEval  &&  badTableEval.singleNodeValue) {" +
                "var badTable  = badTableEval.singleNodeValue;" +
                "badTable.parentNode.removeChild (badTable);}");
        Thread.sleep(5000);
        driver.quit();

    }
}
