package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class ProductsPage extends HomePage {

    private final By PRODUCT_NAME_SELECTOR = By.cssSelector("#center_column .product-name");
    private final By PRODUCT_PRICE_SELECTOR = By.cssSelector("#center_column .right-block [itemprop='price']");
    private final By PRODUCT_LINK = By.cssSelector(".right-block .product-name");
    private final String PRODUCT_CONTAINER_LOCATOR
            = "//*[@class='product_img_link' and @title='%s']/ancestor::div[@class='product-container']";
    private final String PRODUCT_CONTAINER_LOCATOR_PRICE
            = "//span[@class='price product-price' and contains(text(),'%s ')] /ancestor::div[@class='product-container']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getProductContainerByName(String productsName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_CONTAINER_LOCATOR, productsName)));
    }

    @Step("product selection productsName = {productsName}, clicking on it")
    public void openItemByName(String productsName) {
        log.info(String.format("product selection %s, clicking on it.", productsName));
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(PRODUCT_LINK).click();
    }

    public boolean getProductName(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        return productContainer.findElement(PRODUCT_NAME_SELECTOR).isDisplayed();
    }

    private WebElement getProductContainerByPrice(String productsPrice) {
        return driver.findElement(By.xpath(String.format(PRODUCT_CONTAINER_LOCATOR_PRICE, productsPrice)));
    }

    public boolean getProductPrice(String productsPrice) {
        WebElement productContainer = getProductContainerByPrice(productsPrice);
        return productContainer.findElement(PRODUCT_PRICE_SELECTOR).isDisplayed();
    }
}
