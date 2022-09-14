package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement clickElement) {
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public void sendKeys(WebElement sendKeysElement, String text) {
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(text);
    }

    public void select(WebElement dropdown, String text) {
        Select slc = new Select(dropdown);
        slc.selectByVisibleText(text);
    }

    public void assertEquals(WebElement actual, String expected) {
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText().toLowerCase(), expected.toLowerCase());
    }
    public void assertTrue(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains(text));
    }
    public void assertTrueV2(boolean methodName){
        Assert.assertTrue(methodName);
    }

}
