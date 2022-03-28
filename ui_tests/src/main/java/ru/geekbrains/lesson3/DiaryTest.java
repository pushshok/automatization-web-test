package ru.geekbrains.lesson3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("user-agent=Googlebot/2.1; (+http://www.google.com/bot.html)");
//        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://diary.ru");

//        Authorization Form
//        WebElement buttonLogin = driver.findElement(By.xpath("//a[.='Вход']"));
//        buttonLogin.click();
//        driver.findElement(By.xpath("//a[.='Вход']")).click();
//        driver.findElement(By.id("loginform-username")).sendKeys("zdibnyak");
//        driver.findElement(By.id("loginform-password")).sendKeys("Un1imite");
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
//        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
//        driver.switchTo().parentFrame();
//        driver.findElement(By.id("login_btn")).click();

        Cookie authCookie = new Cookie("_identity_", "5f20a01f85999b1e2dfaf240ca3aa1a52de944268d7c5b00130144a" +
                "099a48134a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity" +
                "_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3564942%2C%22rDG2DwqYT" +
                "-I5WV8aCKECu21rMFv1S8Tl%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // If page do not load? waiting for load 3 sec
        String postName = "Post " + new Random().nextInt(10000);
        driver.findElement(By.id("postTitle")).sendKeys(postName);

        //Waitiner, waiting for visibility element or another events for 5 sec
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message_ifr")));

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        String postText = "Our post text " + new Random().nextInt(10000);
        driver.findElement(By.id("tinymce")).sendKeys(postText);

        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();

//        driver.findElement(By.xpath(String.format("//a[.='%s']", postName))).click();
        List<WebElement> posts = driver.findElements(By.xpath("//a[@class='title']"));
        posts.stream().filter(p -> p.getText().contains(postName)).findFirst().get().click();
        Thread.sleep(5000);
        driver.quit();
    }
}
