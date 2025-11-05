package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DriverSetup;

public class BookingSearchTest extends DriverSetup {

    @Test(testName = "Search event test")
    public void bookingSearchTest(){


        loginPage.acceptCookies();
        Assert.assertTrue(loginPage.loginPageLoaded(), "Login page is not loaded");

        loginPage.closeLoginPage();
        homePage.closePopUp();
        Assert.assertTrue(homePage.homePageLoaded(), "Home page is not loaded");

        homePage.selectCountryCard();
        Assert.assertTrue(searchResultsPage.searchResultsLoaded(), "Search results page is not loaded");
        Assert.assertEquals(searchResultsPage.getSearchBoxDestination(), "Riga");
        Assert.assertTrue(searchResultsPage.firstSearchResultLoaded(), "Search results are not displayed");

        searchResultsPage.clickFilterButton();
        Assert.assertTrue(filterPage.filterPageLoaded(), "Filter page is not loaded");

        filterPage.clickBreakfastIncludedFilter();
        filterPage.clickFreeParkingFilter();
        filterPage.clickShowResultsButton();
        Assert.assertTrue(searchResultsPage.firstSearchResultLoaded(), "Search results are not displayed");

    }
}
