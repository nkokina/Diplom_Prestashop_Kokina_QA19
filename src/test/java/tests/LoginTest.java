package tests;

import enums.Title;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {


    @Test(groups = {"Smoke"}, dataProvider = "newUserRegistrationData", retryAnalyzer = Retry.class)
    @Description("Successful new user registration")
    public void newUserRegistrationTest(String email, User testUser) {
        loginPage.clickLoginButton();
        loginPage.setEmailCreate(email);
        loginPage.clickSubmitInCreateButton();
        authenticationPage.waitForOpenAuthenticationPage();
        Assert.assertTrue(authenticationPage.isIconInformationDisplayed(), "Error login test");
        newAuthenticationModal.fillingOutTheForm(testUser);
        authenticationPage.clickRegisterButton();
        Assert.assertTrue(myAccountPage.isMessageDisplayed(), "An error occurred during registration");

    }

    @Test(groups = {"Negative"}, dataProvider = "negativeNewUserRegistrationTestData", retryAnalyzer = Retry.class)
    @Description("Test for entering incorrect (missing) data for registering a new user")
    public void negativeNewUserRegistrationTest(String email, String expectedErrorMessage) {
        loginPage.clickLoginButton();
        loginPage.setEmailCreate(email);
        loginPage.clickSubmitInCreateButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertFalse(loginPage.getErrorMessageDisplayed().isEmpty(), expectedErrorMessage);

    }

    @Test(groups = {"Smoke"}, retryAnalyzer = Retry.class)
    @Description("Successful auto-registration of a registered user")
    public void userAuthorizationTest() {
        loginPage.clickLoginButton();
        loginPage.login(userEmail, userPassword);
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
                {faker.internet().emailAddress(), User.builder().title(Title.MS).lastName(faker.name().lastName())
                        .firstName(faker.name().firstName()).password(faker.internet().password()).data("23")
                        .months("5").years("2008").build()},
                {faker.internet().emailAddress(), User.builder().lastName(faker.name().lastName()).firstName(faker.name().firstName())
                        .password(faker.internet().password()).build()},
        };
    }
}