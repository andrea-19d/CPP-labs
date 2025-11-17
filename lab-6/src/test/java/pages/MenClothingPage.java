package pages;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenClothingPage extends BasePage {
    private By mensWearLink   = By.linkText("Men's wear");
    private By clothingLink   = By.linkText("Clothing");
    private By miniCartCloser = By.cssSelector(".minicart-closer");

    public MenClothingPage(WebDriver driver) {
        super(driver);
    }

    public void openMenClothingCategory() {
        WebElement mensWear = waitClickable(mensWearLink);
        mensWear.click();

        WebElement clothing = waitClickable(clothingLink);
        clothing.click();
    }

    public void addProductToCartByIndex(int index) {
        By locator = By.cssSelector(".col-md-3:nth-child(" + index + ") .button");
        WebElement button = waitClickable(locator);
        scrollIntoView(button);
        button.click();
    }

    public void removeFromMiniCartByIndex(int index) {
        By locator = By.cssSelector(".minicart-item:nth-child(" + index + ") .minicart-remove");
        WebElement removeBtn = waitClickable(locator);
        removeBtn.click();
    }

    public void closeMiniCart() {
        WebElement closeBtn = waitClickable(miniCartCloser);
        closeBtn.click();
    }
}
