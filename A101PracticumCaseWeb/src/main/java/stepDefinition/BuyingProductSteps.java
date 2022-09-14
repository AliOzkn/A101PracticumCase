package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utilities.ConfigReader;
import utilities.DriverSetup;

import java.time.Duration;
import java.util.Properties;

public class BuyingProductSteps {
    static WebDriver driver;
    static Properties properties;
    WebDriverWait wait;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    AddressPage addressPage;
    PaymentPage paymentPage;

    @Given("navigate to A101 website")
    public void navigate_to_a101_website() {
        properties = ConfigReader.initializeProperties();
        driver = DriverSetup.initializeDriver(properties.getProperty("browser"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage = new HomePage(driver);
        homePage.isOnMainPage();

    }

    @When("search for socks")
    public void search_for_socks() {
        homePage.acceptCookies();
        homePage.search();
    }

    @When("choose to buy the first product")
    public void choose_to_buy_the_first_product() {
        productsPage = new ProductsPage(driver);
        productsPage.isOnProductsPage();
        productsPage.clickBlackColorFilter();
        productsPage.selectProduct(0);
    }

    @Then("check that the product is black")
    public void check_that_the_product_is_black() {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.isProductTextContainsBlack();
        productDetailPage.addToCart();
    }

    @When("go to cart")
    public void go_to_cart() throws InterruptedException {
        productDetailPage.viewCart();
        cartPage = new CartPage(driver);
        cartPage.confirmCart();
    }

    @When("click continue without a member button")
    public void click_continue_without_a_member_button() {
        cartPage.continueWithoutAMember();
        cartPage.writeEmail();

    }

    @When("enter personal details and new address")
    public void enter_personal_details_and_new_address() throws InterruptedException {
        addressPage = new AddressPage(driver);
        addressPage.newAddress();
        addressPage.isOnNewAddressPage();
        addressPage.writeAddressTitle();
        addressPage.writeFirstName();
        addressPage.writeLastName();
        addressPage.writePhoneNumber();
        addressPage.selectCity();
        addressPage.selectTownShip();
        addressPage.selectDistrict();
        addressPage.writeAddress();
        addressPage.writePostCode();
        addressPage.saveAddress();

    }

    @When("click the complete order button")
    public void click_the_complete_order_button() {
        addressPage.selectShippingCompany();
        addressPage.saveAndContinue();
    }

    @Then("see go to the payment screen is success")
    public void see_go_to_the_payment_screen_is_success() {
        paymentPage = new PaymentPage(driver);
        paymentPage.isOnPaymentPage();
        driver.quit();
    }
}
