package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class TheaterPage {

    public static final Target THEATER = Target.the("Select theater {0}")
            .locatedBy("//android.widget.ImageView[contains(@content-desc,'{0}')]");
    public static final Target MOVIES_TODAY = Target.the("Select movies for today")
            .locatedBy("//android.view.View[contains(@content-desc,'{0}')]");
    public static final Target MOVIE = Target.the("Movies {0}")
            .locatedBy("//android.view.View[contains(@content-desc,'{0}')]");
    public static final Target DAY_MOVIE = Target.the("Day {0}")
            .locatedBy("//android.view.View[contains(@content-desc,{0})]");//and contains(@content-desc,'Jul')]
    public static final Target TIME_MOVIE = Target.the("Time {0}")
            .locatedBy("//android.view.View[contains(@content-desc,'{0}')]/android.view.View[@content-desc='{1} PM']");

}
