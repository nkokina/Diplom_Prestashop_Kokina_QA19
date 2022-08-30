package page.modals;

import elements.Data;
import elements.Input;
import elements.Radio;
import elements.Year;
import lombok.extern.log4j.Log4j2;
import models.Authentication;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewAuthenticationModal extends BaseModal{

    public NewAuthenticationModal(WebDriver driver) {
        super(driver);
    }

    public void fillingOutTheForm(Authentication inputAuthentication) {
        log.info(String.format("Creating new Lead with Lname=%s", inputAuthentication .getLastName()));
        new Radio(driver, "Title").setValue(inputAuthentication.getTitle());
        new Input(driver, "customer_firstname").setValue(inputAuthentication.getFirstName());
        new Input(driver, "customer_lastname").setValue(inputAuthentication.getLastName());
        new Input(driver, "passwd").setValue(inputAuthentication.getPassword());
        new Data(driver, "days").selectByVisibleText(inputAuthentication.getData());
        new Data(driver, "months").selectByVisibleText(inputAuthentication.getMonths());
        new Year(driver, "years").selectByVisibleText(inputAuthentication.getYears());

        }
}


