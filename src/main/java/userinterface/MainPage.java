package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class MainPage {
    public static final Target ALLOW_GEOLOCATION = Target.the("")
            .locatedBy("//android.widget.Button[@content-desc=\"PERMITIR OBTENER UBICACIÓN\"]");
    public static final Target LOG_IN_BUTTON = Target.the("")
            .locatedBy("//android.widget.Button");
    public static final Target EMAIL = Target.the("")
            .locatedBy("(//android.view.View[@content-desc=\"Iniciar Sesión\"]/../android.widget.EditText)[1]");
    public static final Target PASSWORD = Target.the("")
            .locatedBy("(//android.view.View[@content-desc=\"Iniciar Sesión\"]/../android.widget.EditText)[2]");
    public static final Target LOG_IN = Target.the("")
            .locatedBy("//android.widget.Button[@content-desc=\"INICIAR SESIÓN\"]");
    public static final Target USERNAME = Target.the("Username")
            .locatedBy("//android.view.View[@content-desc='Sundevs QA Automation BC']");
    public static final Target USERNAME_ICON = Target.the("Icon Username")
            .locatedBy("//android.view.View[@content-desc='SA']");
    public static final Target THEATERS = Target.the("Theater button")
            .locatedBy("//android.view.View[contains(@content-desc,'Teatros')]");
    public static final Target POP_UP = Target.the("PopUp init")
            .locatedBy("//android.widget.ImageView");
}

