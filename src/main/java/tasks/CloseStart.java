package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.MainPage;
import utils.ClickElement;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CloseStart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MainPage.ALLOW_GEOLOCATION, isEnabled()).forNoMoreThan(20).seconds(),
                Click.on(MainPage.ALLOW_GEOLOCATION)
        );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                WaitUntil.the(MainPage.POP_UP, isEnabled()).forNoMoreThan(20).seconds(),
                ClickElement.close(MainPage.POP_UP)
        );
    }

    public static CloseStart popUp() {
        return Tasks.instrumented(CloseStart.class);
    }
}
