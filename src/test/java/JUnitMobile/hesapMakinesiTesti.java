package JUnitMobile;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



    public class hesapMakinesiTesti {

        //  emulator-5554   device
        //emulator-5556   device

        AndroidDriver<AndroidElement> driver;

        @Test
        public void TC_01() throws MalformedURLException {

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.0");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\Hp\\IdeaProjects\\MobTests\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");
            //cap.setCapability(MobileCapabilityType.UDID,"emulator-5554");

            driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

            Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

            // uygulamanin acildigini dogrular
            Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/op_sqrt").isDisplayed());

            // 456 un 3 bölümünün 152 oldugunu hesap makinasindan dogrulayalim
            driver.findElementByAccessibilityId("4").click();
            driver.findElementByAccessibilityId("5").click();
            driver.findElementById("com.google.android.calculator:id/digit_6").click();
            driver.findElementByAccessibilityId("divide").click();
            driver.findElementByAccessibilityId("3").click();

            String sonuc =driver.findElementById("com.google.android.calculator:id/result_preview").getText();
            int bekledigimSonuc=152;
            Assert.assertEquals(Integer.parseInt(sonuc),bekledigimSonuc);


        }


    }

