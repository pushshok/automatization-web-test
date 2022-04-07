package ru.geekbrains;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AutomationpracticeTest {

    public static void main(String[] args) throws InterruptedException {
        //        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("user-agent=Googlebot/2.1; (+http://www.google.com/bot.html)");
//        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://automationpractice.com/index.php");

        driver.manage().deleteAllCookies();
        Cookie authCookie = new Cookie("PrestaShop-a30a9934ef476d11b6cc3c983616e364", "WocTdgeiJPnQnxuDUrea" +
                "FH4AcWZgk0yUCgG8WsDzV6DlkeQ01T6iYEEAZBjdC%2FY1zsSx95ed7rMnUO1gnbLH%2FeH7eXjJ%2F3DrW8Y0yKRnbSlWCj07%2F" +
                "trMvGubUUn%2B4Tka3H0S%2BJxqN4oFbc1sRNv2bGOK8RzOTnsxmLjwGp4JSqzSwoECqyaqmPCy4zNzSGq1Xo8HCJjwvzpxQdUQLJ" +
                "OcsnTMTQQh5WdzACMNNr%2B6JyC7Nnf9sR0Cpbk6G5sBtJHuFz6vpa80DakFCVzH4VEEf%2FmpkSO2Mli3xPAnIAf8xAJOWmxTXUG" +
                "hFF%2ByeyM%2FXNDg6EC%2BJpbTZDVWtA4qCIQICh7ffgztRC5pyMaZpCts8k49490gPYdUFQ46tfSWa%2FrHW4%2Fbf4A05lzE2V" +
                "8Mmzd8BiLZPGAn2%2BYfTgXFCCyIJbS2nrW5oCjOD14zHFzQN5xM000334");


        driver.manage().addCookie(authCookie);

        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/a[contains(@title, 'Dresses')]")).click();
        driver.findElement(By.xpath("//div[@id='categories_block_left']//a[contains(text(), 'Casual')]")).click();
        driver.findElement(By.xpath("//*[@id='center_column']//a[@title='Printed Dress']/img")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span")).click();
        driver.findElement(By.xpath("//*[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();
        driver.findElement(By.xpath("//*[@id='center_column']//a[@title='Proceed to checkout']/span")).click();
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Testing Test");
        driver.findElement(By.xpath("//form/p/button[@type='submit']")).click();
        driver.findElement(By.xpath("//*[@id='form']//label[@for='cgv']")).click();
        driver.findElement(By.xpath("//form/p/button[@type='submit']")).click();
        driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']//a[@title='Pay by bank wire']")).click();
        driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span[contains(text(), 'confirm')]")).click();

        Thread.sleep(3000);
        driver.quit();
    }

}

