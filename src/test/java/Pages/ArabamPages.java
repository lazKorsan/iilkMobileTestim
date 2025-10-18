package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ArabamPages {

    public ArabamPages() {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dogan.arabam:id/navigation_bar_item_icon_view\"])[4]\n")
    public WebElement girisButton ;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.dogan.arabam:id/btnLogin\"]")
    public WebElement loginButton;

    @FindBy(xpath= "//*[@resource-id=\"com.dogan.arabam:id/et_email\"]\n")
    public WebElement mailBox;

    @FindBy(xpath = "//*[@resource-id=\"com.dogan.arabam:id/et_password\"]\n")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@resource-id=\"com.dogan.arabam:id/btn_login\"]\n")
    public WebElement loginButton2;

    @FindBy(xpath = "(//*[@resource-id=\"com.dogan.arabam:id/navigation_bar_item_icon_view\"])[2]\n")
    public WebElement ilanAraButton;

    @FindBy(xpath = "//*[@resource-id='com.dogan.arabam:id/recyclerViewCategory']/android.view.ViewGroup[1]\n")
    public WebElement otoAratButton ;


    @FindBy(xpath = "//*[@resource-id='com.dogan.arabam:id/recyclerViewBrowseCategories']/android.widget.LinearLayout[4]\n")
    public WebElement audiAramaButton ;


    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.dogan.arabam:id/recyclerViewBrowseCategories\"]/android.widget.LinearLayout[7]")
    public WebElement a4AratButton ;


    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.dogan.arabam:id/recyclerViewBrowseCategories\"]/android.widget.LinearLayout[2]")
    public WebElement a4AvantButton;


    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.dogan.arabam:id/recyclerViewBrowseCategories\"]/android.widget.LinearLayout[2]")
    public WebElement dizelbir9button;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dogan.arabam:id/tvPrice\"]")
    public WebElement fiyatContainer;


    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dogan.arabam:id/textViewBrowseCategory\" and @text=\"Volkswagen\"]")
    public WebElement volskWagenButton ;



    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.dogan.arabam:id/recyclerViewBrowseCategories\"]/android.widget.LinearLayout[11]")
    public WebElement vvCCButton ;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.dogan.arabam:id/recyclerViewBrowseCategories\"]/android.widget.LinearLayout[4]")
    public WebElement vv2Dizel ;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dogan.arabam:id/textViewBrowseCategory\" and @text=\"Exclusive\"]")
    public WebElement exclusiveButton ;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.dogan.arabam:id/imageViewSorting\"]")
    public WebElement siralamaButton ;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dogan.arabam:id/tvItem\" and @text=\"Fiyat - Pahalıdan Ucuza\"]")
    public WebElement pahalidanUcuzaButton ;

    // //android.widget.TextView[@resource-id="com.dogan.arabam:id/tvItem" and @text="Fiyat - Ucuzdan Pahalıya"]

    @FindBy(xpath = "(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]")
    public WebElement ucuzdanPahaliButton ;

    @FindBy(xpath ="(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]")
    public List<WebElement> fiyatlarListesi;





















    // Diğer elementlerinizi buraya ekleyin
    // Örnek:
    // @FindBy(id = "com.arabam.android:id/buttonLogin")
    // public WebElement loginButton;
}