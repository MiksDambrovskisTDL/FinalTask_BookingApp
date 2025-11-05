package tests;

import data.SavedPropertyTestData;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DriverSetup;

public class SavedPropertyTest extends DriverSetup {

    @Test(testName = "Saved property test", dataProviderClass = SavedPropertyTestData.class, dataProvider = "bookingDates")
    public void bookingSearchTest(String startDate, String endDate){

        loginPage.acceptCookies();
        Assert.assertTrue(loginPage.loginPageLoaded(), "Login page is not loaded");

        loginPage.closeLoginPage();
        homePage.closePopUp();
        Assert.assertTrue(homePage.homePageLoaded(), "Home page is not loaded");

        homePage.clickSearchDestinationField();
        Assert.assertTrue(searchPage.searchPageLoaded(), "Search page is not loaded");

        searchPage.enterSearchDestination("Skopje");
        Assert.assertTrue(searchPage.searchResultLoaded(), "Search Results are not loaded");

        searchPage.selectDestination();
        Assert.assertTrue(dateSelectorPage.dateSelectorPageLoaded(), "Date selector page is not displayed");

        dateSelectorPage.selectStartDate(startDate);
        dateSelectorPage.selectEndDate(endDate);
        dateSelectorPage.clickSelectDatesButton();
        Assert.assertTrue(homePage.homePageLoaded(), "Home page is not loaded");

        homePage.clickSelectRoomsAndGuests();
        Assert.assertTrue(roomsAndGuestsPage.roomsAndGuestsPageLoaded(), "Rooms and guests page is not loaded");

        roomsAndGuestsPage.addRoomsAndGuests();
        homePage.clickSearchButton();
        Assert.assertTrue(searchResultsPage.searchResultsLoaded(), "Search results page is not loaded");
        Assert.assertTrue(searchResultsPage.destinationIsVisible(), "Destination is not visible in the search box");
        Assert.assertTrue(searchResultsPage.datesAreVisible(), "Dates are not visible in the search box");

        searchResultsPage.clickFavouritePropertyButton();
        searchResultsPage.clickGoBackButton();
        Assert.assertTrue(homePage.homePageLoaded(), "Home page is not loaded");

        homePage.clickSavedButton();
        Assert.assertTrue(savedPropertyPage.savedPropertyPageLoaded(), "Saved property page is not loaded");
        Assert.assertTrue(savedPropertyPage.savedPropertyDisplayed(), "Saved property is not displayed");

    }
}
