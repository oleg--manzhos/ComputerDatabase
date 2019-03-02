package me.manzhos.tests;

import me.manzhos.base.TestBase;
import me.manzhos.pages.AddComputerPage;
import me.manzhos.pages.AllComputersPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class EditComputerHappyPathTest extends TestBase {

    private Logger log = LoggerFactory.getLogger(EditComputerHappyPathTest.class);
    private AddComputerPage addComputerPage = new AddComputerPage();
    private AllComputersPage allComputersPage = new AllComputersPage();

    @BeforeMethod
    public void createComputerForEditing(){
        log.info("-------"+getClass().getName()+"--------");
        String computerName = "@A computer again@";
        allComputersPage.initializeComputerCreation();
        addComputerPage.populateNewComputerFields(computerName,"","","");
        addComputerPage.confirmComputerCreation();
        allComputersPage.searchComputerByName(computerName);
        allComputersPage.openSelectedComputer(computerName);
        addComputerPage.clearAddComputerFormFields();
    }

    @Test
    public void editComputerByPopulatedAllFieldsTest() {
        String newComputerName = "Updated computer^";
        String newCompanyName = "Micro Instrumentation and Telemetry Systems";
        addComputerPage.populateNewComputerFields(newComputerName, "1989-03-08",
                "1990-04-10", newCompanyName);
        addComputerPage.confirmComputerCreation();
        Assert.assertEquals(allComputersPage.getNotificationMessage(), "Done! Computer " + newComputerName + " has been updated", "Another computer name was displayed");

        allComputersPage.searchComputerByName(newComputerName);
        Assert.assertEquals(allComputersPage.getComputerNameFromSearchResult(), newComputerName, "Another computer name was returned");
        Assert.assertEquals(allComputersPage.getIntroducedDateFromSearchResults(), "08 Mar 1989", "Another introduced date was returned");
        Assert.assertEquals(allComputersPage.getDiscontinuedDateFromSearchResults(), "10 Apr 1990", "Another discontinued date was returned");
        Assert.assertEquals(allComputersPage.getCompanyNameFromSearchResults(), newCompanyName, "Another company name is returned");
        log.info("--------");
    }
}
