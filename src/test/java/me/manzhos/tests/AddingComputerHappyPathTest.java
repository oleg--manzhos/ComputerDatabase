package me.manzhos.tests;

import com.codeborne.selenide.WebDriverRunner;
import me.manzhos.DataProviders.ComputerCreationDataProvider;
import me.manzhos.base.TestBase;
import me.manzhos.pages.AddComputerPage;
import me.manzhos.pages.AllComputersPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class AddingComputerHappyPathTest extends TestBase {

    private AddComputerPage addComputerPage = new AddComputerPage();
    private AllComputersPage allComputersPage = new AllComputersPage();

    @Test(dataProvider = "addComputer", dataProviderClass = ComputerCreationDataProvider.class)
    public void addComputerWithFieldsFromDataProviderTest(String computerName, String introductionDate, String discontinuedDate,
                                            String company, String expectedComputerName, String expectedIntroductionDate,
                                            String expectedDiscontinuedDate, String expectedCompanyName){
        allComputersPage.initializeComputerCreation();
        addComputerPage.populateNewComputerFields(computerName, introductionDate, discontinuedDate, company);
        addComputerPage.confirmComputerCreation();
        Assert.assertEquals(allComputersPage.getNotificationMessage(), "Done! Computer " + computerName + " has been created", "Another computer name was displayed");

        allComputersPage.searchComputerByName(computerName);
        Assert.assertEquals(allComputersPage.getComputerNameFromSearchResult(), expectedComputerName, "Another computer name was returned");
        Assert.assertEquals(allComputersPage.getIntroducedDateFromSearchResults(), expectedIntroductionDate, "Another introduced date was returned");
        Assert.assertEquals(allComputersPage.getDiscontinuedDateFromSearchResults(), expectedDiscontinuedDate, "Another discontinued date was returned");
        Assert.assertEquals(allComputersPage.getCompanyNameFromSearchResults(), expectedCompanyName, "Another company name is returned");
    }

    @Test
    public void checkCancelButtonDoesntCreateNewRecordTest() {
        String computerName = "Another new Computer%";
        addComputerPage.populateNewComputerFields(computerName,"", "", "");
        addComputerPage.cancelComputerCreation();

        allComputersPage.searchComputerByName(computerName);
        Assert.assertTrue(addComputerPage.errorInFields("Introduced date"));
        Assert.assertTrue(addComputerPage.errorInFields("Discontinued date"));
    }

}
