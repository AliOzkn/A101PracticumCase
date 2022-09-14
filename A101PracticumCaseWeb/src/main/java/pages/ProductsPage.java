package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
public class ProductsPage extends BasePage{

    @FindBy(xpath = "//div[text()='Filtreler']")
    WebElement filterText;
    @FindBy(xpath = "//label[text()='SİYAH']")
    WebElement blackColor;
    @FindBy(xpath = "//ul[@class='product-list-general']/li")
    List<WebElement> productList;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void isOnProductsPage() {
        assertEquals(filterText, "Filtreler");
    }
    public void clickBlackColorFilter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        click(blackColor);
    }

    public void selectProduct(int i) {
        productList.get(i).click();
    }
}
