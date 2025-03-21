package com.github.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.base.SeleniumBase;

public class HomePage extends SeleniumBase {
      public HomePage(WebDriver driver) throws FileNotFoundException, IOException {
        this.driver = driver;        
    }
    
    public void launchGitHub() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement signInButton=driver.findElement(By.xpath(getLocator("signInButton")));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(signInButton));
        
    }
    public void clickSignIn() {
        WebElement signInButton=driver.findElement(By.xpath(getLocator("signInButton")));
        clickElement( driver,signInButton); 
        WebElement signInHeader=driver.findElement(By.xpath(getLocator("signInHeader")));              
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(signInHeader));
    }

}
