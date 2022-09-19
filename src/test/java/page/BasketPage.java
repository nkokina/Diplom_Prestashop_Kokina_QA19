package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class BasketPage extends HomePage {
    private final By ITEM_NAME_IN_BASKET = By.cssSelector(".cart_description .product-name");
    private final By ITEM_PRICE_IN_BASKET = By.cssSelector(".cart_unit .price");
    private final By DELETE_ITEM = By.cssSelector(".cart_quantity_delete");
    private final By TEXT_LOCATOR = By.cssSelector(".alert.alert-warning");
    private final By PROCEED_CHECKOUT_LOCATOR = By.cssSelector("[title='Proceed to checkout']");
    private final By PROCEED_ADDRESS_LOCATOR = By.cssSelector("[name='processAddress']");
    private final By PROCEED_CARRIER_LOCATOR = By.cssSelector("[name='processCarrier']");
    private final By ADDRESS_LOCATOR = By.cssSelector(".box .page-subheading");
    private final By ERROR_MESSAGE = By.cssSelector(".fancybox-error");
    private final By TERMS_OF_SERVICE_LOCATOR = By.cssSelector("#cgv");
    private final By PAYMENT_LOCATOR = By.cssSelector(".alert.alert-warning");
    private final By SAVE_BUTTON = By.cssSelector("[name='submitAddress']");
    private final By CLOSE_MESSAGE = By.cssSelector(".fancybox-item.fancybox-close");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getItemNameInBasket() {
        return driver.findElement(ITEM_NAME_IN_BASKET).getText();
    }

    public String getItemPriceInBasket() {
        return driver.findElement(ITEM_PRICE_IN_BASKET).getText();
    }

    @Step("Clicking a to remove an item from the cart button")
    public void clickDeleteItemButton() {
        log.info("Clicking a to remove an item from the cart button");
        driver.findElement(DELETE_ITEM).click();
    }

    @Step("Clicking a to close error message button")
    public void clickCloseMessageButton() {
        log.info("Clicking a to close error message button");
        driver.findElement(CLOSE_MESSAGE).click();
    }

    @Step("Clicking a to remove an item from the cart button")
    public void clickProceedToCheckout() {
        log.info("Clicking a button to remove an item from the cart");
        driver.findElement(PROCEED_CHECKOUT_LOCATOR).click();
    }

    @Step("Clicking a to proceed addresses button")
    public void clickProceedAddresses() {
        log.info("Clicking a button to proceed addresses");
        driver.findElement(PROCEED_ADDRESS_LOCATOR).click();
    }

    @Step("Clicking a to proceed carrier button")
    public void clickProceedCarrier() {
        log.info("Clicking a to proceed carrier button");
        driver.findElement(PROCEED_CARRIER_LOCATOR).click();
    }

    @Step("Clicking a to terms of service button")
    public void clickTermsOfService() {
        log.info("Clicking a button to terms of service");
        driver.findElement(TERMS_OF_SERVICE_LOCATOR).click();
    }

    @Step("Clicking a button to save addresses")
    public void clickSaveAddresses() {
        log.info("Clicking a button to save addresses");
        driver.findElement(SAVE_BUTTON).click();
    }

    public boolean isIconInformationDisplayed() {
        return driver.findElement(TEXT_LOCATOR).isDisplayed();
    }

    public void waitForProceedAddressesDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADDRESS_LOCATOR));
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    public String getErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public boolean isMessageDisplayed() {
        return driver.findElement(PAYMENT_LOCATOR).isDisplayed();
    }
}