package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;
import utils.Helpers;

import java.rmi.server.UID;

public class SearchResultsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/sr_activity_root\")")
    private RemoteWebElement searchResultsPageContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/searchbox_destination\")")
    private RemoteWebElement searchBoxDestination;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(12)")
    private RemoteWebElement firstSearchResult;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(4)")
    private RemoteWebElement filterButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView\n")
    private RemoteWebElement favouritePropertyButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/searchbox_destination\"]")
    private RemoteWebElement destinationInSearchField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.booking:id/searchbox_dates\"]")
    private RemoteWebElement dateInSearchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Navigate up\")")
    private RemoteWebElement goBackButton;

    public SearchResultsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean searchResultsLoaded() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(searchResultsPageContainer)).isDisplayed();
    }

    public String getSearchBoxDestination() {
        return searchBoxDestination.getText();
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public boolean firstSearchResultLoaded() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(firstSearchResult)).isDisplayed();
    }

    public void clickFavouritePropertyButton() {
        favouritePropertyButton.click();
    }

    public boolean destinationIsVisible() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(destinationInSearchField)).isDisplayed();
    }

    public boolean datesAreVisible() {
        return new WebDriverWait(driver,GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(dateInSearchField)).isDisplayed();
    }

    public void clickGoBackButton() {
        goBackButton.click();
    }

}
