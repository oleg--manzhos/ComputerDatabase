package me.manzhos.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class EditComputerPage {

    private Logger log = LoggerFactory.getLogger(AllComputersPage.class);
    private By saveComputerBtn = By.cssSelector("input.btn.primary");
    private By deleteThisComputerButton = By.cssSelector("input.btn.danger");
    private By cancelDataEditing = By.linkText("Cancel");

    public void cancelComputerEdition(){
        $(cancelDataEditing).click();
        log.info("Computer editing is canceled");
    }

    public void saveUpdatedData(){
        $(saveComputerBtn).click();
        log.info("Updated data was saved");
    }

    public void deleteThisComputer(){
        $(deleteThisComputerButton).click();
        log.info("Computer was deleted");
    }
}
