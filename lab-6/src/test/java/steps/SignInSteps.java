package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import support.Hooks;

import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;

public class SignInSteps {
    private WebDriver driver;
    private SignInPage signInPage;

    public SignInSteps() {
        this.driver = Hooks.driver;
    }

    @When("utilizatorul deschide formularul de autentificare")
    public void utilizatorul_deschide_formularul_de_autentificare() {
        driver = Hooks.driver;
        signInPage = new SignInPage(driver);
        signInPage.openSignInModal();
    }

    @And("utilizatorul completeaza formularul de autentificare cu:")
    public void utilizatorul_completeaza_formularul_de_autentificare_cu(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        String name = data.get("name");
        String email = data.get("email");

        signInPage.fillName(name);
        signInPage.fillEmail(email);
    }

    @And("utilizatorul trimite formularul de autentificare")
    public void utilizatorul_trimite_formularul_de_autentificare() {
        signInPage.submitWithEnter();
    }

    @Then("pagina de dupa autentificare este afisata corect")
    public void pagina_de_dupa_autentificare_este_afisata_corect() {
        String title = driver.getTitle();
        assertTrue("Titlul paginii nu ar trebui sa fie gol dupa autentificare",
                title != null && !title.isEmpty());
    }

    @Then("autentificarea nu este efectuata")
    public void autentificarea_nu_este_efectuata() {
        assertTrue("Formularul de autentificare ar trebui sa fie inca vizibil",
                signInPage.isSignInModalStillDisplayed());
    }
}
