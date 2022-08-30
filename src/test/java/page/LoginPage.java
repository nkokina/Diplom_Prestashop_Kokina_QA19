package page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.PropertyReader;

@Log4j2
public class LoginPage extends HomePage {

    protected By SUBMIT_CREATE = By.cssSelector("#SubmitCreate");
    protected By EMAIL_CREATE = By.cssSelector("#email_create");
    protected By SUBMIT_LOGIN = By.cssSelector("#SubmitLogin");
    protected By REGISTERED_EMAIL = By.cssSelector("#email");
    protected By REGISTERED_PASSWORD = By.cssSelector("#passwd");
    protected By CREATE_ERROR = By.xpath("//*[text()='Invalid email address.']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setRegisteredEmail(String registeredEmail) {
        log.info("Login to site with registeredEmail %s", registeredEmail);
        driver.findElement(REGISTERED_EMAIL).sendKeys(registeredEmail);
    }

    public void setRegisteredPassword(String registeredPassword) {
        log.info("Login to site with registeredPassword %s", registeredPassword);
        driver.findElement(REGISTERED_PASSWORD).sendKeys(registeredPassword);
    }

    public void setEmailCreate(String emailCreate) {
        log.info("Login to site with emailCreate %s", emailCreate);
        driver.findElement(EMAIL_CREATE).sendKeys(emailCreate);
    }

    public void clickSubmitInCreateButton() {
        log.info("Pressing the submit in create button");
        driver.findElement(SUBMIT_CREATE).click();
    }

    public void clickRegisteredButton() {
        log.info("Pressing the registered button");
        driver.findElement(SUBMIT_LOGIN).click();
    }

    public void login(String email, String password) {
        log.info("Login to site with username %s and password %s, and pressing the registered button",
                email, password);
        clickLoginButton();
        setRegisteredEmail(email);
        setRegisteredPassword(password);
        clickRegisteredButton();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(CREATE_ERROR).isDisplayed();
    }

    public String getErrorMessageDisplayed() {
        return driver.findElement(CREATE_ERROR).getText();
    }

}
