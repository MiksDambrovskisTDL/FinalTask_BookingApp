package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;

public class LoginPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\")")
    private RemoteWebElement loginPageContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/bt_accept\")")
    private RemoteWebElement cookieAcceptButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Navigate up\")")
    private RemoteWebElement closeLoginButton;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean loginPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(loginPageContainer)).isDisplayed();
    }

    public void acceptCookies() {
        cookieAcceptButton.click();
    }

    public void closeLoginPage() {
        closeLoginButton.click();
    }
}
