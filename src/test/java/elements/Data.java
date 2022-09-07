package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class Data extends BaseElement {

    private final  static String DATA_EL_LOCATOR = "#uniform-%s";
    private final static String SELECTOR_LOCATOR =
            "#%s [value='%s']";

    public Data(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String value) {
        WebElement element = driver.findElement(By.cssSelector(String.format(DATA_EL_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            log.debug("Setting selector value = %s to selector with locator = %s",
                    String.format(DATA_EL_LOCATOR, label), value);
            scrollIntoView(element);
          element.click();
          WebElement selectElement=driver.findElement(By.cssSelector(String.format(SELECTOR_LOCATOR, label, value)));
            scrollIntoView(selectElement);
            selectElement.click();

        }
    }
}
