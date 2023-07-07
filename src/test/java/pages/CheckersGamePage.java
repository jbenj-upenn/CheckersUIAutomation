package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckersGamePage extends BasePage {
    //**************    CHECKERS PAGE WEB ELEMENTS  ***************//
    @FindBy(xpath = "//div[@class='page']/h1[contains(text(), 'Checkers')]")
    WebElement titleCheckers;
    @FindBy(id = "message")
    WebElement gameMessage;


    //************      CHECKERS PAGE METHODS ********************//
    public boolean verifyCheckersGamePage(){
        return titleCheckers.isDisplayed();
    }
    public boolean verifyGameStartMessage(){
        return gameMessage.getText().equalsIgnoreCase("Select an orange piece to move.");
    }
}
