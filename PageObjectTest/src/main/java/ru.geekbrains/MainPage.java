package ru.geekbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[contains(@title, 'Dresses')]")
    public WebElement topMenuDresses;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;



}
