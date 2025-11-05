package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.*;

import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@Listeners({ITestListenerUtility.class})
public class DriverSetup extends ConfigReader {

    public static AndroidDriver driver;
    private final AppiumServerManager appiumServerManager = new AppiumServerManager();

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SearchResultsPage searchResultsPage;
    protected FilterPage filterPage;
    protected SearchPage searchPage;
    protected DateSelectorPage dateSelectorPage;
    protected RoomsAndGuestsPage roomsAndGuestsPage;
    protected SavedPropertyPage savedPropertyPage;

    @BeforeSuite
    public void startAppiumServer() {
        appiumServerManager.startAppiumServerWithCustomFlags();
    }

    @BeforeMethod
    public void setUp() {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(getProperty("device.name"))
                .setUdid(getProperty("device.udid"))
                .setApp(getProperty("app"))
                .setAppPackage(getProperty("app.package"))
                .setAppActivity(getProperty("app.activity"))
                .setNoReset(false)
                .setFullReset(true)
                .autoGrantPermissions();

        try {
            driver = new AndroidDriver(new URI(GlobalVariables.appiumLocalUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        filterPage = new FilterPage(driver);
        searchPage = new SearchPage(driver);
        dateSelectorPage = new DateSelectorPage(driver);
        roomsAndGuestsPage = new RoomsAndGuestsPage(driver);
        savedPropertyPage = new SavedPropertyPage(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    @AfterSuite (alwaysRun = true)
    public void stopAppiumServer() {
        appiumServerManager.stopAppiumServer();
    }
}
