package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage extends BasePage {

    @FindBy(xpath = "(//a[text()='Bize Ulaşın'])[1]")
    WebElement contactUs;
    @FindBy(xpath = "//button[text()='Kabul Et']")
    WebElement cookies;
    @FindBy(xpath = "//input[@name='search_text']")
    WebElement searchBox;
    @FindBy(xpath = "(//div[@class='personaclick-search-group-description'])[1]/a[8]")
    WebElement socksCategory;

    public HomePage(WebDriver driver) {
        super(driver);

    }
    public void isOnMainPage() {
        assertEquals(contactUs, "Bize Ulaşın");
    }

    public void acceptCookies() {
        click(cookies);
    }

    public void search() {
        sendKeys(searchBox, "dizaltı çorap");
        click(socksCategory);
    }
}
