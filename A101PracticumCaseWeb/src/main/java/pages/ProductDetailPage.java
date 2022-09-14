package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ProductDetailPage extends BasePage {
    @FindBy(xpath = "//h1[@class='product-name js-name']")
    WebElement productName;
    @FindBy(xpath = "//button[@class='add-to-basket button green block with-icon js-add-basket']")
    WebElement addToCartBtn;
    @FindBy(xpath = "(//span[@class='text'])[1]")
    WebElement productAdded;
    @FindBy(xpath = "//div[@class='right-side']/a[@class='go-to-shop']")
    WebElement viewCartBtn;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void isProductTextContainsBlack() {
        assertTrue(productName, "siyah");

    }

    public void addToCart() {
        click(addToCartBtn);
        assertTrue(productAdded,"eklediniz");
    }


    public void viewCart() {
        click(viewCartBtn);
    }
}
