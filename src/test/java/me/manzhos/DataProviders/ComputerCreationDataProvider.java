package me.manzhos.DataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class ComputerCreationDataProvider {

    private static final String EMPTY_VALUE = "-";

    @DataProvider(name = "addComputer")
    public static Object[][] powerDataProvider() {
        return new Object[][]{
                {"My new computer!", "", "", "", "My new computer!", EMPTY_VALUE, EMPTY_VALUE, EMPTY_VALUE},
                {"AA# 12 Qwerty 3 Gb", "1963-02-25", "", "", "AA# 12 Qwerty 3 Gb", "25 Feb 1963", EMPTY_VALUE, EMPTY_VALUE},
                {"HP G0512 GTH", "2000-02-28", "2015-08-03", "", "HP G0512 GTH", "28 Feb 2000", "03 Aug 2015", EMPTY_VALUE},
                {"C@dd XPF 3", "2010-12-05", "2020-01-03", "Evans & Sutherland", "C@dd XPF 3", "05 Dec 2010", "03 Jan 2020", "Evans & Sutherland"}
        };
    }
}