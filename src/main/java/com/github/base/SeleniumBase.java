package com.github.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {

    protected WebDriver driver = null;
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    protected Properties prop = new Properties();

    public SeleniumBase() throws FileNotFoundException, IOException{
        prop.load( new FileInputStream("src\\test\\resources\\locators.properties"));
    }

    public void clickElement(WebDriver driver2, WebElement element){
        new WebDriverWait(driver2, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void type(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public String getLocator(String webElementName){
        return prop.getProperty(webElementName);
    }


}


