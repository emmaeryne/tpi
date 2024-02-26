package tn.esprit.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class mainFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        primaryStage.setTitle("Menu de Choix");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void afficherInterfaceSuppressionInvestissement() throws IOException {
        Parent suppressionInvestissementParent = FXMLLoader.load(getClass().getResource("suppressioninvestissement.fxml"));
        Scene suppressionInvestissementScene = new Scene(suppressionInvestissementParent);
        Stage stage = new Stage();
        stage.setTitle("Supprimer Investissement");
        stage.setScene(suppressionInvestissementScene);
        stage.show();
    }

    public void afficherInterfaceAjoutInvestissement() throws IOException {
        Parent ajoutInvestissementParent = FXMLLoader.load(getClass().getResource("ajoutinvestissement.fxml"));
        Scene ajoutInvestissementScene = new Scene(ajoutInvestissementParent);
        Stage stage = new Stage();
        stage.setTitle("Ajouter Investissement");
        stage.setScene(ajoutInvestissementScene);
        stage.show();
    }

    public void afficherInterfaceAjoutDon() throws IOException {
        Parent ajoutDonParent = FXMLLoader.load(getClass().getResource("ajoutdon.fxml"));
        Scene ajoutDonScene = new Scene(ajoutDonParent);
        Stage stage = new Stage();
        stage.setTitle("Ajouter Don");
        stage.setScene(ajoutDonScene);
        stage.show();
    }

    public void afficherInterfaceAjoutInvestisseur() throws IOException {
        Parent ajoutInvestisseurParent = FXMLLoader.load(getClass().getResource("ajoutinvestisseur.fxml"));
        Scene ajoutInvestisseurScene = new Scene(ajoutInvestisseurParent);
        Stage stage = new Stage();
        stage.setTitle("Ajouter Investisseur");
        stage.setScene(ajoutInvestisseurScene);
        stage.show();
    }
}

