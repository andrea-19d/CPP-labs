package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopBarPage extends BasePage {
    private By activeMenuLink = By.cssSelector(".active > .menu__link");

    public TopBarPage(WebDriver driver) {
        super(driver); // seteaza driver, wait, js din BasePage
    }

    public void clickActiveMenu() {
        WebElement link = waitClickable(activeMenuLink);
        scrollIntoView(link);
        link.click();
    }

    public void clickMenuLink(String linkText) {
        By locator = By.linkText(linkText);
        WebElement link = waitClickable(locator);
        scrollIntoView(link);
        link.click();
    }
}
