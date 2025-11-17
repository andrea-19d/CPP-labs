package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage{
    private WebDriver driver;

    private By signUpLink = By.linkText("Sign Up");
    private By nameInput = By.cssSelector("#myModal2 .styled-input:nth-child(1) > input");
    private By emailInput = By.cssSelector("#myModal2 .styled-input:nth-child(2) > input");
    private By passwordInput = By.name("password");
    private By confirmPasswordInput = By.name("Confirm Password");
    private By submitButton = By.cssSelector("form:nth-child(2) > input:nth-child(5)");
    private By signUpModal = By.id("myModal2");
    private By closeButton = By.cssSelector("#myModal2 .close");


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }

    public void openSignUpModal() {
        WebElement link = waitClickable(signUpLink);
        link.click();
        waitVisible(nameInput); // asteptam sa apara inputul
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

    public void fillPassword(String password) {
        WebElement passField = waitVisible(passwordInput);
        type(passField, password);
    }

    public void fillConfirmPassword(String password) {
        WebElement confirmField = waitVisible(confirmPasswordInput);
        type(confirmField, password);
    }

    public void submit() {
        WebElement button = waitClickable(submitButton);
        button.click();
    }

    public boolean isSignUpModalStillDisplayed() {
        try {
            WebElement modal = waitVisible(signUpModal);
            return modal.isDisplayed();
        } catch (TimeoutException e) {
            // daca nu mai gasim modalul, inseamna ca s-a inchis / nu mai e vizibil
            return false;
        }
    }

    public void closeModal() {
        WebElement close = waitClickable(closeButton);
        close.click();
    }
}
