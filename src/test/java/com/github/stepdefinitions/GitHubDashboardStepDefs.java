package com.github.stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.github.base.DriverManager;
import com.github.pages.GitHubRepositoryPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GitHubDashboardStepDefs {
    public WebDriver driver;   
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

    @When("the user creates a new repository named {string}")
    public void the_user_creates_a_new_repository_named(String repoName) throws FileNotFoundException, IOException, InterruptedException {
       GitHubRepositoryPage repoPage = new GitHubRepositoryPage(driver);
       repoPage.clickCreateRepository();
       repoPage.createRepository(repoName);
       repositoryName=repoName;
       
    }

    @Then("the repository should be created successfully")
    public void the_repository_should_be_created_successfully() throws FileNotFoundException, IOException, InterruptedException {
        GitHubRepositoryPage repoPage = new GitHubRepositoryPage(driver);
       repoPage.verifyCreatedRepository(repositoryName);        
    }

    @Then("the repository should be deleted successfully")
    public void the_repository_should_be_deleted_successfully() throws FileNotFoundException, IOException, InterruptedException {
        GitHubRepositoryPage repoPage = new GitHubRepositoryPage(driver);
        repoPage.verifyRepositoryDeleted(AccountRepositoryName);
    }

    @When("the user clicks on {string} tab")
    public void the_user_clicks_on_tab(String sTabName) throws FileNotFoundException, IOException {
        GitHubRepositoryPage repoPage = new GitHubRepositoryPage(driver);
        switch (sTabName){
            case "Settings": repoPage.clickSettingsTab();
            break;
            default: System.out.println("Invalid tab name");
        }
    }

    @When("the user clicks on Delete this repository")
    public void the_user_clicks_on_Delete_this_repository() throws FileNotFoundException, IOException, InterruptedException {
        GitHubRepositoryPage repoPage = new GitHubRepositoryPage(driver);
        repoPage.clickDeleteRepository();
        AccountRepositoryName=repoPage.confirmDeleteRepository();
    }

}
