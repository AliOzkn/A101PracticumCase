package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentPage extends BasePage {

    /*
    Üye olmadan devam et butonuna tıklayacak.
    Email adresi girecek. Rastgele faker ile oluştur. Devam et butonuna tıklayacak.
    Yeni Adres oluştur butonuna tıklayacak. Adres bilgilerini dolduracak.
    Kargo firmasından 1. sıradakini seçecek.
    Kaydet ve devam et butonuna tıklayacak.
    Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edecekler.
    */
    By continueWithoutAMember = By.xpath("//a[@title='ÜYE OLMADAN DEVAM ET']");
    By email = By.xpath("//input[@name='user_email']");
    By continueBtn = By.xpath("(//button[@type='submit'])[4]");
    By createNewAddress = By.xpath("(//a[contains(@class,'new-address')])[1]");
    By shippingCompanies = By.xpath("//ul[@class='js-shipping-list']//li//label");
    By saveAndContinueBtn = By.xpath("(//button[@type='submit'])[1]");
    By completeOrderBtn = By.xpath("(//span[text()='Siparişi Tamamla'])[2]");
    Faker faker;

    public PaymentPage(WebDriver driver) {
        super(driver);
        faker = new Faker();
    }

    public void continueWithoutAMember() {
        click(continueWithoutAMember);
    }

    public void writeEmail() {
        String randomMail = faker.bothify("???###?#?#@gmail.com");
        sendKeys(email, randomMail);
        click(continueBtn);
    }

    public void newAddress() {
        click(createNewAddress);
    }

    private List<WebElement> getShippingCompanies() {
        return findAll(shippingCompanies);
    }

    public void selectShippingCompany(int i) {
        getShippingCompanies().get(i).click();

    }

    public boolean isShippingCompaniesDisplayed() {
        return isDisplayed(shippingCompanies);
    }

    public void saveAndContinue() {
        click(saveAndContinueBtn);
    }

    public boolean isCompleteOrderBtnDisplayed() {
        return isDisplayed (completeOrderBtn);
    }
}
