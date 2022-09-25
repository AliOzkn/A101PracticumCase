package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class CartPage extends Helper {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sepetim']")
    MobileElement myCart;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SEPETİ ONAYLA']")
    MobileElement confirmCartBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ÜYE OLMADAN DEVAM ET']")
    MobileElement continueWithoutAMemberBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='E-posta Adresiniz']")
    MobileElement email;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
    MobileElement confirmationBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GÖNDER']")
    MobileElement sendBtn;

    public void isOnCartPage() {
        assertTrueV2(myCart.isDisplayed());

    }

    public void confirmCart() {
        click(confirmCartBtn);
    }

    public void continueWithoutAMember() {
        click(continueWithoutAMemberBtn);
    }

    public void writeEmail() {
        String randomMail = faker.bothify("??##?#?#@gmail.com");
        sendKeys(email, randomMail);
    }


    public void continueToAddressPage() {
        click(confirmationBtn);
        click(sendBtn);
    }
}
