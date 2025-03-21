package com.github.stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

import com.github.base.DriverManager;
import com.github.pages.GitHubLoginPage;
import com.github.pages.HomePage;
import com.github.utils.ConfigurationUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageStepDefs {
     public WebDriver driver;    
     private HomePage homePage;
     private ConfigurationUtils configUtils;
     private GitHubLoginPage loginPage;
     public String repositoryName;
     public String AccountRepositoryName;

     @Before
     public void setup(){
        driver = DriverManager.getDriver();  
     }
 
     @After
     public void tearDown(){
        DriverManager.quitDriver();
     }
    
    @Given("the user is on the GitHub login page")
    public void the_user_is_on_the_Github_login_page() throws FileNotFoundException, IOException, InterruptedException  {
        homePage = new HomePage(driver);
        configUtils = new ConfigurationUtils("src/test/resources/config.properties");
        driver.get(configUtils.getUrl());
        homePage.launchGitHub();
        homePage.clickSignIn();
    }

    @When("the user logs in with username and password")
    public void the_user_logs_in_with_username_and_password() throws InterruptedException, FileNotFoundException, IOException {
        loginPage = new GitHubLoginPage(driver);
        String username=configUtils.getProperty("username");
        String password=configUtils.getProperty("password");
        loginPage.login(username, password);
    }


    
}


