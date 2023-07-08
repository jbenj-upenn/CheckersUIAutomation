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
        checkersGamePage.setAllPlayableSpaces();
        }
    @And("user reads own orange pieces")
    public void user_reads_own_orange_piece() {
        checkersGamePage.readMyPieces();
    }
    @And("user reads CPU blue pieces")
    public void user_reads_cpu_blue_pieces() {
        checkersGamePage.readCPUPieces();
    }
    @Then("user reads first clickable")
    public void user_reads_first_clickable(){
        checkersGamePage.setFirstClickable();
    }
    @And("user reads second clickable")
    public void user_reads_second_clickable(){
        checkersGamePage.setSecondClickable();
    }
    @And("user determines first valid clickable")
    public void user_determines_first_valid_clickable() {
        checkersGamePage.determineFirstValidClickable();
    }
    @And("user determines second valid clickable")
    public void user_determines_second_valid_clickable(){
        checkersGamePage.determineSecondValidClickable();
    }
    @And("user determines valid jumpable pieces")
    public void user_determines_valid_jumpable_pieces(){
        checkersGamePage.determineValidJumpable();
    }
    @Then("user determines best move")
    public void user_determines_best_move(){
        checkersGamePage.determineBestMove();
    }


}
