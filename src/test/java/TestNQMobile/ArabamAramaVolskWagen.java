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

public class ArabamAramaVolskWagen {

    // ADB komutu ile bulduğumuz Arabam.com uygulamasına ait kimlik bilgileri
    private static final String ARABAM_PACKAGE = "com.dogan.arabam";
    private static final String ARABAM_ACTIVITY = "com.dogan.arabam.presentation.feature.home.HomeActivity";

    @BeforeClass
    public void setup() {
        System.out.println("Test başlıyor: Arabam.com uygulaması başlatılacak...");
        // Driver'a, cihazda yüklü olan uygulamanın kimlik bilgilerini vererek başlatmasını söylüyoruz.
        Driver.getAndroidDriver(ARABAM_PACKAGE, ARABAM_ACTIVITY);
        System.out.println("Driver başarıyla başlatıldı.");
    }

    @Test
    public void TC02_VolkswagenAramaTesti() {
        ArabamPages arabamPages = new ArabamPages();

        // Adım 1: Ana sayfadaki "İlan Ara" butonuna tıklanır.
        arabamPages.ilanAraButton.click();
        ReusableMethods.bekle(2);

        // Adım 2: Araç türü olarak "Otomobil" seçilir.
        arabamPages.otoAratButton.click();
        ReusableMethods.bekle(2);

        // Adım 3: Marka listesinden "Volkswagen" markası bulunana kadar ekran aşağı kaydırılır.
        System.out.println("Volkswagen markası aranıyor...");
        ReusableMethods.scrollToText("Volkswagen");
        ReusableMethods.bekle(1);

        // Adım 4: "Volkswagen" markası seçilir.
        System.out.println("Volkswagen markasına tıklandı.");
        arabamPages.volskWagenButton.click();
        ReusableMethods.bekle(2);

        // Adım 5: Model olarak "VW CC" bulunana kadar kaydırılır ve seçilir.
        ReusableMethods.scrollToText("VW CC");
        arabamPages.vvCCButton.click();
        ReusableMethods.bekle(2);

        // Adım 6: Motor tipi olarak "2.0 TDI" seçilir.
        arabamPages.vv2Dizel.click();
        ReusableMethods.bekle(2);

        // Adım 7: Donanım paketi olarak "Exclusive" seçilir.
        arabamPages.exclusiveButton.click();
        ReusableMethods.bekle(2);

        // Adım 8: Arama sonuçları sayfasındaki "Sıralama" butonuna tıklanır.
        arabamPages.siralamaButton.click();
        ReusableMethods.bekle(2);

        // Adım 9: Sıralama seçeneği olarak "Fiyat: Pahalıdan ucuza" seçilir.
        arabamPages.pahalidanUcuzaButton.click();
        ReusableMethods.bekle(2);

        // Adım 10: Sayfadaki tüm ilanların fiyatları bir listeye toplanır.
        List<Integer> fiyatListesi = new ArrayList<>();
        for (WebElement fiyatElementi : arabamPages.fiyatlarListesi) {
            String fiyatMetni = fiyatElementi.getText(); // Örn: "1.250.000 TL"
            if (fiyatMetni != null && !fiyatMetni.isEmpty()) {
                // Fiyat metnindeki rakam olmayan tüm karakterler temizlenir ve sayıya dönüştürülür.
                Integer fiyat = Integer.valueOf(fiyatMetni.replaceAll("[^0-9]", "")); // "1250000" -> 1250000
                fiyatListesi.add(fiyat);
            }
        }
        System.out.println("Toplanan Fiyatlar: " + fiyatListesi);

        // Adım 11: Fiyatların pahalıdan ucuza doğru sıralandığı doğrulanır.
        boolean siralamaDogru = true;
        for (int i = 0; i < fiyatListesi.size() - 1; i++) {
            Integer mevcutFiyat = fiyatListesi.get(i);
            Integer sonrakiFiyat = fiyatListesi.get(i + 1);

            // Eğer mevcut fiyat, bir sonraki fiyattan daha düşükse sıralama hatalıdır.
            if (mevcutFiyat < sonrakiFiyat) {
                siralamaDogru = false;
                System.out.println(String.format("HATA: Sıralama bozuk! Fiyat %d, bir sonraki fiyat olan %d'den küçük.", mevcutFiyat, sonrakiFiyat));
                break; // Hata bulunduğu için döngüden çıkılır.
            }
        }

        // Testin başarılı sayılması için sıralamanın doğru olması gerekir.
        Assert.assertTrue(siralamaDogru, "Fiyatlar pahalıdan ucuza doğru sıralanmamış!");

        System.out.println("Test Başarılı: Fiyatların pahalıdan ucuza doğru sıralandığı doğrulandı.");

    }

    @AfterClass
    public void tearDown() {
        System.out.println("Test sınıfı tamamlandı, driver kapatılıyor...");
        Driver.quitAppiumDriver();
    }
}
