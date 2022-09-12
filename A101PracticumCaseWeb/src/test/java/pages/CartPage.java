package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    By productCount = By.xpath("//span[@class='product-count']");
    By confirmCartBtn = By.xpath("(//a[@title='Sepeti Onayla'])[2]");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    private int cartCount() {
        String count = find(productCount).getText();
        return Integer.parseInt(count);
    }
    public boolean isCartCountGreaterThanZero(){
        return cartCount() > 0;
    }

    public void confirmCart() {
        click(confirmCartBtn);
    }
}
