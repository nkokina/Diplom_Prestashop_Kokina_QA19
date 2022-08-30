package page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class AuthenticationPage extends HomePage {

    public final By ICON_INFORMATION_LOCATOR = By.xpath("//*[@class='page-heading' and text()='Create an account']");
    public final By BUTTON_LOCATOR = By.cssSelector("#submitAccount");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isIconInformationDisplayed() {
        return driver.findElement(ICON_INFORMATION_LOCATOR).isDisplayed();
    }

    public void waitForElementDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ICON_INFORMATION_LOCATOR));
    }

    public void clickRegisterButton() {
        log.info("Pressing the registered button ");
        driver.findElement(BUTTON_LOCATOR).click();
    }
}
