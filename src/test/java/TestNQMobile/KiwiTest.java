package TestNQMobile;

import Pages.KiwiPages;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

public class KiwiTest {


    private static String KIWI_PACKAGE = "com.skypicker.main";   //  appPackage      appActivity
    private static String KIWI_ACTIVITY = "com.kiwi.android.feature.splash.impl.ui.SplashActivity";

    @BeforeClass
    public void setup() {
        System.out.println("Test başlıyor: Kiwi uygulaması başlatılacak...");
        Driver.getAndroidDriver(KIWI_PACKAGE, KIWI_ACTIVITY);   //  appPackage      appActivity
        System.out.println("Driver başarıyla başlatıldı.");
    }

    @Test
    public void kiwiTest() {
        KiwiPages kiwiPages = new KiwiPages();

        kiwiPages.guestButton.click();
        kiwiPages.continueButton.click(); // explore the app yazısı görünmüyorsa coninue tuşuna basacak bir döngü girebilirmisin

        kiwiPages.exploreButton.click();





    }


    @AfterClass
    public void tearDown() {
        System.out.println("Test sınıfı tamamlandı, driver kapatılıyor...");
        Driver.quitAppiumDriver();
    }
}
