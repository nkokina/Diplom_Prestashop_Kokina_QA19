package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends HomePage {

    private final By SEARCH_ITEM = By.cssSelector(".page-heading.product-listing");
    private final By ERROR_MESSAGE = By.cssSelector(".alert.alert-warning");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void waitForSearchItemDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_ITEM));
    }

    public boolean isIconInformationDisplayed() {
        return driver.findElement(SEARCH_ITEM).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    public String getErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }


}
