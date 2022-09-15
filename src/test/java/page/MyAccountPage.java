package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyAccountPage extends HomePage {

    private final By TEXT_LOCATOR = By.cssSelector(".info-account");
    private final By HOME_BUTTON = By.cssSelector("[title='Home']");

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

}