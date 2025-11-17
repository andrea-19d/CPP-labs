package steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.SignUpPage;
import support.Hooks;

public class CommonSteps {
    @Given("utilizatorul este pe pagina principala")
    public void utilizatorul_este_pe_pagina_principala() {
        WebDriver driver = Hooks.driver;  // driver initializat in Hooks.@Before
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/");
    }
}
