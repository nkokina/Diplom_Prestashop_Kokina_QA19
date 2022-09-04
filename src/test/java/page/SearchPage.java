package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends HomePage{

    private  By TEXT_LOCATOR = By.cssSelector(".page-heading.product-listing");
    private By SEARCH_ITEM=By.cssSelector(".page-heading.product-listing");
    private By ERROR_MESSAGE=By.cssSelector(".alert.alert-warning");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void waitForElementDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_LOCATOR));
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