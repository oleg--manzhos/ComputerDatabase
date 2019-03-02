package me.manzhos.pages;

import me.manzhos.base.TestBase;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class AllComputersPage extends TestBase {

    Logger log = LoggerFactory.getLogger(AllComputersPage.class);
    private By filterField = By.name("f");
    private By filterByNameBtn = By.id("searchsubmit");
    private By addNewComputerBtn = By.cssSelector("a#add");
    private By computerNameSearchResult = By.cssSelector("td>a");
    private By introducedDateSearchResult = By.cssSelector("tr>td:nth-of-type(2)");
    private By discontinuedDateSearchResult = By.cssSelector("tr>td:nth-of-type(3");
    private By companyNameSearchResult = By.cssSelector("tr>td:nth-of-type(4");
    private By notificationBlock = By.cssSelector("div.alert-message.warning");
    private By nothingToDisplay = By.cssSelector("div.well>em");

    private final String ZERO_RESULT = "Nothing to display";

    //"Add a new computer" button is clicked
    public void initializeComputerCreation(){
        $(addNewComputerBtn).click();
        log.info("Add new computer button was clicked");
    }

    //Search for provided computer name
    public void searchComputerByName(String computerName){
        $(filterField).sendKeys(computerName);
        $(filterByNameBtn).click();
        log.info("Computer "+computerName+" was searched");
    }

    //Get computer name from the grid of results
    public String getComputerNameFromSearchResult(){
        return $(computerNameSearchResult).getText();
    }

    //Get introduced date from the grid of results
    public String getIntroducedDateFromSearchResults(){
        return $(introducedDateSearchResult).getText();
    }

    //Get discounting date from grid of results
    public String getDiscontinuedDateFromSearchResults(){
        return $(discontinuedDateSearchResult).getText();
    }

    //Get computer manufacturer from the grid of results
    public String getCompanyNameFromSearchResults(){
        return $(companyNameSearchResult).getText();
    }

    //message that appears after add form was submitted
    public String getNotificationMessage(){
        String notificationText;
        notificationText = $(notificationBlock).getText();
        log.info("Notification text is obtained");
        return notificationText;

    }

    //if search returns nothing, check this text
    public boolean isZeroResult(){
        return $(nothingToDisplay).getText().equals(ZERO_RESULT);
    }

    public void openSelectedComputer(String computerName){
        $(By.linkText(computerName)).click();
        log.info("Computer " +computerName+" was opened");
    }
}
