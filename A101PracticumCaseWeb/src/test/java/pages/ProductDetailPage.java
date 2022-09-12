package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
    By addToCartBtn = By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']");
    By productName = By.xpath("//h1[@class='product-name js-name']");
    By iconCheckLocator = By.cssSelector(".icon-check");
    By viewCartBtn = By.xpath("//div[@class='right-side']/a[@class='go-to-shop']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartBtn);
    }

    public boolean isProductTextContainsBlack() {
        getText(productName).toLowerCase().contains("siyah");
        return true;
    }

    public void addToCart() {
        click(addToCartBtn);
    }

    public boolean isIconCheckDisplayed() {
        return isDisplayed(iconCheckLocator);
    }

    public void viewCart() {
        click(viewCartBtn);
    }


}
