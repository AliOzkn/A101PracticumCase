package testscenarios;

import devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import listener.LogListener;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.*;
import utility.DeviceFarmUtility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({LogListener.class})

public class BaseTest {
    String oreo;
    public static AppiumDriver driver;
    DesiredCapabilities capabilities;
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;

    public BaseTest(){
        oreo = DeviceFarm.ANDROID_S.path;

    }
    @BeforeSuite
    public void setUp() {
        try {
            capabilities = new DesiredCapabilities();
            capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.oreo);
            capabilities.setCapability("app", new File("src/test/resources/apps/A101.apk").getAbsolutePath());
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
            homePage = new HomePage();
            productsPage = new ProductsPage();
            cartPage = new CartPage();
            addressPage = new AddressPage();
            paymentPage = new PaymentPage();
        } catch (MalformedURLException e) {
            System.out.println("Please check URL. \n Error:" + e.getCause());
        } catch (SessionNotCreatedException e) {
            System.out.println("Please check server \n Error:" + e.getCause());
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
}
