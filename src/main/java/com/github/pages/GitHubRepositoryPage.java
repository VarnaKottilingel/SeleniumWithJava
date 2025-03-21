package com.github.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.base.SeleniumBase;

public class GitHubRepositoryPage extends SeleniumBase{

    private WebDriver driver;
    
        public GitHubRepositoryPage(WebDriver driver) throws FileNotFoundException, IOException {
            this.driver=driver;
        
    }

    public void clickCreateRepository(){
        WebElement createRepositoryButton=driver.findElement(By.xpath(getLocator("createRepositoryButton")));         
        clickElement(driver, createRepositoryButton);
    }

    public void createRepository(String repoName) throws InterruptedException{
        WebElement createRepoHeading=driver.findElement(By.xpath(getLocator("createRepoHeading")));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(createRepoHeading));
        
        WebElement repositoryNameField=driver.findElement(By.xpath(getLocator("repositoryNameField")));
        type(repositoryNameField, repoName);
        WebElement repositoryValidationMessage=driver.findElement(By.xpath(getLocator("repositoryValidationMessage")));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(repositoryValidationMessage));
        Assert.assertEquals(repositoryValidationMessage.getText(), repoName+ " is available.");
        
        WebElement repositoryDescriptionField=driver.findElement(By.xpath(getLocator("repositoryDescriptionField")));
        type(repositoryDescriptionField, "Creating a new repository " + repoName);

        WebElement readmeCheckbox=driver.findElement(By.xpath(getLocator("readmeCheckbox")));
        clickElement(driver, readmeCheckbox);
        
        WebElement gitIgnoreDropdown=driver.findElement(By.xpath(getLocator("gitIgnoreDropdown")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gitIgnoreDropdown);
        clickElement(driver, gitIgnoreDropdown);
        WebElement gitIgnoreTemplateFilter=driver.findElement(By.xpath(getLocator("gitIgnoreTemplateFilter")));
        type(gitIgnoreTemplateFilter, "None");
        WebElement gitIgnoreTemplateActiveOption = driver.findElement(By.xpath(getLocator("gitIgnoreTemplateActiveOption")));
        clickElement(driver, gitIgnoreTemplateActiveOption);
        
        WebElement createRepoButton=driver.findElement(By.xpath(getLocator("createRepoButton")));
        clickElement(driver, createRepoButton);

        WebElement repoPath=driver.findElement(By.xpath(getLocator("repoPath")));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(repoPath));
        
    }

    public void verifyCreatedRepository(String repoName) throws InterruptedException{
        WebElement repoPath=driver.findElement(By.xpath(getLocator("repoPath")));
        Assert.assertEquals(repoPath.getText(), repoName);
        WebElement repoHeading=driver.findElement(By.xpath(getLocator("repoHeading")));
        Assert.assertEquals(repoHeading.getText(), repoName);
    }

    public void clickSettingsTab(){
        WebElement settingsTab=driver.findElement(By.xpath(getLocator("settings")));
        clickElement(driver, settingsTab);
    }

    public void clickDeleteRepository(){
        WebElement deleteButton=driver.findElement(By.xpath(getLocator("deleteButton")));
        clickElement(driver, deleteButton);
    }

    public String confirmDeleteRepository() throws InterruptedException{
        WebElement confirmDeleteMsgButton=driver.findElement(By.xpath(getLocator("confirmDeleteMsgButton")));
        clickElement(driver, confirmDeleteMsgButton);
        WebElement warningMessage=driver.findElement(By.xpath(getLocator("warningMessage")));
        clickElement(driver, warningMessage);
        WebElement AccountrepositoryName=driver.findElement(By.cssSelector(getLocator("AccountrepositoryName")));
        String AccountrepositoryNameString=AccountrepositoryName.getText();        
        System.out.println("text to be entered is " + AccountrepositoryNameString);
        WebElement verificationText=driver.findElement(By.xpath(getLocator("verificationText")));
        type(verificationText, AccountrepositoryNameString);
        WebElement finalDeleteButton=driver.findElement(By.xpath(getLocator("finalDeleteButton")));
        clickElement(driver, finalDeleteButton);    
        return AccountrepositoryNameString;
        
    }

    public void verifyRepositoryDeleted(String repoName) throws InterruptedException{
        WebElement dashboardFlash=driver.findElement(By.cssSelector(getLocator("dashboardFlash")));
        Assert.assertEquals(dashboardFlash.getText().trim(), "Your repository \""+ repoName +"\" was successfully deleted.");
        
    }
}
