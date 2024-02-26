package tn.esprit.service;

import tn.esprit.models.Investisseur;
import java.util.ArrayList;
import java.util.List;

public class FiltreService {
    public static List<Investisseur> filtrerInvestisseurs(List<Investisseur> investisseurs, String critereFiltre) {
        List<Investisseur> resultats = new ArrayList<>();
        for (Investisseur investisseur : investisseurs) {

            if (investisseur.getSecteurInteret().equalsIgnoreCase(critereFiltre)) {
                resultats.add(investisseur);
            }
        }
        return resultats;
    }
}
