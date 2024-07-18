package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.MainPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Login implements Task {

    private String email;
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MainPage.LOG_IN_BUTTON,isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(MainPage.LOG_IN_BUTTON),
                Click.on(MainPage.EMAIL),
                Enter.theValue(email).into(MainPage.EMAIL),
                Click.on(MainPage.PASSWORD),
                Enter.theValue(password).into(MainPage.PASSWORD),
                Click.on(MainPage.LOG_IN));
    }

    public static Login atCinemark(String email, String password){
        return Tasks.instrumented(Login.class, email, password);
    }

}
