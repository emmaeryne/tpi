package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SuppressionInvestissementController {

    @FXML
    private TextField idInvestissementTextField;

    @FXML
    private void supprimerInvestissement() {
        // Récupérer l'ID de l'investissement à supprimer
        int idInvestissement = Integer.parseInt(idInvestissementTextField.getText());


        // Effacer le champ de saisie après la suppression
        idInvestissementTextField.clear();


    }
}
