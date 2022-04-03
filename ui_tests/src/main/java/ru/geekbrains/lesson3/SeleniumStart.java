package ru.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.List;

public class SeleniumStart {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("user-agent=Googlebot/2.1; (+http://www.google.com/bot.html)");
//        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        Thread.sleep(2000);
//        ((JavascriptExecutor)driver).executeScript("window,open");
//        driver.getWindowHandle();
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);
        driver.close();
        driver.quit();

//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setLegacy(true);
//        firefoxOptions.setAcceptInsecureCerts(true);
//        firefoxOptions.addArguments("-headless");
//        firefoxOptions.setHeadless(true);
//        firefoxOptions.setCapability("marionette", false);
//        firefoxOptions.addArguments("-start-maximized");
//        WebDriver drive = new FirefoxDriver(firefoxOptions);
//        drive.get("https://restful-booker.herokuapp.com");
//        Thread.sleep(15000);
//        drive.quit();


    }
}
