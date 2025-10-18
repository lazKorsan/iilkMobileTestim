package TestNQMobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static cucumberMobile.Runners.Runner_Master.*;

public class UpLoadPackageKiwi {

    AndroidDriver<AndroidElement> driver;

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        String apkPath = "C:\\Users\\Hp\\IdeaProjects\\MobTests\\Apps\\Kiwi.com - Book Cheap Flights_2023.14.0_Apkpure.apk";
        String packageName = "com.skypicker.main";
        String appActivity = "com.kiwi.android.feature.splash.impl.ui.SplashActivity";

        // (Opsiyonel) Emülatörde varsa eski uygulamayı kaldır / temizle - adb erişiminin PATH'te olduğunu varsayar
        try {
            runAdbCommand("adb uninstall " + packageName);
            // alternatif olarak package data temizlemek istersen:
            // runAdbCommand("adb shell pm clear " + packageName);
        } catch (IOException | InterruptedException e) {
            System.out.println("adb uninstall sırasında hata (önemsizse devam ediliyor): " + e.getMessage());
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, pixel2Name);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, android);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);

        // App path
        cap.setCapability(MobileCapabilityType.APP, apkPath);

        // ek capabilities - W3C formatıyla uyumlu isimlendirme
        cap.setCapability("appium:noReset", false); // temiz kurulum
        cap.setCapability("appium:fullReset", false);
        cap.setCapability("appium:adbExecTimeout", 120000); // adb komutları için zaman aşımı
        cap.setCapability("appium:uiautomator2ServerInstallTimeout", 60000);
        cap.setCapability("appium:uiautomator2ServerLaunchTimeout", 60000);

        // Paket / Aktivite belirlemek faydalı olabilir
        cap.setCapability("appium:appPackage", packageName);
        cap.setCapability("appium:appActivity", appActivity);

        // Appium server URL - Appium v2 ise base-path kontrol et
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Ekran kilitliyse unlock etmeye çalış
        try {
            // tercihen java-client'ın sunduğu yöntem
            if (driver.isDeviceLocked()) {
                driver.unlockDevice();
                System.out.println("Cihaz unlock edildi via driver.unlockDevice().");
            }
        } catch (Exception e) {
            // fallback: mobile shell ile keyevent gönder
            System.out.println("driver.unlockDevice() kullanılamadı veya hata verdi, shell fallback uygulanıyor: " + e.getMessage());
            try {
                Map<String, Object> args = new HashMap<>();
                // Wake up
                args.put("command", "input keyevent 224"); // KEYCODE_WAKEUP
                driver.executeScript("mobile: shell", args);
                Thread.sleep(500);
                // Unlock/menu
                args.put("command", "input keyevent 82"); // KEYCODE_MENU - şifre/kilit yoksa çoğu zaman işe yarar
                driver.executeScript("mobile: shell", args);
                Thread.sleep(500);
                // Eğer swipe ile açılması gerekiyorsa aşağıdaki komutu kullan:
                // args.put("command", "input swipe 300 1000 300 300 200");
                // driver.executeScript("mobile: shell", args);
            } catch (Exception ex) {
                System.out.println("Fallback unlock sırasında hata: " + ex.getMessage());
            }
        }

        // Uygulamayı foreground'a getir / activity başlat
        try {
            Activity activity = new Activity(packageName, appActivity);
            driver.startActivity(activity);
            System.out.println("Uygulama startActivity ile foreground'a getirildi.");
        } catch (Exception e) {
            System.out.println("startActivity sırasında hata: " + e.getMessage());
        }

        // Burada gerekli test adımlarını ekleyebilirsin...
        // driver.quit(); // Test bittiğinde kapat
    }

    private void runAdbCommand(String command) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(command);
        int exit = p.waitFor();
        // opsiyonel: çıktıyı okumak istersen
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        try (BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
            String line;
            while ((line = err.readLine()) != null) {
                System.err.println(line);
            }
        }
        if (exit != 0) {
            System.out.println("Komut '" + command + "' exit code: " + exit);
        }
    }
}