package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
    public static WebDriver getDriver(String browserName) throws Exception {
        WebDriver driver;
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
//            option.addArguments("--headless");
            option.addArguments("--ignore-certificate-errors");
            option.addArguments("--disable-popup-blocking");
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);
        } else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else {
            throw new Exception("Undefined browser type");
        }
        return driver;
    }
}

