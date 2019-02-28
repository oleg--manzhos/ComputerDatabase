package me.manzhos.DataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class IncorrectDatesDataProvider {

    @DataProvider(name = "invalidIntroductionDates")
    public static Object[][] introductionDateDataProvider() {
        return new Object[][]{
                {"Computer name!", "2015-02-29", "2015-06-17"},
                {"Computer name!", "2014-02-30", "2015-06-17"},
                {"Computer name!", "1936-04-31", "2015-06-17"},
                {"Computer name!", "2015-05-32", "2015-06-17"},
                {"Computer name!", "2000-00-00", "2015-06-17"},
                {"Computer name!", "1927-13-23", "2015-06-17"},
                {"Computer name!", "02-02-1999", "2015-06-17"},
                {"Computer name!", "asdfggh", "2015-06-17"},
                {"Computer name!", "20 Feb 2000", "2015-06-17"},
                {"Computer name!", "2016-07-24", "2015-06-17"},//assume that this test case should be failed as Discontinued date is greater than Introduced date
        };
    }

    @DataProvider(name = "invalidDiscontinuingDates")
    public static Object[][] discontinuingDatesDataProvider() {
        return new Object[][]{
                {"Computer name!", "1901-02-27", "2015-02-29"},
                {"Computer name!", "1901-02-27", "2014-02-30"},
                {"Computer name!", "1901-02-27", "2015-05-32"},
                {"Computer name!", "1901-02-27", "2000-00-00"},
                {"Computer name!", "1901-02-27", "1927-13-23"},
                {"Computer name!", "1901-02-27", "02-02-1999"},
                {"Computer name!", "1901-02-27", "asdfggh"},
                {"Computer name!", "1901-02-27", "20 Feb 2000"},
        };
    }
}