package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class PaymentPage extends Helper {


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.widget.ListView/android.view.View[1]/android.widget.RadioButton")
    MobileElement shippingComp;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Kaydet ve Devam Et']")
    MobileElement saveAndContinueBtn;
    @AndroidFindBy(xpath = "//android.view.View[@text='Lütfen Kart bilgilerinizi yazın.']")
    MobileElement cartInformation;


    public void selectShippingCompany() {
        click(shippingComp);
    }

    public void saveAndContinue() {
        click(saveAndContinueBtn);
    }

    public void isOnPaymentPage() {
        assertTrueV2(cartInformation.isDisplayed());

    }
}
