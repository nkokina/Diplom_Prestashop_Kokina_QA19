package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    @Step("Setting registered email = {registeredEmail}")
    public void setRegisteredEmail(String registeredEmail) {
        log.info(String.format("Setting registered email %s", registeredEmail));
        driver.findElement(REGISTERED_EMAIL).sendKeys(registeredEmail);
    }

    @Step("Setting registered password = {registeredPassword}")
    public void setRegisteredPassword(String registeredPassword) {
        log.info(String.format("Setting registered password %s", registeredPassword));
        driver.findElement(REGISTERED_PASSWORD).sendKeys(registeredPassword);
    }

    @Step("Setting email Create = {emailCreate}")
    public void setEmailCreate(String emailCreate) {
        log.info(String.format("Setting email Create %s", emailCreate));
        driver.findElement(EMAIL_CREATE).sendKeys(emailCreate);
    }

    @Step("Pressing create an account button")
    public void clickSubmitInCreateButton() {
        log.info("Pressing create an account button");
        driver.findElement(SUBMIT_CREATE).click();
    }

    @Step("Pressing sing in button")
    public void clickRegisteredButton() {
        log.info("Pressing sing in button");
        driver.findElement(SUBMIT_LOGIN).click();
    }

    @Step("Login to site with email = {email} and password = {password}, and pressing the registered button")
    public void login(String email, String password) {
        log.info(String.format("Login to site with email %s and password %s, and pressing the registered button",
                email, password));
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
