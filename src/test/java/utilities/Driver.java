package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver<AndroidElement> appiumDriver;

    static final String TELEFONADI = "Pixel 4";
    static final String ANDROIDVERSION = "10.0";
    static final String PLATFORM = "Android";
    static final String OTOMASYON_ISMI = "UiAutomator2";

    // --- YÖNTEM 1: APK Dosya Yolu ile Driver'ı başlatan metot ---
    public static AndroidDriver<AndroidElement> getAndroidDriver(String apkPath) {
        if (appiumDriver == null) {
            DesiredCapabilities caps = createBaseCapabilities();
            caps.setCapability(MobileCapabilityType.APP, apkPath);
            initializeDriver(caps);
        }
        return appiumDriver;
    }

    // --- YÖNTEM 2: appPackage ve appActivity ile Driver'ı başlatan metot ---
    public static AndroidDriver<AndroidElement> getAndroidDriver(String appPackage, String appActivity) {
        if (appiumDriver == null) {
            DesiredCapabilities caps = createBaseCapabilities();
            caps.setCapability("appPackage", appPackage);
            caps.setCapability("appActivity", appActivity);
            initializeDriver(caps);
        }
        return appiumDriver;
    }

    // --- YÖNTEM 3: Sadece mevcut Driver'ı döndüren metot (Page sınıfları için) ---
    public static AndroidDriver<AndroidElement> getAndroidDriver() {
        if (appiumDriver == null) {
            throw new IllegalStateException("Driver başlatılmamış! Lütfen önce getAndroidDriver(apkPath) veya getAndroidDriver(package, activity) metodunu çağırın.");
        }
        return appiumDriver;
    }

    // Ortak yetenekleri (capabilities) oluşturan metot
    private static DesiredCapabilities createBaseCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, TELEFONADI);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ANDROIDVERSION);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, OTOMASYON_ISMI);
        // Metin girişi için Appium'un özel klavyesini kullanır, testin güvenirliğini artırır.
        caps.setCapability("unicodeKeyboard", true);
        // Test bittiğinde cihazın orijinal klavyesini geri yükler.
        caps.setCapability("resetKeyboard", true);
        caps.setCapability(MobileCapabilityType.NO_RESET, false);
        return caps;
    }

    private static void initializeDriver(DesiredCapabilities caps) {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium sunucu URL'si hatalı: " + e.getMessage());
        }
        appiumDriver = new AndroidDriver<>(appiumServerURL, caps);
        appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}