package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class MoviePage {

    public static final Target PLUS_TICKECT = Target.the("Plus one tickect")
            .locatedBy("(//android.view.View[contains(@content-desc,'BISTRO') and contains(@content-desc,'3D')]/android.widget.Button)[{0}]");
    public static final Target BUTTON_CONTINUE = Target.the("Button continue")
            .locatedBy("//android.widget.Button[@content-desc='CONTINUAR']");
    public static final Target SELECT_SEAT = Target.the("Select seat")
            .locatedBy("//android.view.View[@content-desc='Pantalla']/following-sibling::android.view.View[1]/android.view.View/android.view.View[@index='{0}']");
    public static final Target CONCESSIONS = Target.the("Select concessions")
            .locatedBy("//android.view.View[contains(@content-desc,'Confitería')]");
    public static final Target LOADER_SEATS = Target.the("Loader seats")
            .locatedBy("//android.view.View[@content-desc='Cargando mapa de sillas']");
    public static final Target SHOPPINP_CART = Target.the("Shopping cart")
            .locatedBy("//android.view.View[contains(@content-desc,'{0}')]");

}
