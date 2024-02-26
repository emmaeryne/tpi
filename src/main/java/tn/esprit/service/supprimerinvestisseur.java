package tn.esprit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tn.esprit.MyDataBase.MyDataBase;

public class supprimerinvestisseur {

    private MyDataBase myDataBase;

    public supprimerinvestisseur() {
        // Initialiser la base de données
        myDataBase = MyDataBase.getInstnce();
    }

    public boolean supprimerInvestisseur(int idInvestisseur) {
        try (Connection connection = myDataBase.getCnx()) {
            String query = "DELETE FROM investisseurs WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idInvestisseur);

                int rowsDeleted = preparedStatement.executeUpdate();
                return rowsDeleted > 0; // Retourne true si au moins une ligne est supprimée
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retourne false en cas d'erreur
        }
    }
}
