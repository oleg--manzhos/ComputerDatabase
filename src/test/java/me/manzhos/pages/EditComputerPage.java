package me.manzhos.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by omanzhos on 2/28/2019.
 */
public class EditComputerPage {

    private By saveComputerBtn = By.cssSelector("input.btn.primary");
    private By deleteThisComputerButton = By.cssSelector("input.btn.danger");
    private By cancelDataEditing = By.linkText("Cancel");

    public void cancelComputerEdition(){
        $(cancelDataEditing).click();
    }

    public void saveUpdatedData(){
        $(saveComputerBtn).click();
    }

    public void deleteThisComputer(){
        $(deleteThisComputerButton).click();
    }
}
