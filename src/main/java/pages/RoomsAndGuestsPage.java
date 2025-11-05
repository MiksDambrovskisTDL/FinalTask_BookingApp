package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;
import utils.Helpers;

public class RoomsAndGuestsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Select rooms and guests\")")
    private RemoteWebElement roomsAndGuestsContainer;

    @AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.booking:id/bui_input_stepper_add_button\"])[1]")
    private RemoteWebElement addRoomsButton;

    @AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.booking:id/bui_input_stepper_add_button\"])[2]")
    private RemoteWebElement addAdultsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/group_config_apply_button\")")
    private RemoteWebElement applyButton;

    public RoomsAndGuestsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean roomsAndGuestsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(roomsAndGuestsContainer)).isDisplayed();
    }

    public void addRoomsAndGuests() {
        addRoomsButton.click();
        addAdultsButton.click();
        applyButton.click();
    }
}
