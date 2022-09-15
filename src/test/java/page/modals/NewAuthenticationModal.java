package page.modals;

import elements.Input;
import elements.Radio;
import elements.Select;
import elements.Year;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.User;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewAuthenticationModal extends BaseModal {

    public NewAuthenticationModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling out the form new user")
    public void fillingOutTheForm(User inputUser) {
        log.info("Filling out the form new user");
        if (inputUser.getTitle()!=null) {
        new Radio(driver, "Title").setValue(inputUser.getTitle().name);
        }
        new Input(driver, "customer_firstname").setValue(inputUser.getFirstName());
        new Input(driver, "customer_lastname").setValue(inputUser.getLastName());
        new Input(driver, "passwd").setValue(inputUser.getPassword());
        new Select(driver, "uniform-days").selectByVisibleText(inputUser.getData());
        new Select(driver, "uniform-months").selectByVisibleText(inputUser.getMonths());
        new Year(driver, "cuselFrame-years").selectByVisibleText(inputUser.getYears());

    }
}


