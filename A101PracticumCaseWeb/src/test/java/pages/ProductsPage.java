package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {
    By filtersTextLocator = By.xpath("//div[text()='Filtreler']");
    By blackColorLocator = By.xpath("//label[text()='SİYAH']");
    By productListLocator = By.xpath("//ul[@class='product-list-general']/li");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(filtersTextLocator);
    }

    public void selectColorFilter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        click(blackColorLocator);
    }

    private List<WebElement> getAllProducts() {
        return findAll(productListLocator);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }

}
