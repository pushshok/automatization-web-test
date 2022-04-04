package ru.geekbrains.lesson5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;


public class AfishaTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private final static String AFISHA_URL = "https://www.afisha.ru/";

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
        WebDriver driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    void LikeFilmsWhenOpenInAfishaTest() {
        driver.get(AFISHA_URL);

    }

    @AfterEach
    void quitDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
