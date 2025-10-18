package TestNQMobile;

import Pages.ArabamPages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class ArabamVolskWagwnUcuzPah {

    // ADB komutu ile bulduğumuz Arabam.com uygulamasına ait kimlik bilgileri
    private static final String ARABAM_PACKAGE = "com.dogan.arabam";
    private static final String ARABAM_ACTIVITY = "com.dogan.arabam.presentation.feature.home.HomeActivity";

    @BeforeClass
    public void setup() {
        System.out.println("Test başlıyor: Arabam.com uygulaması başlatılacak...");
        Driver.getAndroidDriver(ARABAM_PACKAGE, ARABAM_ACTIVITY);
        System.out.println("Driver başarıyla başlatıldı.");
    }

    @Test
    public void TC04_UcuzdanPahaliyaSiralamaTesti() {
        ArabamPages arabamPages = new ArabamPages();

        // Test adımları: Belirli bir arama filtresi uygulanır.
        arabamPages.ilanAraButton.click();
        ReusableMethods.bekle(2);
        arabamPages.otoAratButton.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scrollToText("Volkswagen");
        arabamPages.volskWagenButton.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scrollToText("VW CC");
        arabamPages.vvCCButton.click();
        ReusableMethods.bekle(2);
        arabamPages.vv2Dizel.click();
        ReusableMethods.bekle(2);
        arabamPages.exclusiveButton.click();
        ReusableMethods.bekle(2);
        arabamPages.siralamaButton.click();
        ReusableMethods.bekle(2);
        arabamPages.ucuzdanPahaliButton.click();
        ReusableMethods.bekle(2);

        // Adım 1: Arama sonuçları sayfasındaki "Sıralama" butonuna tıklanır.

        ReusableMethods.bekle(2);

        // Adım 2: Sıralama seçeneği olarak "Fiyat: Ucuzdan Pahalıya" seçilir.
        // Not: Bu elementin locator'ını ArabamPages sınıfınıza eklemeniz gerekebilir.
        // Örnek: arabamPages.ucuzdanPahaliyaButton.click();
        // Şimdilik pahalıdan ucuza butonunun altındaki ikinci butona tıklanacağı varsayılmıştır.
        arabamPages.ucuzdanPahaliButton.click(); // Bu locator'ı doğrulayın!
        ReusableMethods.bekle(2);

        // Adım 3: Sayfadaki tüm ilanların fiyatları bir listeye toplanır.
        List<Integer> fiyatListesi = new ArrayList<>();
        for (WebElement fiyatElementi : arabamPages.fiyatlarListesi) {
            String fiyatMetni = fiyatElementi.getText();
            if (fiyatMetni != null && !fiyatMetni.isEmpty()) {
                Integer fiyat = Integer.valueOf(fiyatMetni.replaceAll("[^0-9]", ""));
                fiyatListesi.add(fiyat);
            }
        }
        System.out.println("Toplanan Fiyatlar: " + fiyatListesi);

        // Adım 4: Fiyatların ucuzdan pahalıya doğru sıralandığı ReusableMethods ile doğrulanır.
        boolean siralamaDogru = ReusableMethods.isSortedAscending(fiyatListesi);

        // Testin başarılı sayılması için sıralamanın doğru olması gerekir.
        Assert.assertTrue(siralamaDogru, "Fiyatlar ucuzdan pahalıya doğru sıralanmamış!");

        System.out.println("Test Başarılı: Fiyatların ucuzdan pahalıya doğru sıralandığı doğrulandı.");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Test sınıfı tamamlandı, driver kapatılıyor...");
        Driver.quitAppiumDriver();
    }
}
