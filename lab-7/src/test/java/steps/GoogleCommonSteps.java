package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.GooglePage;
import support.Hooks;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleCommonSteps {

    private GooglePage googlePage() {
        return new GooglePage(Hooks.driver);
    }

    @Given("utilizatorul deschide browserul pe pagina Google")
    public void utilizatorul_deschide_browserul_pe_pagina_Google() {
        googlePage().openHomePage();
    }

    @Then("titlul paginii contine {string}")
    public void titlul_paginIi_contine(String text) {
        String title = googlePage().getTitle();
        assertTrue("Titlul nu contine textul asteptat",
                title != null && title.contains(text));
    }
}
