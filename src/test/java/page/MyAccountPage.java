package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class MyAccountPage extends HomePage {

    private final By TEXT_LOCATOR = By.cssSelector(".info-account");
    private final By HOME_BUTTON = By.cssSelector("[title='Home']");
    private final By ADDRESSES_LOCATOR = By.cssSelector("[title='Addresses']");
    private final By DELETE_ADDRESSES = By.cssSelector("[title='Delete']");
    private final By ALERT_LOCATOR = By.cssSelector(".alert.alert-warning");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMessageDisplayed() {
        return driver.findElement(TEXT_LOCATOR).isDisplayed();
    }

    @Step("Pressing the home button")
    public void clickHomeButton() {
        log.info("Pressing the home button");
        driver.findElement(HOME_BUTTON).click();
    }

    public void clickAddressesButton() {
        log.info("Pressing the home button");
        driver.findElement(ADDRESSES_LOCATOR).click();
    }

    public void clickDeleteAddressesButton() {
        log.info("Pressing the delete addresses button");
        driver.findElement(DELETE_ADDRESSES).click();
        driver.switchTo().alert().accept();
    }

    public void waitForDeleteAddresses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_LOCATOR));
    }
}