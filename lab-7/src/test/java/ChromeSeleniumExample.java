import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
public class ChromeSeleniumExample {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Now you can use the driver to interact with Chrome
        driver.get("https://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}