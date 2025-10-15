import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMak {
    AndroidDriver<AndroidElement>driver;

public class hesapMakinesiTesti {

    AndroidDriver<AndroidElement> driver;

    @Test
    public void TC_01(){

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\elifk\\IdeaProjects\\162_Appium\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");


    }





}
