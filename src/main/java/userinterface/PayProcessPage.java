package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class PayProcessPage {

    public static final Target CHECK_PAYMENT = Target.the("Check payment")
            .locatedBy("//android.widget.EditText[@text='automationtestbc@yopmail.com']/following-sibling::android.view.View[1]");
    public static final Target DEBIT_CARD_SELECT = Target.the("Select debit card button")
            .locatedBy("//android.view.View[@content-desc='Tarjeta crédito/débito']");
    public static final Target NAME_FIELD_TX = Target.the("Field name")
            .locatedBy("(//android.view.View[@content-desc='Tarjeta crédito / débito']/../android.widget.EditText)[1]");
    public static final Target NUMBER_CARD_FIELD_TX = Target.the("Field card")
            .locatedBy("(//android.view.View[@content-desc='Tarjeta crédito / débito']/../android.widget.EditText)[2]");
    public static final Target DATE_FIELD_TX = Target.the("Field date")
            .locatedBy("(//android.view.View[@content-desc='Tarjeta crédito / débito']/../android.widget.EditText)[3]");
    public static final Target CVC_FIELD_TX = Target.the("Field cvc")
            .locatedBy("(//android.view.View[@content-desc='Tarjeta crédito / débito']/../android.widget.EditText)[4]");
    public static final Target CITY_FIELD_TX = Target.the("Field city")
            .locatedBy("//android.widget.EditText[@text='{0}']");
    public static final Target EMAIL_FIELD_TX = Target.the("Field email client")
            .locatedBy("//android.widget.EditText[@text='automationtestbc@yopmail.com']");
    public static final Target SELECT_BOGOTA = Target.the("Select city Bogota")
            .locatedBy("//android.view.View[@content-desc='BOGOTA D.C., BOGOTÁ']");
    public static final Target PAY_BUTTON = Target.the("Pay button")
            .locatedBy("//android.widget.Button[@content-desc='PAGAR']");
    public static final Target LOADER_ICON = Target.the("Loader")
            .locatedBy("//android.widget.ImageView");
    public static final Target QR = Target.the("QR")
            .locatedBy("//android.view.View[@content-desc='qr code']");

}
