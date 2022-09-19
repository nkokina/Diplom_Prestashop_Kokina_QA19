package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ItemDetailsPage extends HomePage {
    protected final By ITEM_NAME = By.cssSelector("[itemprop='name']");
    private final By ITEM_PRICE = By.cssSelector("#our_price_display");
    private final By ADD_TO_CAR_ITEM_BUTTON = By.cssSelector(".buttons_bottom_block.no-print .exclusive");

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step("Pressing add to cart item button")
    public void clickAddToCartItemButton() {
        log.info("Pressing add to cart item button");
        driver.findElement(ADD_TO_CAR_ITEM_BUTTON).click();
    }

    public void waitForOpenItemDetailsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CAR_ITEM_BUTTON));
    }
}
