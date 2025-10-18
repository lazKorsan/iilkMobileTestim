package KiwiLab;

import Pages.KiwiPages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class KiwiiTest1 {

//  packageName  = com.skypicker.main
    //  activityName = com.kiwi.android.feature.splash.impl.ui.SplashActivity

    //                 com.kiwi.android.feature.splash.impl.ui.SplashActivity

    @BeforeClass
    public void setup() {
        System.out.println("Test başlıyor: Kiwi.com  uygulaması başlatılacak...");
        Driver.getAndroidDriver("com.skypicker.main", "com.kiwi.android.feature.splash.impl.ui.SplashActivity");
        System.out.println("Driver başarıyla başlatıldı.");
    }

    @Test
    public void KiwiTesti() {

        KiwiPages kiwiPages = new KiwiPages();

        // Kullanici misafir girişi yapar.
        kiwiPages.guestButton.click();
        ReusableMethods.bekle(2);

        // kullanıcı continue tusuna basar
        kiwiPages.continueButton.click();

        // exploreTheApp butonu görülüne kadar continue tuşuna basar

        kiwiPages.exploreButton.click();
        WebDriverWait wait = new WebDriverWait((WebDriver) Driver.getAndroidDriver(), 30);
        int maxAttempts = 10;

        for (int i = 0; i < maxAttempts; i++) {
            try {

                if (kiwiPages.exploreButton.isDisplayed()) {
                    System.out.println("Explore butonu görüldü, döngüden çıkılıyor.");
                    break;
                }
            } catch (Exception e) {

                System.out.println((i + 1) + ". continue tıklanıyor...");
                kiwiPages.continueButton.click();


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        // explorethatApp butonuna tıklanır
        kiwiPages.exploreButton.click();

       //  kiwiPages.oneWayButton.click();
        kiwiPages.fromButton.click();
        ReusableMethods.bekle(2);

        kiwiPages.deleteTextButton.click();
        ReusableMethods.bekle(2);

        if (Driver.getAndroidDriver().isKeyboardShown()){
            Driver.getAndroidDriver().getKeyboard().pressKey("Antalya ");
        }else {kiwiPages.emptyCityArea.sendKeys("Antalya");
        }
        ReusableMethods.bekle(4);

        kiwiPages.electionWidgetButton.click();
        ReusableMethods.bekle(2);

        kiwiPages.chooseButton.click();
        ReusableMethods.bekle(2);

        kiwiPages.fromButton.click();
        ReusableMethods.bekle(2);

        // < -- ========= Buradan itibaren devam et
        if (Driver.getAndroidDriver().isKeyboardShown()){
            Driver.getAndroidDriver().getKeyboard().pressKey("Antalya ");
        }else {kiwiPages.editTextCityButton.sendKeys("istanbul");;
        }

        ReusableMethods.bekle(2);

        kiwiPages.electionWidgetButton.click();
        ReusableMethods.bekle(2);

        kiwiPages.chooseButton.click();
        ReusableMethods.bekle(2);

        kiwiPages.anytimeButton.click();
        ReusableMethods.bekle(2);




































    }

    @AfterClass
    public void tearDown() {
        System.out.println("Test sınıfı tamamlandı, driver kapatılıyor...");
        Driver.quitAppiumDriver();
    }

}








