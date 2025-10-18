package TestNQMobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static cucumberMobile.Runners.Runner_Master.*;
import static cucumberMobile.Runners.Runner_Master.appPathInfoApp;
import static cucumberMobile.Runners.Runner_Master.automationName;

public class kiwiUpload {


    AndroidDriver<AndroidElement> driver;
    @Test
    public void test01() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, pixel2Name);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, android);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\Hp\\IdeaProjects\\MobTests\\Apps\\Kiwi.com - Book Cheap Flights_2023.14.0_Apkpure.apk");
        //cap.setCapability(MobileCapabilityType.UDID,"emulator-5554");


            driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        }
}
