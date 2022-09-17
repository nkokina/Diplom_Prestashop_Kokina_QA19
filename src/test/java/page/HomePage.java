package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

@Log4j2
public abstract class HomePage extends BasePage {
    protected static String URL = PropertyReader.getProperty("prestashop.base_url");
    protected By LOGIN_PAGE_LOCATOR = By.cssSelector("a.login");
    protected By SEARCH_LOCATOR = By.cssSelector("#search_query_top");
    protected By WOMEN_BUTTON = By.cssSelector(".sf-with-ul[title='Women']");
    protected By SHOPPING_CART = By.xpath("//div[@class='shopping_cart']/./a");
    protected By CLOSED_LOCATOR = By.cssSelector("a.logout");
    protected By MY_ACCOUNT_LOCATOR = By.cssSelector(".account");
    protected By WAIT_ITEM_CART = By.cssSelector(".ajax_cart_product_txt.unvisible[style = 'display: inline;']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Pressing the login button")
    public void clickLoginButton() {
        log.info("Pressing the login button");
        driver.findElement(LOGIN_PAGE_LOCATOR).click();
    }

    @Step("Pressing the My Account button")
    public void clickMyAccountButton() {
        log.info("Pressing the login button");
        driver.findElement(MY_ACCOUNT_LOCATOR).click();
    }

    @Step("Entering a product in the search bar")
    public void searchItemToText(String item) {
        log.info("Entering a product in the search bar");
        WebElement search = driver.findElement(SEARCH_LOCATOR);
        search.sendKeys(item);
        search.sendKeys(Keys.ENTER);
    }

    @Step("Pressing the women button")
    public void clickWomenButton() {
        log.info("Pressing the women button");
        driver.findElement(WOMEN_BUTTON).click();
    }

    public void open() {
        driver.get(URL);
    }

    @Step("Pressing on the cart button")
    public void clickingOnTheShoppingCart() {
        log.info("Pressing on the cart button");
        driver.findElement(SHOPPING_CART).click();
    }

    @Step("pressing the logout button")
    public void clickClosedLoginButton() {
        log.info("pressing the logout button");
        driver.findElement(CLOSED_LOCATOR).click();
    }

    public void waitForItemCartDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(WAIT_ITEM_CART));
    }
}
