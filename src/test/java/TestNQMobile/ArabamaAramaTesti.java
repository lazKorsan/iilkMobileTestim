package TestNQMobile;

import Pages.ArabamPages;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class ArabamaAramaTesti {

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
    public void TC01() {

        ArabamPages arabamPages = new ArabamPages();




        System.out.println("Uygulamanın açıldığı doğrulanıyor...");
        System.out.println(3);

        // Arabam.com uygulamasının açıldığını test etmek için paket adları karşılaştırılır.
        // Beklenen değer, test edilen uygulamanın paket adıdır.
        String expectedPackageName = ARABAM_PACKAGE;

        // Gerçek paket adı driver'dan alınır.
        String actualPackageName = Driver.getAndroidDriver().getCurrentPackage();

        // Doğrulama yapılır.
        Assert.assertEquals(actualPackageName, expectedPackageName, "Test Başarısız: Yanlış uygulama açıldı veya uygulama açılamadı!");

        // Ekrana uygulamanın başarılı bir şekilde açıldığı yazdırılır.
        System.out.println("Test Başarılı: Arabam.com uygulaması başarıyla açıldı ve doğrulandı.");
        ReusableMethods.bekle(2);

        // İlan arama sayfasına gidilir.
        arabamPages.ilanAraButton.click();
        ReusableMethods.bekle(2);

        // Otomobil araması yapılır.
        arabamPages.otoAratButton.click();
        ReusableMethods.bekle(2);

        // Audi marka arabalar aratılır.
        arabamPages.audiAramaButton.click();
        ReusableMethods.bekle(2);

        // Açılan sayfada A4 modeli aratılır.
        arabamPages.a4AratButton.click();
        ReusableMethods.bekle(2);

        // A4 modellerinden Avant türü seçilir.
        arabamPages.a4AvantButton.click();
        ReusableMethods.bekle(2);
        System.out.println(13);

        // Avant modelinin 1.9 dizel yakıt türü olan tercih edilir.
        arabamPages.dizelbir9button.click();
        ReusableMethods.bekle(2);

        // Açılan sayfadan aracın fiyat bilgisi alınır.
        String fiyatBilgisi = arabamPages.fiyatContainer.getText(); // "630.000 TL"

        // Fiyat bilgisi '.' ve 'TL' gibi karakterlerden arındırılır.
        String sadeceRakam = fiyatBilgisi.replaceAll("[^0-9]", ""); // "630000"

        // String olan fiyat bilgisi Integer'a çevrilir (cast edilir).
        Integer actualFiyat = Integer.valueOf(sadeceRakam); // 630000

        // Fiyat bilgisi konsola yazdırılır.
        System.out.println(fiyatBilgisi);


        // Beklenen fiyat bilgisi tanımlanır.
        int expectedFiyat = 500000; // Fiyatın 500.000'den büyük olması bekleniyor.


        // Gerçek değer ile beklenen değer karşılaştırılır. Fiyatın 500.000'den büyük olması doğrulanır.
        Assert.assertTrue(actualFiyat > expectedFiyat,
                String.format("Fiyat beklenen değeri aşmadı! Actual: %d, Expected: >%d", actualFiyat, expectedFiyat));







    }

    // Test bitiminde driver temizlenerek kapatılır.
    @AfterClass
    public void tearDown() {
        System.out.println("Test sınıfı tamamlandı, driver kapatılıyor...");
        Driver.quitAppiumDriver();
    }
}
