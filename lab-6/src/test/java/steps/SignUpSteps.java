package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.SignUpPage;
import support.Hooks;

import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;

public class SignUpSteps  {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @When("utilizatorul deschide formularul de inregistrare")
    public void utilizatorul_deschide_formularul_de_inregistrare() {
        driver = Hooks.driver;
        signUpPage = new SignUpPage(driver);
        signUpPage.openSignUpModal();
    }

    @And("utilizatorul completeaza formularul de inregistrare cu:")
    public void utilizatorul_completeaza_formularul_de_inregistrare_cu(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        signUpPage.fillName(data.get("name"));
        signUpPage.fillEmail(data.get("email"));
        signUpPage.fillPassword(data.get("password"));
        signUpPage.fillConfirmPassword(data.get("confirmPass"));
    }

    @And("utilizatorul trimite formularul de inregistrare")
    public void utilizatorul_trimite_formularul_de_inregistrare() {
        signUpPage.submit();
    }

    @Then("pagina de dupa inregistrare este afisata corect")
    public void pagina_de_dupa_inregistrare_este_afisata_corect() {
        String title = Hooks.driver.getTitle();
        assertTrue(title != null && !title.isEmpty());
    }

    @Then("inregistrarea nu este efectuata")
    public void inregistrarea_nu_este_efectuata() {
        assertTrue(
                "Formularul de inregistrare ar trebui sa fie inca vizibil pentru date invalide",
                signUpPage.isSignUpModalStillDisplayed()
        );
    }

    @And("utilizatorul inchide formularul de inregistrare")
    public void utilizatorul_inchide_formularul_de_inregistrare() {
        signUpPage.closeModal();
    }
}
