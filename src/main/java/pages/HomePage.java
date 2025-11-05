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

import java.rmi.Remote;

public class HomePage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/facet_index_section_search_scroll_view\")")
    private RemoteWebElement homePageContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.google.android.gms:id/dialog_container_1\")")
    private RemoteWebElement googleAccountPopUp;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/home_launch_sheet_item\")")
    private RemoteWebElement homePagePopUp;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Riga\")")
    private RemoteWebElement rigaCard;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Enter your destination\")")
    private RemoteWebElement searchDestinationField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Search\").instance(0)")
    private RemoteWebElement searchButton;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.booking:id/facet_index_section_search_view_item\"]/android.view.View/android.view.View/android.widget.Button[3]")
    private RemoteWebElement roomsAndGuestsField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Select rooms and guests\")")
    private RemoteWebElement roomsAndGuestsPopUp;

    @AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.booking:id/bui_input_stepper_add_button\"])[1]")
    private RemoteWebElement addRoomsButton;

    @AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.booking:id/bui_input_stepper_add_button\"])[2]")
    private RemoteWebElement addAdultsButton;

    @AndroidFindBy(xpath = "new UiSelector().resourceId(\"com.booking:id/group_config_apply_button\")")
    private RemoteWebElement applyButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Saved\")")
    private RemoteWebElement savedButton;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean homePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(homePageContainer)).isDisplayed();
    }

    public void closePopUp() {
            new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(googleAccountPopUp)).isDisplayed();
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Cancel\"]")).click();

            new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(homePagePopUp)).isDisplayed();
            driver.navigate().back();
    }

    public void selectCountryCard(){
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(6)"));
        scrollTo(driver, element, Directions.DOWN, 1);
        rigaCard.isDisplayed();
        rigaCard.click();
    }

    public void clickSearchDestinationField() {
        searchDestinationField.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSelectRoomsAndGuests() {
        roomsAndGuestsField.click();
    }

    public void clickSavedButton() {
        savedButton.click();
    }
}
