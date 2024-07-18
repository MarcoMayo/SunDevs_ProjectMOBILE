package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.MainPage;
import userinterface.TheaterPage;
import utils.Scroll;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SelectTheater implements Task {

    private String theater;

    public SelectTheater(String theater) {
        this.theater = theater;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MainPage.THEATERS, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(MainPage.THEATERS),
                Click.on(TheaterPage.THEATER.of(theater)),
                WaitUntil.the(TheaterPage.MOVIES_TODAY.of(theater), isEnabled()).forNoMoreThan(10).seconds()
        );
    }

    public static SelectTheater byName(String theater){
        return Tasks.instrumented(SelectTheater.class, theater);
    }

}
