package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GooglePage;
import support.Hooks;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleSearchSteps {

    private GooglePage googlePage() {
        return new GooglePage(Hooks.driver);
    }

    @When("utilizatorul cauta dupa textul {string}")
    public void utilizatorul_cauta_dupa_textul(String text) {
        googlePage().searchFor(text);
    }

    @Then("se afiseaza un numar pozitiv de rezultate in pagina")
    public void se_afiseaza_un_numar_pozitiv_de_rezultate_in_pagina() {
        int count = googlePage().getResultsCount();
        assertTrue("Ar trebui sa existe cel putin un rezultat, dar count=" + count,
                count > 0);
    }
}
