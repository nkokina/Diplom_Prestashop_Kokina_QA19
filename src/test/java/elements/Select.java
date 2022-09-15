package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class Select extends BaseElement {

    private final static String DATA_EL_LOCATOR = "#%s";
    private final static String SELECTOR_LOCATOR =
            "#%s [value='%s']";

    public Select(WebDriver driver, String label) {
        super(driver, label);
    }

    @Step("Setting selector value = {String.format(DATA_EL_LOCATOR, label)} to selector with locator = {value}")
    public void selectByVisibleText(String value) {
        WebElement element = driver.findElement(By.cssSelector(String.format(DATA_EL_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            log.debug(String.format("Setting selector value = %s to selector with locator = %s",
                    String.format(DATA_EL_LOCATOR, label), value));
            scrollIntoView(element);
            element.click();
            WebElement selectElement = driver.findElement(By.cssSelector(String.format(SELECTOR_LOCATOR, label, value)));
            scrollIntoView(selectElement);
            selectElement.click();

        }
    }
}
