package me.manzhos.tests;

import me.manzhos.DataProviders.IncorrectDatesDataProvider;
import me.manzhos.base.TestBase;
import me.manzhos.pages.AddComputerPage;
import me.manzhos.pages.AllComputersPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class AddingComputerUnhappyPathTest extends TestBase{

    private AddComputerPage addComputerPage = new AddComputerPage();
    private AllComputersPage allComputersPage = new AllComputersPage();

    @BeforeClass
    public void createComputerInit(){
        allComputersPage.initializeComputerCreation();
    }

    @Test
    public void checkComputerNameIsMandatoryFieldTest(){
        addComputerPage.populateNewComputerFields("",  "2015-11-23", "2023-07-05", "Evans & Sutherland");
        addComputerPage.confirmComputerCreation();

        Assert.assertTrue(addComputerPage.errorInFields("Computer name"));
        Assert.assertFalse(addComputerPage.errorInFields("Introduced date"));
    }

    @Test(dataProvider = "invalidIntroductionDates", dataProviderClass = IncorrectDatesDataProvider.class)
    public void checkIncorrectIntroductionDatesAreValidatedTest(String computerName, String introductionDate, String discontinuedDate){
        addComputerPage.clearAddComputerFormFields();
        addComputerPage.populateNewComputerFields(computerName,  introductionDate, discontinuedDate, "");
        addComputerPage.confirmComputerCreation();

        Assert.assertTrue(addComputerPage.errorInFields("Introduced date"));
    }

    @Test(dataProvider = "invalidDiscontinuingDates", dataProviderClass = IncorrectDatesDataProvider.class)
    public void checkIncorrectDiscontinuedDatesAreValidatedTest(String computerName, String introductionDate, String discontinuedDate){
        addComputerPage.clearAddComputerFormFields();
        addComputerPage.populateNewComputerFields(computerName,  introductionDate, discontinuedDate, "");
        addComputerPage.confirmComputerCreation();

        Assert.assertTrue(addComputerPage.errorInFields("Discontinued date"));
    }

    @Test
    public void checkBothDatesAreValidatedTest() {
        addComputerPage.populateNewComputerFields("Computer name", "1901-02-29", "2015-04-31", "");
        addComputerPage.confirmComputerCreation();

        Assert.assertTrue(addComputerPage.errorInFields("Introduced date"));
        Assert.assertTrue(addComputerPage.errorInFields("Discontinued date"));
    }
}
