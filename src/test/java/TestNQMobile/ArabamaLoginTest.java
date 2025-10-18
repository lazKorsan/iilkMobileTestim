package TestNQMobile;

import Pages.ArabamPages;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class ArabamaLoginTest {

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
    public void TC01(){

        ArabamPages arabamPages = new ArabamPages();




        // Bu test, sadece uygulamanın doğru bir şekilde açılıp açılmadığını kontrol eder.

        System.out.println("Uygulamanın açıldığı doğrulanıyor...");
        System.out.println(3);

        // Doğrulamak için en güvenilir yöntem, mevcut çalışan uygulamanın paket adını,
        // beklediğimiz paket adıyla karşılaştırmaktır.
        String expectedPackageName = ARABAM_PACKAGE;
        String actualPackageName = Driver.getAndroidDriver().getCurrentPackage();

        Assert.assertEquals(actualPackageName, expectedPackageName, "Test Başarısız: Yanlış uygulama açıldı veya uygulama açılamadı!");

        System.out.println("Test Başarılı: Arabam.com uygulaması başarıyla açıldı ve doğrulandı.");

        ReusableMethods.bekle(2);

        // Bu noktadan sonra ilgili Page Object sınıfını oluşturup (örn: ArabamBlogPage) test adımlarınıza devam edebilirsiniz.

        // login butonununa basılır



        arabamPages.girisButton.click();
        ReusableMethods.bekle(2);
        System.out.println(9);

        arabamPages.loginButton.click();
        ReusableMethods.bekle(2);
        System.out.println(10);

        arabamPages.mailBox.sendKeys("testfort108@gmail.com");
        ReusableMethods.bekle(2);
        System.out.println(11);

        arabamPages.passwordBox.sendKeys("t108t108");
        ReusableMethods.bekle(2);
        System.out.println(12);

        arabamPages.loginButton2.click();
        ReusableMethods.bekle(2);
        System.out.println(13);




        // mail alanına geçerli mail adresi girilir




    }

    @AfterClass
    public void tearDown() {
        System.out.println("Test sınıfı tamamlandı, driver kapatılıyor...");
        Driver.quitAppiumDriver();
    }
}



