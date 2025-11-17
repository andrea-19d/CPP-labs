package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.TopBarPage;
import support.Hooks;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class TopBarSteps {
    private WebDriver driver;
    private TopBarPage topBarPage;

    @When("utilizatorul navigheaza prin meniul de sus accesand linkurile:")
    public void utilizatorul_navigheaza_prin_meniul_de_sus_accesand_linkurile(DataTable dataTable) {
        driver = Hooks.driver;
        topBarPage = new TopBarPage(driver);

        // lista de linkText-uri din DataTable (coloana unica)
        List<String> links = dataTable.asList(String.class);

        // daca vrei sa imiti si prima actiune din test (click pe meniul activ/Home)
        // topBarPage.clickActiveMenu();

        for (String linkText : links) {
            topBarPage.clickMenuLink(linkText);
        }
    }

    @Then("fiecare pagina din meniu este afisata corect")
    public void fiecare_pagina_din_meniu_este_afisata_corect() {
        // validare generica (poti rafina pe fiecare pagina daca vrei)
        String title = Hooks.driver.getTitle();
        assertTrue("Titlul paginii nu ar trebui sa fie gol dupa navigare",
                title != null && !title.isEmpty());
    }
}
