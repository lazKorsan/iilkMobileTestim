package TestNQMobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static cucumberMobile.Runners.Runner_Master.*;

public class stringTest {

    AndroidDriver<AndroidElement> driver;
    @Test
    public void test01()  {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, pixel2Name);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, android);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        cap.setCapability(MobileCapabilityType.APP, appPathInfoApp);
        //cap.setCapability(MobileCapabilityType.UDID,"emulator-5554");

        try {
            driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);




    }

}
