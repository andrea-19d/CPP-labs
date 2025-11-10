package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.By.id;

public class AnotherTestCase {
    private WebDriver driver;
    private JavascriptExecutor js;
    private Map<String, Object> vars;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test1() {
        // 1. Deschide Google
        driver.get("https://www.google.com/");

        // 2. Scrie "computer" in search box
        WebElement searchBox = driver.findElement(id("APjFqb"));
        searchBox.sendKeys("computer");

        // 3. Trimite formularul cu ENTER (in loc sa facem click pe btnK)
        searchBox.sendKeys(Keys.ENTER);

        // 4. Asteapta sa se incarce rezultatele si verifica antetul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("gb"))
        );

        // Daca header-ul nu se afiseaza, testul va pica aici
        assert header.isDisplayed();
    }
}
