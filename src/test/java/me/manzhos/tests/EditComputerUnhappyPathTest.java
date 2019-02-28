package me.manzhos.tests;

import me.manzhos.base.TestBase;
import me.manzhos.pages.AddComputerPage;
import me.manzhos.pages.AllComputersPage;
import me.manzhos.pages.EditComputerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class EditComputerUnhappyPathTest extends TestBase {

    private AddComputerPage addComputerPage = new AddComputerPage();
    private AllComputersPage allComputersPage = new AllComputersPage();
    private EditComputerPage editComputerPage = new EditComputerPage();
    private String computerName = "A computer again #34";

    @BeforeMethod
    public void createComputerForEditing(){
        allComputersPage.initializeComputerCreation();
        addComputerPage.populateNewComputerFields(computerName,"","","");
        addComputerPage.confirmComputerCreation();
        allComputersPage.searchComputerByName(computerName);
        allComputersPage.openSelectedComputer(computerName);
        addComputerPage.clearAddComputerFormFields();
    }

    @Test
    public void cancelEditingExistingComputerDataTest() {
        String newCompanyName = "Micro Instrumentation and Telemetry Systems";
        addComputerPage.populateNewComputerFields("", "1989-03-08",
                "1990-04-10", newCompanyName);
        editComputerPage.saveUpdatedData();
        editComputerPage.cancelComputerEdition();
        allComputersPage.searchComputerByName(computerName);

        Assert.assertEquals(allComputersPage.getComputerNameFromSearchResult(), computerName, "Another computer name was returned");
        Assert.assertEquals(allComputersPage.getIntroducedDateFromSearchResults(), "-", "Another introduced date was returned");
        Assert.assertEquals(allComputersPage.getDiscontinuedDateFromSearchResults(), "-", "Another discontinued date was returned");
        Assert.assertEquals(allComputersPage.getCompanyNameFromSearchResults(), "-", "Another company name is returned");
    }
}
