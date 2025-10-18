package Pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class CalculatorPages {



    public CalculatorPages(){

      //  PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)),this);
          PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);

    }

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"0\"]")
    public WebElement tauch0;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"1\"]")
    public WebElement tauch1;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"2\"]")
    public WebElement tauch2;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"3\"]")
    public WebElement tauch3;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"4\"]")
    public WebElement tauch4;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"5\"]")
    public WebElement tauch5;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"6\"]")
    public WebElement tauch6;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"7\"]")
    public WebElement tauch7;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"8\"]")
    public WebElement tauch8;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"9\"]")
    public WebElement tauch9;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"percent\"]")
    public WebElement percent;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"divide\"]")
    public WebElement divide;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"multiply\"]")
    public WebElement multiply;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"minus\"]")
    public WebElement minus;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"plus\"]")
    public WebElement plus;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"equals\"]")
    public WebElement equals;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"clear\"]")
    public WebElement clear;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"decimal\"]")
    public WebElement decimal;










}
