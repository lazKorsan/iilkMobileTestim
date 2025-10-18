// 1. ANA RUNNER - Tüm projenin kalbi
package cucumberMobile.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/cucumberMobile/Features",
        glue = {"cucumberMobile"},
        tags = "@fullSuite",
        plugin = {"pretty", "json:target/full-suite-report.json"}
)
public class Runner_Master extends AbstractTestNGCucumberTests {

    public static final String pixel2Name = "Pixel 2";
    public static final String android = "Android";
    public static final String platformVersion = "16.0";
    public static final String automationName = "UiAutomator2";

    public static final String appPathCalculator = "C:\\Users\\Hp\\IdeaProjects\\MobTests\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk";

    public static final String appUDID= "emulator-5554";

    public static final String appPathArabam = "C:\\Users\\Hp\\IdeaProjects\\MobTests\\Apps\\arabam-com-5-4-1.apk";

    public static final String appPathInfoApp = "C:\\Users\\Hp\\IdeaProjects\\MobTests\\Apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk";


}

/*
// 2. Smoke Test Runner
@CucumberOptions(
        features = "src/test/java/cucumberMobile/Features",
        glue = {"cucumberMobile"},
        tags = "@smoke",
        plugin = {"pretty", "json:target/smoke-report.json"}
)
public class SmokeRunner extends AbstractTestNGCucumberTests {
}

// 3. Regression Test Runner
@CucumberOptions(
        features = "src/test/java/cucumberMobile/Features",
        glue = {"cucumberMobile"},
        tags = "@regression",
        plugin = {"pretty", "json:target/regression-report.json"}
)
public class RegressionRunner extends AbstractTestNGCucumberTests {
}
 */