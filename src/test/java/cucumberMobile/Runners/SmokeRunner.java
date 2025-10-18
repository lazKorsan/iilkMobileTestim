package cucumberMobile.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// 2. Smoke Test Runner
@CucumberOptions(
        features = "src/test/java/cucumberMobile/Features",
        glue = {"cucumberMobile"},
        tags =  "@calculator",
        plugin = {"pretty", "json:target/smoke-report.json"}
)
public class SmokeRunner extends AbstractTestNGCucumberTests {
}
