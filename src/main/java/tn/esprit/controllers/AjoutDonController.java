package tn.esprit.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AjoutDonController {

    @FXML
    private TextField idTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField montantTextField;

    @FXML
    private TextField projetTextField;

    @FXML
    private TextField typeDonTextField;

    @FXML
    private TextField donateurTextField;

    @FXML
    private void ajouterDon() {
        // Récupérer les valeurs des champs
        int id = Integer.parseInt(idTextField.getText());
        String date = dateTextField.getText();
        double montant = Double.parseDouble(montantTextField.getText());
        String projet = projetTextField.getText();
        String typeDon = typeDonTextField.getText();
        String donateur = donateurTextField.getText();



        // Effacer les champs après l'ajout
        idTextField.clear();
        dateTextField.clear();
        montantTextField.clear();
        projetTextField.clear();
        typeDonTextField.clear();
        donateurTextField.clear();


    }
}