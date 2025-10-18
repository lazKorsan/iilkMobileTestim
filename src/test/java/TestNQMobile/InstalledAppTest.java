package TestNQMobile;

import Pages.CalculatorPages;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

public class InstalledAppTest {

    // ADB ile bulduğumuz uygulama kimlik bilgileri
    private static final String CALCULATOR_PACKAGE = "com.google.android.calculator";
    private static final String CALCULATOR_ACTIVITY = "com.android.calculator2.Calculator";

    CalculatorPages calculatorPages;

    @BeforeClass
    public void setup() {
        // Driver'a .apk yolu yerine, uygulama kimliğini vererek başlatmasını söylüyoruz.
        // Driver.java'yı değiştirmeye GEREK YOK!
        Driver.getAndroidDriver(CALCULATOR_PACKAGE, CALCULATOR_ACTIVITY);

        // Driver başlatıldığına göre Page nesnesini oluşturabiliriz.
        calculatorPages = new CalculatorPages();
    }

    @Test
    public void installedAppLaunchTest() {
        System.out.println("Test başlıyor: Yüklü olan Hesap Makinesi uygulamasının açıldığı doğrulanacak...");

        // Doğru uygulamanın açıldığını doğrulamak için en iyi yol,
        // mevcut paket adını beklenen paket adıyla karşılaştırmaktır.
        String actualPackage = Driver.getAndroidDriver().getCurrentPackage();
        Assert.assertEquals(actualPackage, CALCULATOR_PACKAGE, "Yanlış uygulama açıldı!");

        // Ek olarak, bir elementin görünürlüğünü de kontrol edebiliriz.
        Assert.assertTrue(calculatorPages.plus.isDisplayed(), "Hesap makinesi ana ekranı yüklenemedi.");

        System.out.println("Cihazda yüklü olan uygulama başarıyla açıldı ve doğrulandı.");
    }

    @AfterClass
    public void tearDown() {
        Driver.quitAppiumDriver();
    }
}
