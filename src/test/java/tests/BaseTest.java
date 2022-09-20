package tests;

import com.github.javafaker.Faker;
import enums.Title;
import models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import page.*;
import page.modals.NewAddressesModal;
import page.modals.NewAuthenticationModal;
import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)
public class BaseTest {

    protected static Faker faker = new Faker();
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AuthenticationPage authenticationPage;
    protected WomenPage womenPage;
    protected MyAccountPage myAccountPage;
    protected SearchPage searchPage;
    protected ProductsPage productsPage;
    protected NewAuthenticationModal newAuthenticationModal;
    protected NewAddressesModal newAddressesModal;
    protected ItemDetailsPage itemDetailsPage;
    protected BasketPage basketPage;
    protected String userEmail;

    protected String userPassword;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        searchPage = new SearchPage(driver);
        productsPage = new ProductsPage(driver);
        newAuthenticationModal = new NewAuthenticationModal(driver);
        womenPage = new WomenPage(driver);
        newAddressesModal = new NewAddressesModal(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        basketPage = new BasketPage(driver);
        navigate();
        userRegistration();
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }

    public void userRegistration() {
        userEmail = faker.internet().emailAddress();
        userPassword = faker.internet().password();
        loginPage.clickLoginButton();
        loginPage.setEmailCreate(userEmail);
        loginPage.clickSubmitInCreateButton();
        authenticationPage.waitForOpenAuthenticationPage();
        User testUser = User.builder().title(Title.MS).lastName(faker.name().lastName())
                .firstName(faker.name().firstName()).password(userPassword).data("23")
                .months("5").years("2008").build();
        newAuthenticationModal.fillingOutTheForm(testUser);
        authenticationPage.clickRegisterButton();
        loginPage.clickClosedLoginButton();
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
