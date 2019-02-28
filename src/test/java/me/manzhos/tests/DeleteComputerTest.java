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
public class DeleteComputerTest extends TestBase {

    private final String DELETION_CONFIRMATION = "Done! Computer has been deleted";

    private AddComputerPage addComputerPage = new AddComputerPage();
    private AllComputersPage allComputersPage = new AllComputersPage();
    private EditComputerPage editComputerPage = new EditComputerPage();
    private String computerName = "'A computer to remove'";

    @BeforeMethod
    public void prepareComputerForRemoval() {
        allComputersPage.initializeComputerCreation();
        addComputerPage.populateNewComputerFields(computerName, "", "", "");
        addComputerPage.confirmComputerCreation();
    }

    @Test
    public void removeComputerTest() {
        allComputersPage.searchComputerByName(computerName);
        allComputersPage.openSelectedComputer(computerName);
        editComputerPage.deleteThisComputer();
        Assert.assertEquals(allComputersPage.getNotificationMessage(), DELETION_CONFIRMATION, "Removal wasn't successful");

        allComputersPage.searchComputerByName(computerName);
        Assert.assertTrue(allComputersPage.isZeroResult());
    }
}