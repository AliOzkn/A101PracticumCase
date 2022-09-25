package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Data;
@Data
public class ProductsPage extends Helper {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filtrele']")
    MobileElement filter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SİYAH (4)']")
    MobileElement blackColor;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SEPETE EKLE']")
    MobileElement addToCart;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Penti Kadın 50 Denye Pantolon Çorabı Siyah']")
    MobileElement productText;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SEPETE GİT']")
    MobileElement goToCart;


    public void selectBlackColorFilter() {
        click(filter);
        click(blackColor);
    }

    public void addToCart() {
        click(addToCart);
    }
    public void isColorBlack(){
        assertTrueV1(productText,"siyah");
    }

    public void goToCart() {
        click(goToCart);
    }
}
