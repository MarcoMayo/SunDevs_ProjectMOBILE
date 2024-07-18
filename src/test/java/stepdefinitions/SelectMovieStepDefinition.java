package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.*;
import userinterface.PayProcessPage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
public class SelectMovieStepDefinition {

    @Given("The user {string} Login with user {string} and password {string}")
    public void theUserLoginWithUserAndPassword(String actor, String email, String password) {
        theActorCalled(actor).attemptsTo(CloseStart.popUp());
        theActorInTheSpotlight().attemptsTo(Login.atCinemark(email, password));
    }

    @Given("The user selects a theater {string}")
    public void theUserSelectsATheater(String theater) {
        theActorInTheSpotlight().attemptsTo(SelectTheater.byName(theater));
    }

    @When("The user selects movie {string} at {string} the day {string}")
    public void theUserSelectsMovieAtTheDay(String movie, String time, String date) {

        theActorInTheSpotlight().attemptsTo(
                SelectMovie.byName(movie, time, date),
                ProcessPayment.ofMovie()
        );
        theActorInTheSpotlight().attemptsTo(
                Click.on(PayProcessPage.PAY_BUTTON)
        );

    }

    @Then("The user can see the showtimes for the selected movie and theater")
    public void theUserCanSeeTheShowtimesForTheSelectedMovieAndTheater() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PayProcessPage.QR, isEnabled()).forNoMoreThan(120).seconds(),
                Ensure.that(PayProcessPage.QR).isDisplayed()
        );
    }

}
