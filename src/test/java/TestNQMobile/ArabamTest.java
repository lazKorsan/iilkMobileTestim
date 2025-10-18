package TestNQMobile;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

public class ArabamTest {

    // Test sınıfı, hangi uygulamanın test edileceğini bilir.
    private final String ARABAM_APK_PATH = "C:\\Users\\Hp\\IdeaProjects\\MobTests\\Apps\\arabam-com-5-4-1.apk"; // Gerçek yolu buraya yazın

    @BeforeClass
    public void setup() {
        // Driver'a hangi APK'yı açacağını söylüyoruz.
        // Driver.java'yı değiştirmeye GEREK YOK!
        Driver.getAndroidDriver(ARABAM_APK_PATH);
    }

    @Test
    public void arabamUygulamasiAcilisTesti() {
        // Bu testin çalışması için Arabam uygulamasının paket adını bilmemiz gerekir.
        // Örnek bir paket adı kullanılmıştır, doğrusu ile değiştirilmelidir.
        String expectedPackageName = "com.dogan.arabam";
        System.out.println(2);

        // Driver'dan mevcut uygulamanın paket adını alıyoruz.
        String actualPackageName = Driver.getAndroidDriver(ARABAM_APK_PATH).getCurrentPackage();
        System.out.println(3);
        System.out.println("Beklenen Paket Adı: " + expectedPackageName);
        System.out.println("Mevcut Paket Adı: " + actualPackageName);
        System.out.println(4);
        // Doğru uygulamanın açıldığını doğruluyoruz.
        Assert.assertEquals(actualPackageName, expectedPackageName, "Yanlış uygulama açıldı!");
        System.out.println(5);
        System.out.println("Arabam.com uygulaması başarıyla açıldı.");
        System.out.println(6);
        // Buradan sonra ArabamPages sınıfını kullanarak test adımlarınızı ekleyebilirsiniz.
        // ArabamPages arabamPages = new ArabamPages();
        // arabamPages.ilanAraButonu.click();
    }

    @AfterClass
    public void tearDown() {
        Driver.quitAppiumDriver();
    }
}
