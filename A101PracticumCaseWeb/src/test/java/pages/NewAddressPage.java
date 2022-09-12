package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage extends BasePage {

    By updateAddressLocator = By.xpath("//span[text()='Adres Güncelleme']");
    By addressTitle = By.xpath("(//input[@type='text'])[5]");
    By firstNameLocator = By.xpath("//input[@name='first_name']");
    By lastNameLocator = By.xpath("//input[@name='last_name']");
    By phoneNumberLocator = By.xpath("//input[@name='phone_number']");
    By cityLocator = By.xpath("//select[@name='city']");
    By townshipLocator = By.xpath("//select[@name='township']");
    By districtLocator = By.xpath("//select[@name='district']");
    By addressLocator = By.xpath("//textarea[@name='line']");
    By postCodeLocator = By.xpath("//input[@name='postcode']");
    By saveBtn = By.xpath("(//button[@type='button'])[6]");
    Faker faker;
    Select select;
    WebElement cityLocatorEl;
    WebElement townshipLocatorEl;
    WebElement districtLocatorEl;


    public NewAddressPage(WebDriver driver) {
        super(driver);
        faker = new Faker();

    }
    public boolean isOnNewAddressPage() {
        return isDisplayed(updateAddressLocator);
    }

    public void writeAddressTitle(String text) {
        sendKeys(addressTitle, text);
    }

    public void writeFirstName() {
        String firstName = faker.name().firstName();
        sendKeys(firstNameLocator, firstName);
    }

    public void writeLastName() {
        String lastName = faker.name().lastName();
        sendKeys(lastNameLocator, lastName);
    }

    public void writePhoneNumber() {
        String number = faker.numerify("###########");
        sendKeys(phoneNumberLocator, number);
    }

    public void selectCity() throws InterruptedException {
        Thread.sleep(1000);
        this.cityLocatorEl = find(cityLocator);
        select = new Select(cityLocatorEl);
        select.selectByIndex(1);
    }
    public void selectTownShip() throws InterruptedException{
        Thread.sleep(1000);
        this.townshipLocatorEl = find(townshipLocator);
        select = new Select(townshipLocatorEl);
        select.selectByIndex(1);
    }
    public void selectDistrict()throws InterruptedException {
        Thread.sleep(1000);
        this.districtLocatorEl = find(districtLocator);
        select = new Select(districtLocatorEl);
        select.selectByIndex(1);
    }
    public void writeAddress() {
        String streetName = faker.address().streetName();
        String buildingNumber = faker.address().buildingNumber();
        sendKeys(addressLocator, streetName + buildingNumber);
    }
    public void writePostCode() {
        String postCode = faker.numerify("#####");
        sendKeys(postCodeLocator, postCode);
    }
    public void saveAddress(){
        click(saveBtn);
    }

}
