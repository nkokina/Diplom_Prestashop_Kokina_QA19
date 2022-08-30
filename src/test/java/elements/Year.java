package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class Year extends BaseElement {
    private final  static String YEAR_EL_LOCATOR = "#cuselFrame-%s";
    private final static String SCROLL_LOCATOR =
            ".cusel-scroll-pane [val='%s']";

    public Year(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String value) {
        WebElement element = driver.findElement(By.cssSelector(String.format(YEAR_EL_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            WebElement scrollElement=driver.findElement(By.cssSelector(String.format(SCROLL_LOCATOR,  value)));
            log.debug("Setting selector value = %s to selector with locator = %s",
                    String.format(YEAR_EL_LOCATOR, label), value);
            scrollIntoView(element);
            element.click();
//            waitForElementClicable((By) scrollElement);
            scrollIntoView(scrollElement);
            scrollElement.click();

        }
    }
}
