package page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

@Log4j2
public abstract class HomePage extends BasePage {
   protected static String URL = PropertyReader.getProperty("prestashop.base_url");
    protected By LOGIN_PAGE_LOCATOR = By.cssSelector("[title='Войти в учетную запись покупателя']");
    protected By SEARCH_LOCATOR = By.cssSelector("#search_query_top");
    protected By  WOMEN_BUTTON= By.cssSelector(".sf-with-ul[title='Women']");
    protected By  DRESSES_BUTTON= By.cssSelector(".sf-with-ul[title='Dresses']");
    protected By  TSHIRTS_BUTTON= By.cssSelector(".sf-with-ul[title='T-shirts']");
    protected By SHOPPING_CART = By.cssSelector("[title='Посмотреть корзину']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        log.info("Pressing the login button");
        driver.findElement(LOGIN_PAGE_LOCATOR).click();
    }

    public void searchItemToText(String item) {
        WebElement search = driver.findElement(SEARCH_LOCATOR);
        search.sendKeys(item);
        search.sendKeys(Keys.ENTER);
    }
    public void clickWomenButton() {
        log.info("Pressing the women button");
        driver.findElement(WOMEN_BUTTON).click();
    }
    public void open() {
        driver.get(URL);
    }
    public void clickingOnTheShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
    }
}
