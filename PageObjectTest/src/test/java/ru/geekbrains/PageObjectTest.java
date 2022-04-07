package ru.geekbrains;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;


public class PageObjectTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

    }

    @BeforeEach
    void setupDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.get();
    }

    @Test
    void addAndBuyProductTest() {

    }

    @AfterEach
    void quitDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
