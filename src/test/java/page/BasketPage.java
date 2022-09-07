package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends HomePage{
    private final By ITEM_NAME_IN_BASKET = By.cssSelector(".cart_description .product-name");
    private final By ITEM_PRICE_IN_BASKET = By.cssSelector(".cart_unit .price");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getItemNameInBasket() {
        return driver.findElement(ITEM_NAME_IN_BASKET).getText();
    }

    public String getItemPriceInBasket() {
        return driver.findElement(ITEM_PRICE_IN_BASKET).getText();
    }
}