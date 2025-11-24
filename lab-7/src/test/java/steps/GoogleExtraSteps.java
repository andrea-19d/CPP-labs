package steps;

import cucumber.api.java.en.Then;
import pages.GooglePage;
import support.Hooks;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleExtraSteps {

    private GooglePage googlePage() {
        return new GooglePage(Hooks.driver);
    }

    private static String firstSavedTitle;

    @Then("salveaza primul rezultat")
    public void salveaza_primul_rezultat() {
        firstSavedTitle = googlePage().getFirstResultTitleText().toLowerCase();
    }

    @Then("primul rezultat este acelasi ca primul salvat")
    public void primul_rezultat_este_acelasi() {
        String current = googlePage().getFirstResultTitleText().toLowerCase();
        assertTrue("Primul rezultat diferă. salvat=" + firstSavedTitle + " curent=" + current,
                current.contains(firstSavedTitle) || firstSavedTitle.contains(current));
    }

    @Then("se afiseaza calculatorul Google")
    public void se_afiseaza_calculatorul_Google() {
        int count = googlePage().getResultsCount();
        assertTrue("Ar trebui sa existe cel putin un rezultat, dar count=" + count,
                count > 0);
    }

    @Then("serviciul de conversie apare in partea de sus")
    public void serviciul_de_conversie_apare_in_partea_de_sus() {
        assertTrue("Converterul nu apare in partea de sus",
                googlePage().isConverterOnTop());
    }
}
