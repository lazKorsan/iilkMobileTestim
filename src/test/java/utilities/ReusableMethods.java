package utilities;

import io.appium.java_client.MobileBy;

import java.util.List;

import static utilities.Driver.getAndroidDriver;

public class ReusableMethods {
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Belirtilen metni i\u00e7eren \u00f6\u011fe g\u00f6r\u00fcn\u00fcr olana kadar ekran\u0131 a\u015fa\u011f\u0131 kayd\u0131r\u0131r.
     * @param text Kayd\u0131r\u0131larak bulunacak metin.
     */
    public static void scrollToText(String text) {
        getAndroidDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
    }

    /**
     * Verilen bir Integer listesinin b\u00fcy\u00fckten k\u00fc\u00e7\u00fc\u011fe (azalan s\u0131rada) s\u0131ralan\u0131p s\u0131ralanmad\u0131\u011f\u0131n\u0131 kontrol eder.
     * E\u015fit de\u011ferlere izin verilir.
     * @param list Kontrol edilecek liste.
     * @return Liste b\u00fcy\u00fckten k\u00fc\u00e7\u00fc\u011fe s\u0131ral\u0131 ise true, de\u011filse false d\u00f6ner.
     */
    public static boolean isSortedDescending(List<Integer> list) { // pahalıdan ucuza
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                System.out.println(String.format("HATA: S\u0131ralama bozuk! De\u011fer %d, bir sonraki de\u011fer olan %d'den k\u00fc\u00e7\u00fck.", list.get(i), list.get(i + 1)));
                return false;
            }
        }
        return true;
    }

    /**
     * Verilen bir Integer listesinin k\u00fc\u00e7\u00fckten b\u00fcy\u00fc\u011fe (artan s\u0131rada) s\u0131ralan\u0131p s\u0131ralanmad\u0131\u011f\u0131n\u0131 kontrol eder.
     * E\u015fit de\u011ferlere izin verilir.
     * @param list Kontrol edilecek liste.
     * @return Liste k\u00fc\u00e7\u00fckten b\u00fcy\u00fc\u011fe s\u0131ral\u0131 ise true, de\u011filse false d\u00f6ner.
     */
    public static boolean isSortedAscending(List<Integer> list) { // ucuzdan pahalıya
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                System.out.println(String.format("HATA: S\u0131ralama bozuk! De\u011fer %d, bir sonraki de\u011fer olan %d'den b\u00fcy\u00fck.", list.get(i), list.get(i + 1)));
                return false;
            }
        }
        return true;
    }
}
