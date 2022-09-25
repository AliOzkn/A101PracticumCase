package testscenarios;

import org.testng.annotations.Test;



public class BuyingProduct extends BaseTest {


    @Test(priority = 1)
    void searchProduct() {
        homePage.isOnMainPage();
        homePage.selectCategory();
        homePage.selectClothCategorie();
        homePage.selectWomenUnderwearCategorie();
        homePage.selectSocksCategorie();
    }

    @Test(priority = 2)
    void selectProduct(){
        productsPage.selectBlackColorFilter();
        productsPage.addToCart();
        productsPage.isColorBlack();
        productsPage.addToCart();
        productsPage.goToCart();
    }

    @Test(priority = 3)
    void goToCart() {
        cartPage.isOnCartPage();
        cartPage.confirmCart();
        cartPage.continueWithoutAMember();
        cartPage.writeEmail();
        cartPage.continueToAddressPage();
    }

    @Test(priority = 4)
    void createNewAddress() {

        addressPage.newAddress();
        addressPage.writeAddressTitle();
        addressPage.writeName();
        addressPage.writePhoneNumber();
        addressPage.selectCity(3);
        addressPage.selectTownShip(1);
        addressPage.selectDistrict(5);
        addressPage.writeAddress();
        addressPage.saveAddress();

    }

    @Test(priority = 5)
    void goToPaymentPage() {
        paymentPage.selectShippingCompany();
        paymentPage.saveAndContinue();
        paymentPage.isOnPaymentPage();
    }
}
