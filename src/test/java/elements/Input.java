package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class Input extends BaseElement {
    private final static String INPUT_LOCATOR = "#%s";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement inputElement = driver.findElement(By.cssSelector(String.format(INPUT_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            scrollIntoView(inputElement);
            log.debug("Setting input value = %s to input with locator = %s", String.format(INPUT_LOCATOR, label), value);
            inputElement.sendKeys(value);
        }
    }
}
