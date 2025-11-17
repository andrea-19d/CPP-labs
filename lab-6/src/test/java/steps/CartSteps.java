package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.MenClothingPage;
import support.Hooks;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CartSteps {
    private WebDriver driver;
    private MenClothingPage menClothingPage;

    private int itemsCountBeforeRemove;

    public CartSteps() {
        this.driver = Hooks.driver;
        this.menClothingPage = new MenClothingPage(driver);
    }

    @And("utilizatorul navigheaza la categoria Men's wear Clothing")
    public void utilizatorul_navigheaza_la_categoria_mens_wear_clothing() {
        menClothingPage.openMenClothingCategory();
    }

    @And("utilizatorul adauga in cos produsele cu pozitiile: {int}, {int}, {int}")
    public void utilizatorul_adauga_in_cos_produsele_cu_pozitiile(Integer p1, Integer p2, Integer p3) {
        menClothingPage.addProductToCartByIndex(p1);
        menClothingPage.addProductToCartByIndex(p2);
        menClothingPage.addProductToCartByIndex(p3);
        assertTrue(menClothingPage.getMiniCartItemCount() >= 3);
    }

    @And("utilizatorul sterge din minicart produsul cu pozitia {int}")
    public void utilizatorul_sterge_din_minicart_produsul_cu_pozitia(Integer pos) {
        itemsCountBeforeRemove = menClothingPage.getMiniCartItemCount();
        menClothingPage.removeFromMiniCartByIndex(pos);
    }

    @Then("produsul este eliminat din minicart")
    public void produsul_este_eliminat_din_minicart() {
        int itemsAfter = menClothingPage.getMiniCartItemCount();
        assertEquals(
                "Dupa stergerea unui produs, numarul de item-uri din minicart trebuie sa scada cu 1",
                itemsCountBeforeRemove - 1,
                itemsAfter
        );
    }
}
