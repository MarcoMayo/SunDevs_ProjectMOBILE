package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.MoviePage;
import userinterface.PayProcessPage;
import utils.ClickElement;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ProcessPayment implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PayProcessPage.CHECK_PAYMENT, isEnabled()).forNoMoreThan(20).seconds(),
                Click.on(PayProcessPage.CHECK_PAYMENT),
                Click.on(PayProcessPage.CITY_FIELD_TX.of("")),
                Enter.theValue("Bogota").into(PayProcessPage.CITY_FIELD_TX.of("")),
                Click.on(PayProcessPage.EMAIL_FIELD_TX),
                Click.on(PayProcessPage.CITY_FIELD_TX.of("Bogota")),
                ClickElement.byPosition(PayProcessPage.SELECT_BOGOTA)
        );

        actor.attemptsTo(
                Click.on(MoviePage.BUTTON_CONTINUE),
                Click.on(PayProcessPage.DEBIT_CARD_SELECT),
                Click.on(PayProcessPage.NAME_FIELD_TX),
                Enter.theValue("PRUEBA TEST").into(PayProcessPage.NAME_FIELD_TX),
                Click.on(PayProcessPage.NUMBER_CARD_FIELD_TX),
                Enter.theValue("5282096712463427").into(PayProcessPage.NUMBER_CARD_FIELD_TX),
                Click.on(PayProcessPage.DATE_FIELD_TX),
                Enter.theValue("0527").into(PayProcessPage.DATE_FIELD_TX),
                Click.on(PayProcessPage.CVC_FIELD_TX),
                Enter.theValue("123").into(PayProcessPage.CVC_FIELD_TX)
        );
    }

    public static ProcessPayment ofMovie() {
        return Tasks.instrumented(ProcessPayment.class);
    }

}
