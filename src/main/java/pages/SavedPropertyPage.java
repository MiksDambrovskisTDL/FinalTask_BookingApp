package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;

public class SavedPropertyPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/wishlist_scrollview\")")
    private RemoteWebElement savedPropertyPageContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/sr_hotel_card_content_container\")")
    private RemoteWebElement savedProperty;

    public SavedPropertyPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean savedPropertyPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(savedPropertyPageContainer)).isDisplayed();
    }

    public boolean savedPropertyDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(savedProperty)).isDisplayed();
    }

}
