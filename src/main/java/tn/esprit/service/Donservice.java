package tn.esprit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.esprit.MyDataBase.MyDataBase;
import tn.esprit.models.Don;

class DonService {

    private MyDataBase myDataBase;

    public DonService() {
        // Initier la base de données
        myDataBase = MyDataBase.getInstnce();
    }

    public void enregistrerDon(Don don) {
        try (Connection connection = myDataBase.getCnx()  ) {
            String query = "INSERT INTO dons (date, montant, projet, typeDon, donateur, beneficiaire) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDate(1, new java.sql.Date(don.getDate().getTime()));
                preparedStatement.setDouble(2, don.getMontant());
                preparedStatement.setString(3, don.getProjet());
                preparedStatement.setString(4, don.getTypeDon());
                preparedStatement.setString(5, don.getDonateur().toString());
                preparedStatement.setString(6, don.getBeneficiaire());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Don getDonById(int id) {
        Don don = null;
        try (Connection connection = myDataBase.getCnx() ) {
            String query = "SELECT * FROM dons WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        don = mapResultSetToDon(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return don;
    }

    /*public List<Don> getAllDons() {
        List<Don> dons = new ArrayList<>();
        try (Connection connection = myDataBase.getCnx()) {
            String query = "SELECT * FROM dons";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Don don = mapResultSetToDon(resultSet);
                        dons.add(don);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Vérifier si la liste est null et la remplacer par une liste vide si nécessaire
        if (dons == null) {
            dons = new ArrayList<>();
        }
        return dons;
    }*/
    public List<Don> getAllDons() {
        List<Don> dons = new ArrayList<>();
        try (Connection connection = myDataBase.getCnx()) {
            String query = "SELECT * FROM dons";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Don don = mapResultSetToDon(resultSet);
                        dons.add(don);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dons; // Renvoyer une liste vide si aucun don n'est trouvé
    }





    public void updateDon(Don updatedDon) {
        try (Connection connection = myDataBase.getCnx()) {
            String query = "UPDATE dons SET date=?, montant=?, projet=?, typeDon=?, donateur=?, beneficiaire=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDate(1, new java.sql.Date(updatedDon.getDate().getTime()));
                preparedStatement.setDouble(2, updatedDon.getMontant());
                preparedStatement.setString(3, updatedDon.getProjet());
                preparedStatement.setString(4, updatedDon.getTypeDon());
                preparedStatement.setString(5, updatedDon.getDonateur().toString());
                preparedStatement.setString(6, updatedDon.getBeneficiaire());
                preparedStatement.setInt(7, updatedDon.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteDon(int id) {
        try (Connection connection = myDataBase.getCnx()) {
            String query = "DELETE FROM dons WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);

                int rowsDeleted = preparedStatement.executeUpdate();
                return rowsDeleted > 0; // Return true if at least one row is deleted
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Don mapResultSetToDon(ResultSet resultSet) throws SQLException {
        Don don = new Don("John Doe", 1000);
        don.setId(resultSet.getInt("id"));
        don.setDate(resultSet.getDate("date"));
        don.setMontant(resultSet.getDouble("montant"));
        don.setProjet(resultSet.getString("projet"));
        don.setTypeDon(resultSet.getString("typeDon"));
        don.setDonateur(resultSet.getString("donateur"));
        don.setBeneficiaire(resultSet.getString("beneficiaire"));
        return don;
    }
}
