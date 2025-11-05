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

public class DateSelectorPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/facet_date_picker_calendar\")")
    private RemoteWebElement dateSelectorPageContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/month_custom_view\").instance(0)")
    private RemoteWebElement monthNovember;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/facet_date_picker_confirm\")")
    private RemoteWebElement selectDatesButton;

    public DateSelectorPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean dateSelectorPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.shortTimeout).until(ExpectedConditions.visibilityOf(dateSelectorPageContainer)).isDisplayed();
    }

    public void selectStartDate(String startDate) {
        driver.findElement(By.xpath("//android.view.View[@content-desc='" + startDate + "']")).click();
    }

    public void selectEndDate(String endDate) {
        driver.findElement(By.xpath("//android.view.View[@content-desc='" + endDate + "']")).click();
    }

    public void clickSelectDatesButton() {
        selectDatesButton.click();
    }

}
