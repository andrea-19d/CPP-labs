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

        List<String> links = dataTable.asList(String.class);

        topBarPage.clickActiveMenu();

        for (String linkText : links) {
            topBarPage.clickMenuLink(linkText);
        }
    }

    @Then("fiecare pagina din meniu este afisata corect")
    public void fiecare_pagina_din_meniu_este_afisata_corect() {
        String title = Hooks.driver.getTitle();
        assertTrue("Titlul paginii nu ar trebui sa fie gol dupa navigare",
                title != null && !title.isEmpty());
    }
}
