package TestNQMobile;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

public class ArabamTesti2 {

    // ADB komutu ile bulduğumuz Arabam.com uygulamasına ait kimlik bilgileri
    private static final String ARABAM_PACKAGE = "com.dogan.arabam";
    private static final String ARABAM_ACTIVITY = "com.dogan.arabam.presentation.feature.home.HomeActivity";

    @BeforeClass
    public void setup() {
        System.out.println("Test başlıyor: Arabam.com uygulaması başlatılacak...");
        // Driver'a, cihazda yüklü olan uygulamanın kimlik bilgilerini vererek başlatmasını söylüyoruz.
        Driver.getAndroidDriver(ARABAM_PACKAGE, ARABAM_ACTIVITY);
        System.out.println(1);
        System.out.println("Driver başarıyla başlatıldı.");
        System.out.println(2);
    }

    @Test
    public void verifyAppLaunchTest() {
        // Bu test, sadece uygulamanın doğru bir şekilde açılıp açılmadığını kontrol eder.

        System.out.println("Uygulamanın açıldığı doğrulanıyor...");
        System.out.println(3);

        // Doğrulamak için en güvenilir yöntem, mevcut çalışan uygulamanın paket adını,
        // beklediğimiz paket adıyla karşılaştırmaktır.
        String expectedPackageName = ARABAM_PACKAGE;
        String actualPackageName = Driver.getAndroidDriver().getCurrentPackage();

        Assert.assertEquals(actualPackageName, expectedPackageName, "Test Başarısız: Yanlış uygulama açıldı veya uygulama açılamadı!");

        System.out.println("Test Başarılı: Arabam.com uygulaması başarıyla açıldı ve doğrulandı.");

        // Bu noktadan sonra ilgili Page Object sınıfını oluşturup (örn: ArabamBlogPage) test adımlarınıza devam edebilirsiniz.
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Test sınıfı tamamlandı, driver kapatılıyor...");
        Driver.quitAppiumDriver();
    }
}
