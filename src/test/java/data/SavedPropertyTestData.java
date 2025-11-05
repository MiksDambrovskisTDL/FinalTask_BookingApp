package data;

import org.testng.annotations.DataProvider;

public class SavedPropertyTestData {

    @DataProvider(name = "bookingDates")
    public Object[][] calendarData() {
        return new Object[][] {
                {"10 November 2025", "11 November 2025"},
                {"20 November 2025", "21 November 2025"},
                {"26 November 2025", "27 November 2025"}
        };
    }
}
