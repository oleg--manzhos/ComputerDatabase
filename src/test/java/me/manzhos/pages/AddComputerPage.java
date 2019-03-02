package me.manzhos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class AddComputerPage {

    Logger log = LoggerFactory.getLogger(AddComputerPage.class);
    private By computerName = By.name("name");
    private By introducedDate = By.name("introduced");
    private By discontinuedDate = By.name("discontinued");
    private By company = By.name("company");
    private By createThisComputerBtn = By.cssSelector("input[type=submit]");
    private By cancelBtn = By.linkText("Cancel");
    private By errorComputerNameField = By.xpath("//div[@class='clearfix error']//label[@for='name']");
    private By errorIntroductionDateField = By.xpath("//div[@class='clearfix error']//label[@for='introduced']");
    private By errorDiscontinuedDateField = By.xpath("//div[@class='clearfix error']//label[@for='discontinued']");

    public void populateNewComputerFields(String newComputerName, String introduceDate, String discontinueDate, String companyName){
        $(computerName).sendKeys(newComputerName);
        log.info("Computer name: "+ newComputerName);
        $(introducedDate).sendKeys(introduceDate);
        log.info("Introduced date: "+ introduceDate);
        $(discontinuedDate).sendKeys(discontinueDate);
        log.info("Discontinued date: "+ introduceDate);
        if (!companyName.isEmpty()) {
            new Select($(company)).selectByVisibleText(companyName);
            log.info("Company name: "+ introduceDate);
        }
    }

    public void confirmComputerCreation(){
        $(createThisComputerBtn).click();
        log.info("Computer was created");
    }

    public void cancelComputerCreation(){
        $(cancelBtn).click();
        log.info("Computer creation was cancelled");
    }

    //Check that error appears for computer name field
    public boolean errorInFields(String field){
        switch(field) {
            case "Computer name":
                return $(errorComputerNameField).isDisplayed();
            case "Introduced date":
                return $(errorIntroductionDateField).isDisplayed();
            case "Discontinued date":
                return $(errorDiscontinuedDateField).isDisplayed();
            default:
                throw new IllegalArgumentException("Invalid field name was verified");
        }
    }

    //required for clearing fields  for Add a computer form during testing of batch invalid data
    public void clearAddComputerFormFields(){
        $(computerName).clear();
        $(introducedDate).clear();
        $(discontinuedDate).clear();
    }
}
