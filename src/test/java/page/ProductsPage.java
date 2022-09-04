package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends HomePage {

    private final By PRODUCT_NAME_SELECTOR = By.cssSelector("#center_column .product-name");
    private final By PRODUCT_PRICE_SELECTOR = By.cssSelector("#center_column .right-block [itemprop='price']");
    private final By PRODUCT_LINK = By.cssSelector("a[class$=_link]");
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
    public void openItemByName(String productsName) {
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
