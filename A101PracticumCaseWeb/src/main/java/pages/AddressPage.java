package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage {

    @FindBy(xpath = "(//a[contains(@class,'new-address')])[1]")
    WebElement creatNewAddressBtn;
    @FindBy(xpath = "//span[text()='Adres Güncelleme']")
    WebElement updateAddress;
    @FindBy(xpath = "(//input[@type='text'])[5]")
    WebElement addressTitle;
    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@name='phone_number']")
    WebElement phoneNumber;
    @FindBy(xpath = "//select[@name='city']")
    WebElement city;
    @FindBy(xpath = "//select[@name='township']")
    WebElement township;
    @FindBy(xpath = "//select[@name='district']")
    WebElement district;
    @FindBy(xpath = "//textarea[@name='line']")
    WebElement address;
    @FindBy(xpath = "//input[@name='postcode']")
    WebElement postCode;
    @FindBy(xpath = "(//button[@type='button'])[6]")
    WebElement saveBtn;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement saveAndContinueBtn;
    @FindBy(xpath = "//ul[@class='js-shipping-list']/li[1]/label")
    WebElement shippingCompany;
    Faker faker;

    public AddressPage(WebDriver driver) {
        super(driver);
        faker = new Faker();
    }

    public void newAddress() {
        click(creatNewAddressBtn);
    }

    public void isOnNewAddressPage() throws InterruptedException {
        Thread.sleep(1000);
        assertTrue(updateAddress, "güncelleme");
    }

    public void writeAddressTitle() {
        sendKeys(addressTitle, "ev");
    }

    public void writeFirstName() {
        String fName = faker.name().firstName();
        sendKeys(firstName, fName);
    }

    public void writeLastName() {
        String lName = faker.name().lastName();
        sendKeys(lastName, lName);
    }

    public void writePhoneNumber() {
        String number = faker.numerify("###########");
        sendKeys(phoneNumber, number);
    }

    public void selectCity() throws InterruptedException {
        Thread.sleep(1000);
        select(city, "ANTALYA");
    }

    public void selectTownShip() throws InterruptedException {
        Thread.sleep(1000);
        select(township, "KAŞ");
    }

    public void selectDistrict() throws InterruptedException {
        Thread.sleep(1000);
        select(district, "AHATLI MAH");
    }

    public void writeAddress() {
        String streetName = faker.address().streetName();
        String buildingNumber = faker.address().buildingNumber();
        sendKeys(address, streetName + buildingNumber);
    }

    public void writePostCode() {
        String pCode = faker.numerify("#####");
        sendKeys(postCode, pCode);
    }

    public void saveAddress() {
        click(saveBtn);
    }
public void selectShippingCompany(){
        click(shippingCompany);
}
    public void saveAndContinue() {
        click(saveAndContinueBtn);
    }
}
