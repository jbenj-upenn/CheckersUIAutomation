package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckersGamePage extends BasePage {
    //**************    CHECKERS PAGE WEB ELEMENTS  ***************//
    @FindBy(xpath = "//div[@class='page']/h1[contains(text(), 'Checkers')]")
    WebElement titleCheckers;
    @FindBy(id = "message")
    WebElement gameMessage;
    @FindBy(xpath = "//div[@class='line']/img")
    List<WebElement> listAllSpaces;
    @FindBy(xpath = "//div[@class='line']/img[@src='me1.gif']")
    List<WebElement> listCPUPieces;
    @FindBy(xpath = "//div[@class='line']/img[@src='you1.gif']")
    List<WebElement> listMyPieces;


    //************      CHECKERS PAGE METHODS ********************//
    public boolean verifyCheckersGamePage(){
        return titleCheckers.isDisplayed();
    }
    public boolean verifyGameStartMessage(){
        return gameMessage.getText().equalsIgnoreCase("Select an orange piece to move.");
    }
    public List<WebElement> readAllSpaces(){
        return listAllSpaces;
    }
    public List<WebElement> readMyPieces(){
        return listMyPieces;
    }
    public List<WebElement> readCPUPieces(){
        return listCPUPieces;
    }
    public List<WebElement> setClickableSpaces(){
        List<WebElement> allSpaces = readAllSpaces();

        List<WebElement> clickableSpaces = new ArrayList<>();

        for(int i = 0; i < allSpaces.size(); i++){

            if(allSpaces.get(i).getAttribute("src").contains("gray.gif") ||
                allSpaces.get(i).getAttribute("src").contains("you1")){

                clickableSpaces.add(allSpaces.get(i));
            }
        }

        return clickableSpaces;
    }

    public List<WebElement> setFirstClickable(){
        List<WebElement> clickableSpaces = setClickableSpaces();
        List<WebElement> firstClickable = new ArrayList<>();

        for(int i = 0; i < clickableSpaces.size(); i++){

            if(clickableSpaces.get(i).getAttribute("src").contains("you1")){
                firstClickable.add(clickableSpaces.get(i));
            }
        }
        return firstClickable;
    }

    public List<WebElement> setSecondClickable(){
        List<WebElement> clickableSpaces = setClickableSpaces();
        List<WebElement> secondClickable = new ArrayList<>();

        for(int i = 0; i < clickableSpaces.size(); i++){

            if(clickableSpaces.get(i).getAttribute("src").contains("gray.gif")){
                secondClickable.add(clickableSpaces.get(i));
            }
        }
        return secondClickable;
    }


}
