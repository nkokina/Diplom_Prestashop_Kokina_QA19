package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemDetailsPage extends HomePage {
    protected final By ITEM_NAME = By.cssSelector("[itemprop='name']");
    private final By ITEM_PRICE = By.cssSelector("#our_price_display");
    private final By ADD_TO_CAR_ITEM_BUTTON = By.cssSelector("#add_to_cart");

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }
    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }
    @Step(" click Add To Cart Item Button")
    public void clickAddToCartItemButton() {
       driver.findElement(ADD_TO_CAR_ITEM_BUTTON).click();
    }
    public void waitForElementDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CAR_ITEM_BUTTON));
    }


}
