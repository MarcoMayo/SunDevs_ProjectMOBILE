package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.CloseStart;
import tasks.Login;
import userinterface.MainPage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class LoginStepDefinition {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("The user {string} is on the main page")
    public void theUserIsOnTheMainPage(String actor)  {
        theActorCalled(actor).attemptsTo(CloseStart.popUp());
    }
    @When("Enters credentials user {string} and password {string}")
    public void entersCredentialsUserAndPassword(String email, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.atCinemark(email, password));
    }
    @Then("the user can see the init page")
    public void theUserCanSeeTheInitPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MainPage.USERNAME_ICON,isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(MainPage.USERNAME_ICON),
                Ensure.that(MainPage.USERNAME).isDisplayed());
    }

    @After
    public void finish() {
        AppiumDriver appiumDriver = getProxiedDriver();
        appiumDriver.quit();
    }

}
