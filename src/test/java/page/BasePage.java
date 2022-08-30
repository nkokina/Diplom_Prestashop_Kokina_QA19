package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

//    public abstract void waitForPageLoaded();


//    public void waitForElementDisplayed(By locator) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//
//    public void waitForElementClicable(By locator) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }

//    public void jsClick(WebElement element) {
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", element);
//    }


}