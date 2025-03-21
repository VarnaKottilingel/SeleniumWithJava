package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/features"},
glue = {"com.github.stepdefinitions"},
plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html",
"com.aventstack.chaintest.plugins.ChainTestCucumberListener:" },
monochrome = true,
publish = true)
    
   
public class TestRunner extends AbstractTestNGCucumberTests {
   
}

