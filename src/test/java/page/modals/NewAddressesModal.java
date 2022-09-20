package page.modals;

import elements.Input;
import elements.Select;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Addresses;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewAddressesModal extends BaseModal {
    public NewAddressesModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling out the new address form")
    public void fillingOutTheForm(Addresses inputUser) {
        log.info("Filling out the new address form");
        new Input(driver, "firstname").setValue(inputUser.getFirstName());
        new Input(driver, "lastname").setValue(inputUser.getLastName());
        new Input(driver, "company").setValue(inputUser.getCompany());
        new Input(driver, "address1").setValue(inputUser.getAddress());
        new Input(driver, "postcode").setValue(inputUser.getPostCode());
        new Input(driver, "city").setValue(inputUser.getCity());
        new Select(driver, "id_country").selectByVisibleText(inputUser.getCountry());
        new Input(driver, "phone").setValue(inputUser.getPhone());
        new Input(driver, "phone_mobile").setValue(inputUser.getMobile());
        new Select(driver, "id_state").selectByVisibleText(inputUser.getState());
        new Input(driver, "city").setValue(inputUser.getCity());
        new Input(driver, "alias").setValue(inputUser.getAlias());

    }
}
