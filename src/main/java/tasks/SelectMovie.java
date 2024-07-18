package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.MoviePage;
import userinterface.TheaterPage;
import utils.RandomSeat;
import utils.Scroll;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyEnabled;

public class SelectMovie implements Task {

    private String movie;
    private String time;
    private String date;

    public SelectMovie(String movie, String time, String date) {
        this.movie = movie;
        this.time = time;
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TheaterPage.DAY_MOVIE.of(date)),
                Scroll.down(TheaterPage.TIME_MOVIE.of(movie, time)),
                Click.on(TheaterPage.TIME_MOVIE.of(movie, time))
        );

        actor.attemptsTo(
                WaitUntil.the(MoviePage.PLUS_TICKECT.of("2"), isEnabled()).forNoMoreThan(20).seconds(),
                Click.on(MoviePage.PLUS_TICKECT.of("1")),
                Click.on(MoviePage.PLUS_TICKECT.of("2")),
                Click.on(MoviePage.BUTTON_CONTINUE)
        );

        String seat = RandomSeat.number();
        System.out.println(seat);
        actor.attemptsTo(
                WaitUntil.the(MoviePage.LOADER_SEATS, isNotCurrentlyEnabled()).forNoMoreThan(50).seconds(),
                WaitUntil.the(MoviePage.SELECT_SEAT.of(seat), isEnabled()).forNoMoreThan(20).seconds(),
                Click.on(MoviePage.SELECT_SEAT.of(seat)),
                Click.on(MoviePage.BUTTON_CONTINUE),
                WaitUntil.the(MoviePage.CONCESSIONS, isEnabled()).forNoMoreThan(50).seconds(),
                Click.on(MoviePage.BUTTON_CONTINUE),
                Ensure.that(MoviePage.SHOPPINP_CART.of(movie)).isDisplayed(),
                Click.on(MoviePage.BUTTON_CONTINUE)
        );
    }

    public static SelectMovie byName(String movie, String time, String date) {
        return Tasks.instrumented(SelectMovie.class, movie, time, date);
    }

}
