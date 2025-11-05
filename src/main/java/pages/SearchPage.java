package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;

public class SearchPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/facet_with_bui_free_search_booking_header_toolbar\")")
    private RemoteWebElement searchPageContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content\")")
    private RemoteWebElement enterDestinationTextBox;

    @AndroidFindBy(xpath =  "(//androidx.recyclerview.widget.RecyclerView//android.widget.TextView[@text='Skopje'])[1]\n")
    private RemoteWebElement searchResultForSkopje;

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean searchPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(searchPageContainer)).isDisplayed();
    }

    public void enterSearchDestination(String destination) {
        enterDestinationTextBox.sendKeys(destination);
    }

    public boolean searchResultLoaded(){
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(searchResultForSkopje)).isDisplayed();
    }

    public void selectDestination(){
        searchResultForSkopje.click();
    }
}
