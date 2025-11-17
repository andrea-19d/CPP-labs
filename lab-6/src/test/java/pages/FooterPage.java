package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterPage extends BasePage {
    private By footerContainer = By.cssSelector(".col-md-4"); // adaptabil

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToFooter() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void clickFooterLinkByCss(String cssSelector) {
        // ne asiguram ca footerul este cel putin vizibil
        waitVisible(footerContainer);

        WebElement link = waitClickable(By.cssSelector(cssSelector));
        scrollIntoView(link);
        link.click();
    }
}
