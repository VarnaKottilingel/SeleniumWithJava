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

public class GitHubLoginPage extends SeleniumBase {
      public GitHubLoginPage(WebDriver driver) throws FileNotFoundException, IOException {
        this.driver = driver;
      }

    public void login(String username, String password) throws InterruptedException {
        WebElement usernameField=driver.findElement(By.xpath(getLocator("emailField")));
        WebElement passwordField=driver.findElement(By.xpath(getLocator("passwordField")));
        WebElement loginButton=driver.findElement(By.xpath(getLocator("loginButton")));
        type(usernameField, username);
        type(passwordField, password);
        clickElement(driver, loginButton);
       WebElement dashboardLabel=driver.findElement(By.xpath(getLocator("dashboardLabel")));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(dashboardLabel));
    }  


    
}