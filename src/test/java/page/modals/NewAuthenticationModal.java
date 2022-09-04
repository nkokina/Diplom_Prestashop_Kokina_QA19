package page.modals;

import elements.Data;
import elements.Input;
import elements.Radio;
import elements.Year;
import lombok.extern.log4j.Log4j2;
import models.User;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewAuthenticationModal extends BaseModal{

    public NewAuthenticationModal(WebDriver driver) {
        super(driver);
    }

    public void fillingOutTheForm(User inputUser) {
        log.info(String.format("Creating new user with Last name=%s", inputUser.getLastName()));
        new Radio(driver, "Title").setValue(inputUser.getTitle());
        new Input(driver, "customer_firstname").setValue(inputUser.getFirstName());
        new Input(driver, "customer_lastname").setValue(inputUser.getLastName());
        new Input(driver, "passwd").setValue(inputUser.getPassword());
        new Data(driver, "days").selectByVisibleText(inputUser.getData());
        new Data(driver, "months").selectByVisibleText(inputUser.getMonths());
        new Year(driver, "years").selectByVisibleText(inputUser.getYears());

        }
}


