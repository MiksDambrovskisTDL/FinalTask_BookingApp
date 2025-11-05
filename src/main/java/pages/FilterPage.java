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

public class FilterPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/filters_recyclerView\")")
    private RemoteWebElement filterPageContainer;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Breakfast included')]")
    private RemoteWebElement breakfastIncludedButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Free parking')]")
    private RemoteWebElement freeParkingButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/apply_button\")")
    private RemoteWebElement showResultsButton;

    public FilterPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean filterPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(filterPageContainer)).isDisplayed();
    }

    public void clickBreakfastIncludedFilter() {
        breakfastIncludedButton.click();
    }

    public void clickShowResultsButton() {
        showResultsButton.click();
    }

    public void clickFreeParkingFilter() {
        freeParkingButton.click();
    }
}
