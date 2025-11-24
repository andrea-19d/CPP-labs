package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GooglePage extends BasePage {

    private String baseUrl = "https://www.google.co.in";

    private By searchInput = By.name("q");

    // rezultate (Google poate avea 2 clase)
    private By resultBlocks = By.cssSelector("div#search .g, div#search .MjjYud");

    // primul rezultat titlu
    private By firstResultTitle = By.cssSelector("div#search h3");

    // “Did you mean” / “Ai vrut să spui”
    private By didYouMeanText = By.xpath(
            "//*[contains(text(),'Did you mean') or contains(text(),'Ai vrut să spui')]"
    );

    // calculator widget
    private By calculatorWidget = By.cssSelector(
            "div[data-attrid='kc:/calculator:calculator'], " +  // calculator box (cel mai comun)
                    "div#cwmcwd, div#cwos, " +                          // vechi id-uri google calc
                    "div[aria-label*='Calculator'], " +                // aria label
                    "div[role='region'][data-attrid*='calculator']"    // fallback generic
    );

    // converter widget top
    private By converterWidgetTop = By.cssSelector(
            "div[data-attrid*='unit converter'], div[aria-label*='Converter'], div#rcnt div[data-attrid]"
    );

    // autocomplete
    private By autocompleteItems = By.cssSelector("ul[role='listbox'] li");

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void waitUntilSearchIsReady() {
        // asteptam pana apare inputul de cautare normal
        new WebDriverWait(driver, Duration.ofSeconds(180)) // 3 minute
                .until(ExpectedConditions.visibilityOfElementLocated(searchInput));
    }

    public void openHomePage() {
        driver.get(baseUrl);
        acceptConsentIfPresent();
        waitUntilSearchIsReady();
    }

    private void acceptConsentIfPresent() {
        try {
            List<WebElement> buttons = driver.findElements(
                    By.xpath("//button//*[contains(text(),'Accept all') or contains(text(),'I agree') or contains(text(),'Acceptă tot')]/ancestor::button")
            );
            if (!buttons.isEmpty()) buttons.get(0).click();
        } catch (Exception ignored) {}
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // cautare cu ENTER
    public void searchFor(String text) {
        waitUntilSearchIsReady();
        typeAndEnter(searchInput, text);
        waitVisible(By.id("search"));
    }

    public int getResultsCount() {
        waitVisible(By.id("search"));
        return driver.findElements(resultBlocks).size();
    }

    public String getFirstResultTitleText() {
        return waitVisible(firstResultTitle).getText();
    }

    public boolean isDidYouMeanDisplayed() {
        try {
            return waitVisible(didYouMeanText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCalculatorDisplayed() {
        try {
            // așteaptă până când apare un widget de calculator
            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(d -> !d.findElements(calculatorWidget).isEmpty());

            WebElement el = driver.findElements(calculatorWidget).get(0);

            // dacă e acoperit de vreun overlay, scroll până la el
            js.executeScript("arguments[0].scrollIntoView(true);", el);

            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isConverterOnTop() {
        try {
            waitVisible(By.id("search"));
            WebElement el = waitVisible(converterWidgetTop);
            int y = el.getLocation().getY();
            return el.isDisplayed() && y < 600;
        } catch (Exception e) {
            return false;
        }
    }

    public void typeInSearchBox(String text) {
        WebElement input = waitVisible(searchInput);
        type(input, text);
    }

    public boolean hasAutocompleteSuggestions() {
        try {
            waitVisible(By.cssSelector("ul[role='listbox']"));
            return !driver.findElements(autocompleteItems).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }


}
