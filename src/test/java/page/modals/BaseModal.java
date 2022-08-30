package page.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.BasePage;


public abstract class BaseModal extends BasePage {

    private final static By SAVE_BUTTON_LOCATOR = By.xpath("//*[@title='Save']");

    public BaseModal(WebDriver driver) {
        super(driver);
    }

//    @Override
//    public void waitForPageLoaded() {
//    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON_LOCATOR).click();
    }
}
