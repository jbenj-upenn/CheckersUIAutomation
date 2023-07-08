package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckersGamePage extends BasePage {
    //**************    CHECKERS PAGE WEB ELEMENTS  ***************//
    @FindBy(xpath = "//div[@class='page']/h1[contains(text(), 'Checkers')]")
    WebElement titleCheckers;
    @FindBy(xpath = "//p[@id='message']")
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
    public List<WebElement> setAllPlayableSpaces(){
 //       for (WebElement space : listAllSpaces) {
//            System.out.println("Board Space: 'name' - " + space.getAttribute("name"));
//            System.out.println("Board Space: 'onclick' - " + space.getAttribute("onclick"));
//            System.out.println("Board Space: 'src' - " + space.getAttribute("src"));
 //       }
        return listAllSpaces;
    }
    public List<WebElement> readMyPieces(){
 //       for (WebElement myPiece : listMyPieces) {
//            System.out.println("My Piece: 'name' - " + myPiece.getAttribute("name"));
//            System.out.println("My Piece: 'onclick' - " + myPiece.getAttribute("onclick"));
//            System.out.println("My Piece: 'src' - " + myPiece.getAttribute("src"));
  //      }
        return listMyPieces;
    }
    public List<WebElement> readCPUPieces(){
 //       for (WebElement cpuPiece : listCPUPieces) {
//            System.out.println("CPU Piece: 'name' - " + cpuPiece.getAttribute("name"));
//            System.out.println("CPU Piece: 'onclick' - " + cpuPiece.getAttribute("onclick"));
//            System.out.println("CPU Piece: 'src' - " + cpuPiece.getAttribute("src"));
 //       }
        return listCPUPieces;
    }
    public List<WebElement> setClickableSpaces(){
        List<WebElement> allSpaces = setAllPlayableSpaces();

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
    public List<WebElement> setJumpable(){
        List<WebElement> jumpablePieces = readCPUPieces();
        List<WebElement> validJumpablePieces = new ArrayList<>();

        for(int i = 0; i < jumpablePieces.size(); i++){

            if(jumpablePieces.get(i).getAttribute("src").contains("me1.gif")){
                validJumpablePieces.add(jumpablePieces.get(i));
            }
        }
        return validJumpablePieces;
    }
    public List<String> determineFirstValidClickable(){
        List<WebElement> clickable1 = setFirstClickable();
        List<String> validFirstClickable = new ArrayList<>();

        for(WebElement element : clickable1){
            String onClickValue = element.getAttribute("onclick");
            String[] coordinates = onClickValue.split(",");
            String x = coordinates[0].substring(coordinates[0].indexOf("(") + 1).trim();
            String y = coordinates[1].substring(0, coordinates[1].indexOf(")")).trim();
            validFirstClickable.add(x + ", " + y);
//            System.out.println("FIRST SPACE valid clickable coordinates: x- " + x + "; y- " + y);
        }
//        System.out.println("Final list of first onClick values to click: " + validFirstClickable);

        return validFirstClickable;
    }
    public List<String> determineSecondValidClickable(){
        List<WebElement> clickable2 = setSecondClickable();

        List<String> validSecondClickable = new ArrayList<>();

        for(WebElement element : clickable2){
            String onClickValue = element.getAttribute("onclick");
            String[] coordinates = onClickValue.split(",");
            String x = coordinates[0].substring(coordinates[0].indexOf("(") + 1).trim();
            String y = coordinates[1].substring(0, coordinates[1].indexOf(")")).trim();
            validSecondClickable.add(x + ", " + y);
//            System.out.println("SECOND SPACE valid clickable coordinates: x- " + x + "; y- " + y);

        }
//        System.out.println("Final list of second onClick values to click: " + validSecondClickable);
        return validSecondClickable;
    }
    public List<String> determineValidJumpable(){
        List<WebElement> jumpable = setJumpable();

        List<String> validJumpable = new ArrayList<>();

        for(WebElement element : jumpable){
            String onClickValue = element.getAttribute("onclick");
            String[] coordinates = onClickValue.split(",");
            String x = coordinates[0].substring(coordinates[0].indexOf("(") + 1).trim();
            String y = coordinates[1].substring(0, coordinates[1].indexOf(")")).trim();
            validJumpable.add(x + ", " + y);
//            System.out.println("Valid jumpable coordinates: x- " + x + "; y- " + y);

        }
//        System.out.println("Final list of second onClick values to click: " + validSecondClickable);
        return validJumpable;
    }

    public void determineBestMove(){
        // ALL WEBELEMENTS TO CLICK AND COORDINATES RELATED

        // MINE**************************************
        List<WebElement> myPieces = setFirstClickable();
        List<String> myCoordinates = determineFirstValidClickable();
        List<Integer[]> myIntCoordinates = new ArrayList<>();
        System.out.println("My Pieces:");
        for(WebElement myPiece : myPieces){
            System.out.println(myPiece.getAttribute("name"));
        }
        System.out.println("My Coordinates:");
        for(String myCoordinate : myCoordinates){
            System.out.println(myCoordinate);
            Integer[] xy = new Integer[2];
            int x = Integer.parseInt(myCoordinate.substring(0, 1));
            int y = Integer.parseInt(myCoordinate.substring(3));
            xy[0] = x;
            xy[1] = y;
            myIntCoordinates.add(xy);
        }
        System.out.println("My Integer Coordinates Array List:");
        for(Integer[] coordinates : myIntCoordinates){
            System.out.println(Arrays.toString(coordinates));
        }

        // TARGET**************************************
        List<WebElement> targetSpaces = setSecondClickable();
        List<String> targetCoordinates = determineSecondValidClickable();
        List<Integer[]> targetIntCoordinates = new ArrayList<>();
        System.out.println("Target Spaces:");
        for(WebElement targetSpace : targetSpaces){
            System.out.println(targetSpace.getAttribute("name"));
        }
        System.out.println("Target Coordinates:");
        for(String targetCoordinate : targetCoordinates){
            System.out.println(targetCoordinate);
            Integer[] xy = new Integer[2];
            int x = Integer.parseInt(targetCoordinate.substring(0, 1));
            int y = Integer.parseInt(targetCoordinate.substring(3));
            xy[0] = x;
            xy[1] = y;
            targetIntCoordinates.add(xy);
        }
        System.out.println("Target Integer Coordinates Array List:");
        for(Integer[] coordinates : targetIntCoordinates){
            System.out.println(Arrays.toString(coordinates));
        }

        // CPU**************************************
        List<WebElement> cpuPieces = setJumpable();
        List<String> cpuCoordinates = determineValidJumpable();
        List<Integer[]> cpuIntCoordinates = new ArrayList<>();
        System.out.println("CPU Pieces:");
        for(WebElement cpuPiece : cpuPieces){
            System.out.println(cpuPiece.getAttribute("name"));
        }
        System.out.println("CPU Coordinates:");
        for(String cpuCoordinate : cpuCoordinates){
            System.out.println(cpuCoordinate);
            Integer[] xy = new Integer[2];
            int x = Integer.parseInt(cpuCoordinate.substring(0, 1));
            int y = Integer.parseInt(cpuCoordinate.substring(3));
            xy[0] = x;
            xy[1] = y;
            cpuIntCoordinates.add(xy);
        }
        System.out.println("Target Integer Coordinates Array List:");
        for(Integer[] coordinates : cpuIntCoordinates){
            System.out.println(Arrays.toString(coordinates));
        }

        // LOGIC FOR CHOOSING WHICH PIECE TO JUMP AND WHERE
        while(gameMessage.getText().equalsIgnoreCase("Select an orange piece to move.")
                || gameMessage.getText().equalsIgnoreCase("Make a move.")) {
            try{
            for (int i = 0; i < myIntCoordinates.size(); i++) {
                int myX = myIntCoordinates.get(i)[0];
                int myY = myIntCoordinates.get(i)[1];
                for (int j = 0; j < targetIntCoordinates.size(); j++) {
                    int targetX = targetIntCoordinates.get(j)[0];
                    int targetY = targetIntCoordinates.get(j)[1];
                    if (Math.abs(myX - targetX) <= 1 && targetY - myY == 1) {
                        // The conditions are satisfied, perform your desired logic here
                        // For example, print a message
                        System.out.println("Valid move: My piece at (" + myX + ", " + myY + ") can move to target position (" + targetX + ", " + targetY + ")");
                        String myName = "space" + String.valueOf(myX) + String.valueOf(myY);
                        String targetName = "space" + String.valueOf(targetX) + String.valueOf(targetY);
                        myPieces.get(i).click();
                        targetSpaces.get(j).click();
                    } else {
                        // The conditions are not satisfied, perform alternative logic here
                        // For example, print a message
                        System.out.println("Invalid move: My piece at (" + myX + ", " + myY + ") cannot move to target position (" + targetX + ", " + targetY + ")");
                    }
                }
                Thread.sleep(2500);
            }
            }catch(InterruptedException ie){
                System.out.println("Pause 2.5 seconds...");
            }
            // ******* END OF LOGIC IN FOR LOOP **** //
        }
        // ******* END OF LOGIC IN WHILE LOOP **** //
    }
}
