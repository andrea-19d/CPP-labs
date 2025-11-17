package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.FooterPage;
import support.Hooks;

import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;

public class FooterSteps {

    private WebDriver driver;
    private FooterPage footerPage;

    public FooterSteps() {
        this.driver = Hooks.driver;
        this.footerPage = new FooterPage(driver);
    }

    @When("utilizatorul navigheaza la sectiunea de footer")
    public void utilizatorul_navigheaza_la_sectiunea_de_footer() {
        footerPage.scrollToFooter();
        System.out.println("URL curent inainte de scroll: " + driver.getCurrentUrl());
    }

    @And("utilizatorul verifica linkurile din footer folosind css:")
    public void utilizatorul_verifica_linkurile_din_footer_folosind_css(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String css = row.get("css");
            String expectedUrlPart = row.get("urlPart");

            // ne asiguram ca suntem in footer
            footerPage.scrollToFooter();

            footerPage.clickFooterLinkByCss(css);

            String currentUrl = driver.getCurrentUrl();
            System.out.println("Dupa click pe '" + css + "' URL-ul este: " + currentUrl);

            assertTrue(
                    "Linkul din footer cu selectorul '" + css +
                            "' nu a deschis o pagina care contine in URL: " + expectedUrlPart,
                    currentUrl.contains(expectedUrlPart)
            );

            // revenim la home pentru urmatorul link
            driver.navigate().back();
        }
    }
}
