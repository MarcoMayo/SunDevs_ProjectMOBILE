package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Rectangle;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class ClickElement implements Task {

    private Target element;
    private Double x_init;
    private Double y_init;

    public ClickElement(Target element, Double x_init, Double y_init) {
        this.element = element;
        this.x_init = x_init;
        this.y_init = y_init;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Rectangle rect = element.resolveFor(actor).getRect();
        int x = rect.getX();
        int y = rect.getY();
        int width = rect.getWidth();
        int height = rect.getHeight();

        int X_POS = (int) (x + (width*x_init));
        int Y_POS = (int) (y + (height*y_init));

        System.out.println("X: "+X_POS + " Y: " + Y_POS);


        new TouchAction<>(getProxiedDriver())
                .tap(PointOption.point(X_POS, Y_POS))
                .perform();
    }

    public static ClickElement byPosition(Target element) {
        return Tasks.instrumented(ClickElement.class, element, 0.1, 0.5);
    }
    public static ClickElement close(Target element) {
        return Tasks.instrumented(ClickElement.class, element, 0.955, 0.065);
    }

}
