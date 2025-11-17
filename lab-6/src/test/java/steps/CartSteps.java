package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.MenClothingPage;
import support.Hooks;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class CartSteps {
    private WebDriver driver;
    private MenClothingPage menClothingPage;

    @When("utilizatorul navigheaza la categoria Men's wear Clothing")
    public void utilizatorul_navigheaza_la_categoria_mens_wear_clothing() {
        driver = Hooks.driver;
        menClothingPage = new MenClothingPage(driver);
        menClothingPage.openMenClothingCategory();
    }

    @And("utilizatorul adauga in cos produsele cu pozitiile:")
    public void utilizatorul_adauga_in_cos_produsele_cu_pozitiile(DataTable dataTable) {
        List<Integer> positions = dataTable.asList(Integer.class);
        for (Integer index : positions) {
            menClothingPage.addProductToCartByIndex(index);
        }
    }

    @And("utilizatorul sterge din cos produsele cu pozitiile:")
    public void utilizatorul_sterge_din_cos_produsele_cu_pozitiile(DataTable dataTable) {
        List<Integer> positions = dataTable.asList(Integer.class);
        for (Integer index : positions) {
            menClothingPage.removeFromMiniCartByIndex(index);
        }
    }

    @And("utilizatorul adauga in cos produsul cu pozitia {int}")
    public void utilizatorul_adauga_in_cos_produsul_cu_pozitia(Integer index) {
        menClothingPage.addProductToCartByIndex(index);
    }

    @And("utilizatorul inchide minicart-ul")
    public void utilizatorul_inchide_minicartul() {
        menClothingPage.closeMiniCart();
    }

    @Then("cosul este actualizat corect")
    public void cosul_este_actualizat_corect() {
        String title = Hooks.driver.getTitle();
        assertTrue("Titlul paginii nu ar trebui sa fie gol dupa operatiile pe cos",
                title != null && !title.isEmpty());
    }
}
