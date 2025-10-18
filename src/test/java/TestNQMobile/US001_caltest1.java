package TestNQMobile;

import Pages.CalculatorPages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

import java.net.MalformedURLException;

public class US001_caltest1 {

    // Driver nesnesi ve Page nesnesi sınıf seviyesinde tanımlanır.
    CalculatorPages calculatorPages = new CalculatorPages();

    // Bu method testler başlamadan önce bir kez çalışır ve driver'ı başlatır.
    // Driver.getAndroidDriver() çağrısı, utilities.Driver sınıfınızdaki driver'ı kurar.
    @BeforeClass
    public void setup() {
        Driver.getAndroidDriver();
    }

    @Test
    public void test01() throws MalformedURLException {
        // Uygulamanın yüklü olduğunu kontrol et
        Assert.assertTrue(Driver.getAndroidDriver().isAppInstalled("com.google.android.calculator"));

        // Uygulamanın açıldığını doğrula
        Assert.assertTrue(calculatorPages.plus.isDisplayed()); // Rastgele bir elementin görünürlüğünü kontrol et

        // Hesaplama işlemleri
        // Driver.getAndroidDriver() üzerinden doğrudan erişim yerine Page nesnesi kullanılır.
        calculatorPages.tauch4.click();
        calculatorPages.tauch5.click();
        calculatorPages.tauch6.click();
        calculatorPages.divide.click();
        calculatorPages.tauch3.click();

        // Sonucu kontrol et
        String sonuc = Driver.getAndroidDriver().findElementById("com.google.android.calculator:id/result_preview").getText();
        int bekledigimSonuc = 152;
        Assert.assertEquals(Integer.parseInt(sonuc), bekledigimSonuc);
    }

    @Test
    public void test02() throws MalformedURLException {
        // Driver kurulumu @BeforeClass'ta yapıldığı için burada tekrar gerekmez.

        // Uygulamanın yüklü olduğunu kontrol et
        Assert.assertTrue(Driver.getAndroidDriver().isAppInstalled("com.google.android.calculator"));

        // Uygulamanın açıldığını doğrula
        Assert.assertTrue(calculatorPages.plus.isDisplayed());

        // Hesaplama işlemleri - Sadece Page nesnesi kullanılır.
        calculatorPages.tauch4.click();
        calculatorPages.tauch5.click();
        calculatorPages.tauch6.click();
        calculatorPages.divide.click();
        calculatorPages.tauch3.click();

        // Sonucu kontrol et
        String sonuc = Driver.getAndroidDriver().findElementById("com.google.android.calculator:id/result_preview").getText();
        int bekledigimSonuc = 152;
        Assert.assertEquals(Integer.parseInt(sonuc), bekledigimSonuc);
    }
}
