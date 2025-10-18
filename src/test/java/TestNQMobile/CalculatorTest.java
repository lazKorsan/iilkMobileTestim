package TestNQMobile;

import Pages.CalculatorPages;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class CalculatorTest {

    // Testin hangi APK ile çalışacağı bilgisi, sınıf seviyesinde net bir şekilde belirtilir.
    private static final String HESAP_MAKINESI_APK_YOLU = "C:\\Users\\Hp\\IdeaProjects\\MobTests\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk";

    // Page nesnesi, test metodunun içinde değil, sınıf seviyesinde tanımlanır.
    CalculatorPages calculatorPages;

    // @BeforeClass: Testler başlamadan önce SADECE BİR KEZ çalışır.
    @BeforeClass
    public void setup() {
        // 1. ADIM: Driver'a hangi uygulamayı açacağını söyleyerek onu başlat.
        Driver.getAndroidDriver(HESAP_MAKINESI_APK_YOLU);

        // 2. ADIM: Driver artık başlatıldığına göre, Page nesnesini oluştur.
        // Bu satır, Driver.getAndroidDriver() metodunu (parametresiz olanı) çağırır.
        // Driver zaten başlatıldığı için hata vermez, mevcut driver'ı kullanır.
        calculatorPages = new CalculatorPages();
    }

    @Test
    public void hesaplamaTesti() {
        // Driver ve Page nesneleri @BeforeClass içinde hazırlandığı için
        // test metodu doğrudan test adımlarına odaklanır.

        System.out.println("Test başlıyor: Hesaplama işlemi doğrulanacak...");

        // Uygulamanın açıldığını doğrula
        Assert.assertTrue(calculatorPages.plus.isDisplayed(), "Hesap makinesi uygulaması düzgün açılamadı.");
        System.out.println("Uygulama doğrulandı.");

        // Hesaplama işlemleri
        calculatorPages.tauch4.click();
        calculatorPages.tauch5.click();
        calculatorPages.tauch6.click();
        calculatorPages.divide.click();
        calculatorPages.tauch3.click();
        System.out.println("Hesaplama adımları tamamlandı: 456 / 3");

        ReusableMethods.bekle(2);

        // Sonucu kontrol et
        // Not: Sonuç elementi ID'si 'result_final' olmalıdır, 'result_preview' ara sonuçtur.
        String sonuc = Driver.getAndroidDriver().findElementById("com.google.android.calculator:id/result_final").getText();
        int bekledigimSonuc = 152;
        Assert.assertEquals(Integer.parseInt(sonuc), bekledigimSonuc);
        System.out.println("Sonuç doğrulandı: " + sonuc);
    }

    // @AfterClass: Sınıftaki tüm testler bittikten sonra SADECE BİR KEZ çalışır.
    @AfterClass
    public void tearDown() {
        System.out.println("Test sınıfı bitti, driver kapatılıyor...");
        Driver.quitAppiumDriver();
    }
}
