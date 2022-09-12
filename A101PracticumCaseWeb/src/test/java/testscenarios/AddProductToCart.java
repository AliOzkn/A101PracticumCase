package testscenarios;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.*;

public class AddProductToCart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    PaymentPage paymentPage;
    NewAddressPage newAddressPage;

    @Test(priority = 1)
    void searchProduct() throws InterruptedException {
        homePage = new HomePage(driver);
        assertTrue(homePage.isOnMainPage());
        homePage.acceptCookies();
        homePage.search("Dizaltı Çorap");
        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isOnProductPage());

    }

    @Test(priority = 2)
    void selectProduct() {
        productsPage.selectColorFilter();
        productsPage.selectProduct(0);
        productDetailPage = new ProductDetailPage(driver);
        assertTrue(productDetailPage.isOnProductDetailPage());
        assertTrue(productDetailPage.isProductTextContainsBlack());
    }

    @Test(priority = 3)
    void addProductToCart() {
        productDetailPage.addToCart();
        assertTrue(productDetailPage.isIconCheckDisplayed());
    }

    @Test(priority = 4)
    void goToCartPage() {
        productDetailPage.viewCart();
        cartPage = new CartPage(driver);
        assertTrue(cartPage.isCartCountGreaterThanZero());
        cartPage.confirmCart();
    }

    @Test(priority = 5)
    void goToPaymentPage() {
        paymentPage = new PaymentPage(driver);
        paymentPage.continueWithoutAMember();
        paymentPage.writeEmail();
        paymentPage.newAddress();
        newAddressPage = new NewAddressPage(driver);
        assertTrue(newAddressPage.isOnNewAddressPage());
    }
    @Test(priority = 6)
    void updateAddress() throws InterruptedException {
        newAddressPage.writeAddressTitle("ev");
        newAddressPage.writeFirstName();
        newAddressPage.writeLastName();
        newAddressPage.writePhoneNumber();
        newAddressPage.selectCity();
        newAddressPage.selectTownShip();
        newAddressPage.selectDistrict();
        newAddressPage.writeAddress();
        newAddressPage.writePostCode();
        newAddressPage.saveAddress();
        assertTrue(paymentPage.isShippingCompaniesDisplayed());
    }
    @Test(priority = 7)
    void gotoPaymentOptionsPage(){
        paymentPage.selectShippingCompany(1);
        paymentPage.saveAndContinue();
        paymentPage.isCompleteOrderBtnDisplayed();

    }

}
