package utils;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.List;
import java.util.stream.IntStream;

import static java.time.Duration.ZERO;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class Helpers {

    public enum Directions {
        UP,
        DOWN,
    }

    private final PointerInput FINGER = new PointerInput(TOUCH, "finger");

    public void swipeVertically(AndroidDriver driver, Directions direction) {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

        int endY;

        switch (direction) {
            case UP -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
            case DOWN -> endY = (int) (driver.manage().window().getSize().getWidth() * 0.2);
            default -> throw new IllegalArgumentException("Invalid direction selected" + direction);
        }

        Sequence swipeVertically = new Sequence(FINGER, 0);
        swipeVertically.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipeVertically.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipeVertically.addAction(FINGER.createPointerMove(ofSeconds(1), viewport(), startX, endY));
        swipeVertically.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipeVertically));
    }

    public void scrollTo(AndroidDriver driver, WebElement element, Directions direction, int swipeCount) {
        IntStream.range(0, swipeCount).forEach(obj -> {
            if (element.isDisplayed())
                swipeVertically(driver,direction);
        });
    }

}
