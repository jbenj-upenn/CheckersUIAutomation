package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CheckersGamePage;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class CheckersGameSteps {
    CheckersGamePage checkersGamePage = new CheckersGamePage();

    @Given("user is on the Checkers game page")
    public void user_is_on_the_checkers_game_page() {
        Assert.assertTrue("This is not the Checkers game page.",
                checkersGamePage.verifyCheckersGamePage());
    }
    @Then("verify Checkers is set to new game")
    public void verify_checkers_is_set_to_new_game(){
        Assert.assertTrue("The game is not set up to begin.",
                checkersGamePage.verifyGameStartMessage());
    }
    @Then("user obtains all board spaces and pieces")
    public void user_obtains_all_board_spaces_and_pieces() {
        List<WebElement> allSpaces = checkersGamePage.readAllSpaces();
        for (WebElement space : allSpaces) {
            System.out.println("Board Space: 'name' - " + space.getAttribute("name"));
            System.out.println("Board Space: 'onclick' - " + space.getAttribute("onclick"));
            System.out.println("Board Space: 'src' - " + space.getAttribute("src"));
        }
    }
    @And("user reads own orange pieces")
    public void user_reads_own_orange_piece() {
        List<WebElement> myPieces = checkersGamePage.readMyPieces();
        for (WebElement myPiece : myPieces) {
            System.out.println("My Piece: 'name' - " + myPiece.getAttribute("name"));
            System.out.println("My Piece: 'onclick' - " + myPiece.getAttribute("onclick"));
            System.out.println("My Piece: 'src' - " + myPiece.getAttribute("src"));
        }
    }
    @And("user reads CPU blue pieces")
    public void user_reads_cpu_blue_pieces() {
        List<WebElement> cpuPieces = checkersGamePage.readCPUPieces();
        for (WebElement cpuPiece : cpuPieces) {
            System.out.println("CPU Piece: 'name' - " + cpuPiece.getAttribute("name"));
            System.out.println("CPU Piece: 'onclick' - " + cpuPiece.getAttribute("onclick"));
            System.out.println("CPU Piece: 'src' - " + cpuPiece.getAttribute("src"));
        }
    }
    @Then("user reads first clickable")
    public void user_reads_first_clickable(){
        List<WebElement> firstClickable = checkersGamePage.setFirstClickable();

        for(WebElement clickable : firstClickable) {
            System.out.println("Click First: onclick- " + clickable.getAttribute("onclick")
            + "\n\tname- " + clickable.getAttribute("src"));
        }
    }
    @And("user reads second clickable")
    public void user_reads_second_clickable(){
        List<WebElement> secondClickable = checkersGamePage.setSecondClickable();

        for(WebElement clickable : secondClickable) {
            System.out.println("Click second: onclick- " + clickable.getAttribute("onclick")
                    + "\n\tname- " + clickable.getAttribute("src"));
        }
    }


}
