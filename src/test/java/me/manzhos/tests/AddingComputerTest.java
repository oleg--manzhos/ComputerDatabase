package me.manzhos.tests;

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
public class AddingComputerTest extends TestBase {

    private AddComputerPage addComputerPage = new AddComputerPage();
    private AllComputersPage allComputersPage = new AllComputersPage();
    private final String EMPTY_VALUE = "-";

    @BeforeClass
    public void setPreconditions(){
        open(getURL());
    }

    @Test
    public void addComputerWithNameOnly(){
        String computerName = "My new computer!";
        allComputersPage.initializeComputerCreation();
        addComputerPage.populateNewComputerFields(computerName, "", "", "");
        addComputerPage.confirmComputerCreation();
        allComputersPage.searchComputerByName(computerName);

        Assert.assertEquals(allComputersPage.getComputerNameFromSearchResult(), computerName, "Another computer name was returned");
        Assert.assertEquals(allComputersPage.getIntroducedDateFromSearchResults(), EMPTY_VALUE, "Another introduced date was returned");
        Assert.assertEquals(allComputersPage.getDiscontinuedDateFromSearchResults(), EMPTY_VALUE, "Another discontinued date was returned");
        Assert.assertEquals(allComputersPage.getCompanyNameFromSearchResults(), EMPTY_VALUE, "Another company name is returned");
    }
}
