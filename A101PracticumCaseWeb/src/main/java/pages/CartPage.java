package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class CartPage extends BasePage {

    @FindBy(xpath = "//span[@class='product-count']")
    WebElement productCount;
    @FindBy(xpath = "(//a[@title='Sepeti Onayla'])[2]")
    WebElement confirmCartBtn;
    @FindBy(xpath = "//a[@title='ÜYE OLMADAN DEVAM ET']")
    WebElement continueWithoutAMember;
    @FindBy(xpath = "//input[@name='user_email']")
    WebElement email;
    @FindBy(xpath = "(//button[@type='submit'])[4]")
    WebElement continueBtn;
    @FindBy(xpath = "//div[@class='title login-title']")
    WebElement signInText;
    @FindBy(xpath = "//label[@class='error-checkbox-label']")
    WebElement contractAcceptText;

    Faker faker;


    public CartPage(WebDriver driver) {
        super(driver);
        faker = new Faker();
    }

    private int cartCount() throws InterruptedException {
        Thread.sleep(1000);
        String count = productCount.getText();
        return Integer.parseInt(count);
    }

    public void confirmCart() throws InterruptedException {
        if (cartCount()>0){
            click(confirmCartBtn);
            assertTrue(signInText, "üye girişi");
        } else{
            System.out.println("You have not added any product to the cart.");
        }
    }

    public void continueWithoutAMember() {
        click(continueWithoutAMember);
        assertTrue(contractAcceptText,"kabul");
    }

    public void writeEmail() {
        String randomMail = faker.bothify("??##?#?#@gmail.com");
        sendKeys(email, randomMail);
        click(continueBtn);
    }
}
