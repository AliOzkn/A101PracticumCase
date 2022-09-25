package pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Data;

@Data
public class HomePage extends Helper {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
    MobileElement onlineShop;
    @AndroidFindBy(className = "android.widget.TextView")
    MobileElement mainCategories;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup)[15]")
    MobileElement clothAndAccessory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Kadın İç Giyim']")
    MobileElement womenUnderwear;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dizaltı Çorap']")
    MobileElement socks;

    public void isOnMainPage() {
        assertEquals(onlineShop, "Online\n" +
                "Mağaza");
    }

    public void selectCategory() {
        click(mainCategories);
    }

    public void selectClothCategorie() {
        click(clothAndAccessory);
    }

    public void selectWomenUnderwearCategorie() {
        click(womenUnderwear);
    }

    public void selectSocksCategorie() {
        click(socks);
    }


}
