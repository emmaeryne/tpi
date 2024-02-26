package tn.esprit.service;

import tn.esprit.models.Don;
import java.util.ArrayList;
import java.util.List;

public class RechercheService {
    public static List<Don> rechercherDons(List<Don> dons, String critereRecherche) {
        List<Don> resultats = new ArrayList<>();
        for (Don don : dons) {
            // Vérifier si le donateur est null avant d'appeler equalsIgnoreCase()
            if (don.getDonateur() != null && don.getDonateur().equalsIgnoreCase(critereRecherche)) {
                resultats.add(don);
            }
        }
        return resultats;
    }
}

