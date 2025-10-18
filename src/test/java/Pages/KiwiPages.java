package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPages {

    public KiwiPages() {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);

    }

    @FindBy(xpath ="//android.widget.ScrollView/android.view.View[4]/android.widget.Button")
    public WebElement guestButton ;


    @FindBy(xpath="//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.skypicker.main:id/onboarding\"]/android.view.View/android.view.View[2]/android.widget.Button")
    public WebElement continueButton;



   @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
    public WebElement dontAllowButton ;

   @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
    public WebElement dontAllowButton2 ;

   @FindBy(xpath = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")
    public WebElement allowButton ;

   @FindBy(xpath ="//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.skypicker.main:id/onboarding\"]/android.view.View/android.view.View[2]/android.widget.Button")
    public WebElement exploreButton ;

   @FindBy(xpath = "//android.widget.TextView[@text=\"One way\"]")
    public WebElement oneWayButton ;

   @FindBy(xpath = "//android.widget.TextView[@text=\"One way\"]")
    public WebElement oneWayRadioButton ;

   @FindBy(xpath = "//android.widget.TextView[@text=\"From:\"]")
    public WebElement fromButton ; // //android.widget.TextView[@text="From:"]

    @FindBy(xpath = "//com.kiwi.android.shared.ui.view.base.picker.DialogComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]")
    public WebElement deleteTextButton;

    @FindBy(xpath = "//android.widget.EditText/android.view.View")
    public WebElement emptyCityArea;

    @FindBy(xpath = "//android.widget.EditText/android.view.View")
    public WebElement editTextCityButton;

    @FindBy(xpath = "//com.kiwi.android.shared.ui.view.base.picker.DialogComposeView//android.widget.Button")
    public WebElement electionWidgetButton;





   @FindBy(xpath = "//com.kiwi.android.shared.ui.view.base.picker.DialogComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[8]")
    public WebElement toEdremitButton ;

   @FindBy(xpath = "//com.kiwi.android.shared.ui.view.base.picker.DialogComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.Button")
    public WebElement chooseButton ;

   // //com.kiwi.android.shared.ui.view.base.picker.DialogComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.Button

   @FindBy(xpath = "(//android.widget.TextView[@text=\"Anywhere\"])[2]")
    public WebElement anywhereButton ;

   @FindBy(xpath = "//android.widget.TextView[@text=\"Dubai, United Arab Emirates\"]")
    public WebElement dubaiButton;

   @FindBy(xpath = "(//android.widget.TextView[@text=\"Anytime\"])[2]")
    public WebElement anytimeButton ;

@FindBy(xpath = "//android.view.View[@resource-id=\"com.skypicker.main:id/travel_calendar\"]")
    public WebElement calendarButton30 ;





























}
