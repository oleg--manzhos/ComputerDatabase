package me.manzhos.tests;

import me.manzhos.base.TestBase;
import me.manzhos.pages.AddComputerPage;
import me.manzhos.pages.AllComputersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class AddingComputerUnhappyPathTest extends TestBase{

    private AddComputerPage addComputerPage = new AddComputerPage();
    private AllComputersPage allComputersPage = new AllComputersPage();

    @Test
    public void checkComputerNameIsMandatoryField(){
        allComputersPage.initializeComputerCreation();
        addComputerPage.populateNewComputerFields("",  "2015-11-23", "2023-07-05", "Evans & Sutherland");
        addComputerPage.confirmComputerCreation();

        Assert.assertTrue(addComputerPage.errorFieldIsDisplayed("Computer name"));
    }
}
