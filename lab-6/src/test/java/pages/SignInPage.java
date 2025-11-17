package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends BasePage {
    private By signInLink = By.linkText("Sign In");
    private By nameInput  = By.name("Name");
    private By emailInput = By.name("Email");
    // Nu avem buton separat in testul original, se face ENTER pe email

    public SignInPage(WebDriver driver) {
        super(driver); // initializeaza driver, wait, js din BasePage
    }

    // Daca vrei, poti apela openHomePage() direct din BasePage in steps,
    // nu neaparat din SignInPage. Il las aici doar daca simti ca ai nevoie.
    public void openHomePage() {
        super.openHomePage();
    }

    public void openSignInModal() {
        WebElement link = waitClickable(signInLink);
        link.click();

        // asteptam sa fie vizibil campul Name din modal
        waitVisible(nameInput);
    }

    public void fillName(String name) {
        WebElement nameField = waitVisible(nameInput);
        scrollIntoView(nameField);
        type(nameField, name);
    }

    public void fillEmail(String email) {
        WebElement emailField = waitVisible(emailInput);
        type(emailField, email);
    }

    public void submitWithEnter() {
        WebElement emailField = waitVisible(emailInput);
        emailField.sendKeys(Keys.ENTER);
    }

    public boolean isSignInModalStillDisplayed() {
        try {
            WebElement nameField = waitVisible(nameInput);
            return nameField.isDisplayed();
        } catch (TimeoutException e) {
            // daca nu mai gasim input-ul, inseamna ca modalul a disparut
            return false;
        }
    }
}
