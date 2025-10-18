package cucumberMobile.stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static cucumberMobile.Runners.Runner_Master.*;

public class calculatorYukleStepdefinitions {



    AndroidDriver<AndroidElement> driver;

    @Given("Kullanici Android driver'i baslatir")
    public void kullanici_android_driver_i_baslatir() {
        // Driver başlatma işlemleri burada yapılabilir
        System.out.println("Android driver hazırlanıyor...");
    }

    @Given("Kullanici {string} apk dosyasini yukler")
    public void kullanici_apk_dosyasini_yukler(String apkAdi) {
        String appPath = getAppPath(apkAdi);

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, pixel2Name);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, android);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        cap.setCapability(MobileCapabilityType.APP, appPath);

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Then("Calculator uygulamasinin yuklendigini dogrular")
    public void calculator_uygulamasinin_yuklendigini_dogrular() {
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
    }

    @Then("Calculator uygulamasinin acildigini dogrular")
    public void calculator_uygulamasinin_acildigini_dogrular() {
        // Uygulamanın açıldığını doğrular
        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/op_sqrt").isDisplayed());

        // Hesap makinesi testi
        driver.findElementByAccessibilityId("4").click();
        driver.findElementByAccessibilityId("5").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementByAccessibilityId("divide").click();
        driver.findElementByAccessibilityId("3").click();

        String sonuc = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        int bekledigimSonuc = 152;
        Assert.assertEquals(Integer.parseInt(sonuc), bekledigimSonuc);
    }

    @Then("Arabam uygulamasinin yuklendigini dogrular")
    public void arabam_uygulamasinin_yuklendigini_dogrular() {
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
    }

    @Then("{string} paketinin yuklendigini dogrular")
    public void paketinin_yuklendigini_dogrular(String appPackage) {
        Assert.assertTrue(driver.isAppInstalled(appPackage));
    }

    // APK adına göre dosya yolunu döndüren yardımcı metod
    private String getAppPath(String apkAdi) {
        switch (apkAdi.toLowerCase()) {
            case "calculator":
                return appPathCalculator;
            case "arabam":
                return appPathArabam;
            default:
                throw new IllegalArgumentException("Bilinmeyen APK: " + apkAdi);
        }
    }
}