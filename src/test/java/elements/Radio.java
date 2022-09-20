package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class Radio extends BaseElement {

    private final static String RADIO_EL_LOCATOR = "//label[text()='%s']";
    private final static String RADIO_LOCATOR = "#id_gender%s";

    public Radio(WebDriver driver, String label) {
        super(driver, label);
    }

    @Step("Setting selector value = {String.format(RADIO_LOCATOR, label)} to selector with locator = {value}")
    public void setValue(String value) {
        WebElement inputElement = driver.findElement(By.xpath(String.format(RADIO_EL_LOCATOR, label)));
        if (Objects.nonNull(value)) {
            log.debug(String.format("Setting radio value = %s to radio with locator = %s", String.format(RADIO_LOCATOR, label), value));
            scrollIntoView(inputElement);
            driver.findElement(By.cssSelector(String.format(RADIO_LOCATOR, value))).click();
        }
    }
}
