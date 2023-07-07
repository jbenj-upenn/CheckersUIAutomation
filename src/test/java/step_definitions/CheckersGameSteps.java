package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CheckersGamePage;

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
}
