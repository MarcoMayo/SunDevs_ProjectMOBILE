package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class Scroll implements Task {
    private final double start;
    private final double end;
    private final Target element;

    public Scroll(double start, double end, Target element) {
        this.start = start;
        this.end = end;
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Dimension size = getProxiedDriver().manage().window().getSize();
        int with = size.getWidth() / 2;
        int startPoint = (int) (size.getHeight() * start);
        int endPoint = (int) (size.getHeight() * end);

        int retries = 5;
        boolean found = element.isVisibleFor(actor);

        while (!found && retries > 0) {
            new TouchAction<>(getProxiedDriver())
                    .press(PointOption.point(with, startPoint))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(with, endPoint))
                    .release()
                    .perform();

            if (element.isVisibleFor(actor)) {
                found = true;
            } else {
                retries--;
            }
        }
    }

    public static Scroll right() {
        return instrumented(Scroll.class, 0.4, 0.5);
    }

    public static Scroll down(Target element) {
        return instrumented(Scroll.class, 0.6, 0.5, element);
    }
}

