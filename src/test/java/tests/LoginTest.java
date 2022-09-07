package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.modals.NewAuthenticationModal;

public class LoginTest extends BaseTest {
    NewAuthenticationModal newAuthenticationModal;

    @BeforeMethod
    public void initialise() {
        newAuthenticationModal = new NewAuthenticationModal(driver);
    }

    @Test(groups = {"Smoke"}, dataProvider = "newUserRegistrationData")
    @Description("Successful new user registration")
    public void newUserRegistrationTest(String email, User testUser) {
        loginPage.clickLoginButton();
        loginPage.setEmailCreate(email);
        loginPage.clickSubmitInCreateButton();
        authenticationPage.waitForElementDisplayed();
        Assert.assertTrue(authenticationPage.isIconInformationDisplayed(), "Error login test");
        newAuthenticationModal.fillingOutTheForm(testUser);
        authenticationPage.clickRegisterButton();
        Assert.assertTrue(myAccountPage.isMessageDisplayed(), "An error occurred during registration");
    }

    @Test(groups = {"Negative"}, dataProvider = "negativeNewUserRegistrationTestData")
    @Description("Test for entering incorrect (missing) data for registering a new user")
    public void negativeNewUserRegistrationTest(String email, String expectedErrorMessage) {
        loginPage.clickLoginButton();
        loginPage.setEmailCreate(email);
        loginPage.clickSubmitInCreateButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageDisplayed().isEmpty(), false,
                expectedErrorMessage);
    }

    @Test(groups = {"Smoke"})
    @Description("Successful auto-registration of a registered user")
    public void userAuthorizationTest() {
        loginPage.clickLoginButton();
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(myAccountPage.isMessageDisplayed(), "An error occurred during registration");
    }

    @DataProvider
    public Object[][] negativeNewUserRegistrationTestData() {
        return new Object[][]{
                {"dfs", "Email not filled"},
                {"123", "Email not filled"},
                {"", "Fields are empty"},
        };
    }

    @DataProvider(name = "newUserRegistrationData")
    public Object[][] createNewUserRegistrationTestData() {
        return new Object[][]{
                {faker.internet().emailAddress(), User.builder().title("1").lastName(faker.name().lastName()).firstName(faker.name().firstName())
                        .password(faker.internet().password()).data("23").months("5").years("1990")
                        .build()},
                {faker.internet().emailAddress(), User.builder().lastName(faker.name().lastName()).firstName(faker.name().firstName())
                        .password(faker.internet().password()).build()},
        };
    }
}