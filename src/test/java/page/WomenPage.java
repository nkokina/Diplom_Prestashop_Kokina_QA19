package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WomenPage extends HomePage{

    private final By ICON_LOCATOR= By.cssSelector(".cat-name");

    public WomenPage(WebDriver driver) {
        super(driver);
    }
    public boolean isRemoveButtonDisplayed() {
        return driver.findElement(ICON_LOCATOR).isDisplayed();
    }
    public void waitForElementDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ICON_LOCATOR));
    }
}
