package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Properties;

public class DriverSetup {
    public static Properties properties;
    private static WebDriver driver;

    public static WebDriver initializeDriver(String browser){
        if (driver==null){
            ChromeOptions chromeOptions = new ChromeOptions();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--ignore-certificate-errors");
            firefoxOptions.addPreference("dom. webnotifications.enabled", false);
            properties = ConfigReader.getProperties();
            try {
                switch (browser) {
                    case "Chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(chromeOptions);
                        break;
                    case "Firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    case "Edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                }
            } catch (SessionNotCreatedException e) {
                System.out.println("Version Error:" + e.getLocalizedMessage());
            }
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
