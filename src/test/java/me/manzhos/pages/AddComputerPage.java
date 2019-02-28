package me.manzhos.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class AddComputerPage {

    private By computerName = By.name("name");
    private By introducedDate = By.name("introduced");
    private By discontinuedDate = By.name("discontinued");
    private By company = By.name("company");
    private By createThisComputerBtn = By.cssSelector("input[type=submit]");
    private By cancelBtn = By.linkText("Cancel");
    private By errorComputerNameField = By.xpath("//div[@class='clearfix error']//label");

    public void populateNewComputerFields(String newComputerName, String introduceDate, String discontinueDate, String companyName){
        $(computerName).sendKeys(newComputerName);
        $(introducedDate).sendKeys(introduceDate);
        $(discontinuedDate).sendKeys(discontinueDate);
        if (!companyName.isEmpty()) {
            Select companyNameDD = new Select($(company));
            companyNameDD.selectByVisibleText(companyName);
        }
    }

    public void confirmComputerCreation(){
        $(createThisComputerBtn).click();
    }

    public void cancelComputerCreation(){
        $(cancelBtn).click();
    }

    //Check that error appears for specified field
    public boolean errorFieldIsDisplayed(String field){
        return $(errorComputerNameField).getText().equals(field);
    }
}
