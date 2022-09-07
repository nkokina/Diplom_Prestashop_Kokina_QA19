package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import page.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;


@Listeners({TestListener.class})
public class BaseTest {

    protected final static String EMAIL = PropertyReader.getProperty("prestashop.login");
    protected final static String PASSWORD = PropertyReader.getProperty("prestashop.password");

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AuthenticationPage authenticationPage;
    protected MyAccountPage myAccountPage;
    protected SearchPage searchPage;
    protected ProductsPage productsPage;
    protected Faker faker;


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
        searchPage=new SearchPage(driver);
        productsPage=new ProductsPage(driver);
        faker = new Faker();
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
