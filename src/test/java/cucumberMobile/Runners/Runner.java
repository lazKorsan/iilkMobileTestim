package cucumberMobile.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/cucumberMobile/Features",
        glue = {"cucumberMobile/Stepdefinitions"},
        tags = "@Tag", // Sadece smoke tag'ine sahip testleri çalıştırır
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "testng:target/cucumber-reports/CucumberTestReport.xml"
        },
        monochrome = true,
        publish = true
)
public class Runner extends AbstractTestNGCucumberTests {


}