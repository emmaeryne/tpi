package tn.esprit.service;

import tn.esprit.models.Investisseur;
import java.util.ArrayList;
import java.util.List;

public class SelectionService {

    public static List<Investisseur> selectionnerInvestisseurs(List<Investisseur> investisseurs, String critereSelection) {
        // Initialisation de la liste pour stocker les investisseurs sélectionnés
        List<Investisseur> resultats = new ArrayList<>();

        // Parcours de la liste des investisseurs
        for (Investisseur investisseur : investisseurs) {

            if (investisseur.getMontantInvestissementMinimum() >= Integer.parseInt(critereSelection)) {
                // Si le critère est satisfait, on ajoute l'investisseur à la liste des résultats
                resultats.add(investisseur);
            }
        }
        // Retourne la liste des investisseurs sélectionnés
        return resultats;
    }
}
