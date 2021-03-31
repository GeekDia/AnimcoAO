package appSteps;

import io.cucumber.java.fr.*;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverManager;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
    HomePage homePage;

    ///////

    @Etantdonnéque("j'ai saisi l'url  {string}")
    public void j_ai_saisi_l_url(String url) {
        DriverManager.getInstance().getDriver().get(url);

    }

    @Alors("je suis redirigé vers le CAS {string}")
    public void je_suis_redirigé_vers_le_cas(String titre) {
        String actualPageTitle = loginPage.getPageTitle();
        String expectedPageTitle = titre;
        Assert.assertEquals(expectedPageTitle, actualPageTitle);

    }

    @Quand("je me connecte avec mon username {string} et mot de passe {string}")
    public void je_me_connecte_avec_mon_username_et_mot_de_passe(String username, String password) {

        homePage = loginPage.doLogin(username, password);
    }

    @Alors("la page {string} s'affiche")
    public void la_page_s_affiche(String titre) {

        String expectedCatalogPageTitle = titre;

        String actualCatalogPageTitle = homePage.getPageTitle();

        Assert.assertEquals(expectedCatalogPageTitle, actualCatalogPageTitle);


    }

    @Alors("mon XFR est présent dans le header")
    public void mon_xfr_est_présent_dans_le_header() {

        Boolean actualResult = homePage.isDisplayed();

        Assert.assertTrue(actualResult);

    }


}
