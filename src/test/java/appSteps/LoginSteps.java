package appSteps;

import io.cucumber.java.fr.*;
import utils.DriverManager;

public class LoginSteps {
    @Etantdonnéque("je suis sur le CAS Auchan Klif {string}")
    public void je_suis_sur_le_cas_auchan_klif(String url) {
        DriverManager.getInstance().getDriver().get(url);
    }

    @Alors("le titre de la page est {string}")
    public void le_titre_de_la_page_est(String string) {

    }

    @Quand("je renseigne mon identifiant {string}")
    public void je_renseigne_mon_identifiant(String string) {

    }

    @Quand("je renseigne mon Mot de passe {string}")
    public void je_renseigne_mon_mot_de_passe(String string) {

    }

    @Quand("je clique sur le bouton Se Connecter")
    public void je_clique_sur_le_bouton_se_connecter() {

    }

    @Alors("je vois le titre de la page d'accueil {string}")
    public void je_vois_le_titre_de_la_page_d_accueil(String string) {

    }


}
