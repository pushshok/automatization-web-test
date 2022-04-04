package ru.geekbrains.dz;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DemoqaTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private final static String DEMOQA_URL = "https://demoqa.com/automation-practice-form";

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
    }

    @Test // GivEn - что нам дано / When - когда что происходит / Then - тогда что делаем
    @DisplayName("Check form sending from site Demoqa")
    void SendFormAfterCompleteDemoqaTest() throws InterruptedException {
        driver.get(DEMOQA_URL);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("close-fixedban")));
        driver.findElement(By.id("close-fixedban")).click();
        driver.findElement(By.id("firstName")).sendKeys("Testing");
        driver.findElement(By.id("lastName")).sendKeys("Test");
        driver.findElement(By.id("userEmail")).sendKeys("firsting@first.ru");

        ((JavascriptExecutor)driver).executeScript("var badTableEval = document.evaluate (" +
                "'//footer', " + "document.documentElement, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);" +
                "if (badTableEval  &&  badTableEval.singleNodeValue) {" +
                "var badTable  = badTableEval.singleNodeValue;" +
                "badTable.parentNode.removeChild (badTable);}");

        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        driver.findElement(By.id("dateOfBirthInput")).click();
        Select yearSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
        yearSelect.selectByVisibleText("1984");
        Select monthSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
        monthSelect.selectByVisibleText("August");
        driver.findElement(By.xpath("//div[@class='react-datepicker__month']//*[contains (text(), '13')]")).click();
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).sendKeys("Na drevnyiy dedushke");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[@id='state']//*[contains (text(), 'Haryana')]")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[@id='city']//*[contains (text(), 'Karnal')]")).click();
        driver.findElement(By.id("submit")).click();
        WebElement titleFrame = driver.findElement(By.xpath("//div[@class='modal-title h4']"));
        String title = titleFrame.getText();
        System.out.println(title);
        Assertions.assertEquals(title, "Thanks for submitting the form");
//        posts.stream().filter(p -> p.getText().contains(postName)).findFirst().get().click();


    }

    @AfterEach
    void quitDriver() throws InterruptedException {
        driver.findElement(By.id("closeLargeModal")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}

