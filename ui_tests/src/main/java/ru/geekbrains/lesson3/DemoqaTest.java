package ru.geekbrains.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        driver.findElement(By.xpath("//div[contains(@class, 'adplus-anchor')]")).clear();
        driver.findElement(By.xpath("//div[contains(@class, 'leaderboard')]")).clear();
        driver.findElement(By.xpath("//div[contains(@class, 'row-container')]")).clear();
        driver.switchTo().parentFrame();


              ((JavascriptExecutor)driver).executeScript("var badTableEval = document.evaluate (\n" +
              "    \"//footer\",\n" +
              "    document.documentElement,\n" +
              "    null,\n" +
              "    XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
              "    null\n" +
              ");\n" +
              "\n" +
              "if (badTableEval  &&  badTableEval.singleNodeValue) {\n" +
              "    var badTable  = badTableEval.singleNodeValue;\n" +
              "    badTable.parentNode.removeChild (badTable);\n" +
              "}");

//        ((JavascriptExecutor)driver).executeScript("window,open");
//        driver.getWindowHandle();
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        driver.switchTo().newWindow(WindowType.TAB);
//        Thread.sleep(2000);
//        driver.close();

        ((JavascriptExecutor)driver).executeScript("var badTableEval = document.evaluate (" +
                "'//footer', " + "document.documentElement, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);" +
                "if (badTableEval  &&  badTableEval.singleNodeValue) {" +
                "var badTable  = badTableEval.singleNodeValue;" +
                "badTable.parentNode.removeChild (badTable);}");

        Thread.sleep(5000);
        driver.quit();

    }


//    var badTableEval = document.evaluate ("//footer", document.documentElement, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);
//
//        if (badTableEval  &&  badTableEval.singleNodeValue) {
//        var badTable  = badTableEval.singleNodeValue;
//        badTable.parentNode.removeChild (badTable);
//    }
//
//
//
//
//
//((JavascriptExecutor)driver).executeScript("var badTableEval = document.evaluate (\n" +
//                                                   "    \"//footer\",\n" +
//                                                   "    document.documentElement,\n" +
//                                                   "    null,\n" +
//                                                   "    XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
//                                                   "    null\n" +
//                                                   ");\n" +
//                                                   "\n" +
//                                                   "if (badTableEval  &&  badTableEval.singleNodeValue) {\n" +
//                                                   "    var badTable  = badTableEval.singleNodeValue;\n" +
//                                                   "    badTable.parentNode.removeChild (badTable);\n" +
//                                                   "}");
}
