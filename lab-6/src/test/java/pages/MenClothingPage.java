package pages;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenClothingPage extends BasePage {
    private By mensWearLink   = By.linkText("Men's wear");
    private By clothingLink   = By.linkText("Clothing");
    private By miniCartCloser = By.cssSelector(".minicart-closer");

    private By productButtonByIndex(int index) {
        // index incepe de la 1, ca in CSS nth-child
        return By.cssSelector(".col-md-3:nth-child(" + index + ") .button");
    }

    private By miniCartItems = By.cssSelector(".minicart-item");
    private By miniCartRemoveByIndex(int index) {
        return By.cssSelector(".minicart-item:nth-child(" + index + ") .minicart-remove");
    }

    public MenClothingPage(WebDriver driver) {
        super(driver);
    }

    public void openMenClothingCategory() {
        driver.findElement(By.linkText("Men's wear")).click();
        driver.findElement(By.linkText("Clothing")).click();
    }

    public void addProductToCartByIndex(int index) {
        WebElement button = waitClickable(productButtonByIndex(index));
        button.click();
    }

    public int getMiniCartItemCount() {
        List<WebElement> items = driver.findElements(miniCartItems);
        return items.size();
    }

    public void removeFromMiniCartByIndex(int index) {
        WebElement removeBtn = waitClickable(miniCartRemoveByIndex(index));
        removeBtn.click();
    }
}
