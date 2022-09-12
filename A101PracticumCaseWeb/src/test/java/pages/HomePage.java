package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    By mainLogo = By.xpath("//*[@title='A101']");
    By searchBoxLocator = By.xpath("//input[@name='search_text']");
    By kneeSocksCategoryLocator = By.xpath("(//div[@class='personaclick-search-group-description'])[1]/a[8]");
    By acceptCookies = By.xpath("//button[text()='Kabul Et']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnMainPage() {
        return isDisplayed(mainLogo);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookies));
        click(acceptCookies);
    }

    public void search(String text) throws InterruptedException {
        sendKeys(searchBoxLocator, text);
        Thread.sleep(1000);
        click(kneeSocksCategoryLocator);

    }
}
