package pages;

import com.github.javafaker.Faker;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static testscenarios.BuyingProduct.driver;

public abstract class Helper {
    Faker faker;
    WebDriverWait wait;


    public Helper(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        faker = new Faker();
        wait = new WebDriverWait(driver,10);

    }

    public void sendKeys(MobileElement el, String str) {
        wait.until(ExpectedConditions.visibilityOf(el));
        el.sendKeys(str);

    }
    public void click(MobileElement el){
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
    }

    public void assertEquals(MobileElement actual, String expected) {
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText().toLowerCase(), expected.toLowerCase());
    }
    public void assertTrueV1(MobileElement el, String text){
        wait.until(ExpectedConditions.visibilityOf(el));
        Assert.assertTrue(el.getText().toLowerCase().contains(text));
    }
    public void assertTrueV2(boolean methodName){
        Assert.assertTrue(methodName);
    }
}
