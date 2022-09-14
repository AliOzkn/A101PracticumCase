package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class PaymentPage extends BasePage{

    @FindBy(xpath = "(//div[@class='title'])[9]")
    WebElement cardInformationText;
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void isOnPaymentPage(){
        assertEquals(cardInformationText,"Lütfen Kart bilgilerinizi yazın.");
    }
}
