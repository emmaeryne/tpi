package tn.esprit.service;

import tn.esprit.Iservice.InvestisseurService;

import tn.esprit.models.Investisseur;
import tn.esprit.MyDataBase.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class investisseur implements InvestisseurService<investisseur> {

    private Connection cnx;

    public investisseur() {
        this.cnx = MyDataBase.getInstnce().getCnx();
    }

    /*@Override
    public void add(Investisseur investisseur) {
        String query = "INSERT INTO `investisseur`(`nom`, `email`, `compteBancaire`,`Address` , `Contact` ,`SecteurInteret`,`MontantInvestissementMinimum`,`HistoriqueInvestissements`,`MontantInvesti`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, investisseur.getNom());
            stm.setString(3, investisseur.getEmail());
            stm.setInt(4, investisseur.getCompteBancaire());
            stm.setString(4, investisseur.getAddress());
            stm.setString(4, investisseur.getContact());
            stm.setString(4, investisseur.getSecteurInteret());
            stm.setInt(4, investisseur.getMontantInvestissementMinimum());
            stm.setInt(4, investisseur.getMontantInvesti());
            stm.setString(4, investisseur.getHistoriqueInvestissements());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/



    @Override
    public void add(Investisseur investisseur) {
        if (investisseur.getNom() == null || investisseur.getNom().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'investisseur ne peut pas être vide.");
        }

        String query = "INSERT INTO `investisseur`(`nom`, `email`, `compteBancaire`, `Address`, `Contact`, `SecteurInteret`, `MontantInvestissementMinimum`, `HistoriqueInvestissements`, `MontantInvesti`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, investisseur.getNom());
            stm.setString(2, investisseur.getEmail());
            stm.setLong(3, investisseur.getCompteBancaire());
            stm.setString(4, investisseur.getAddress()); // Position 4: Correspond à la colonne "Address"
            stm.setString(5, investisseur.getContact()); // Position 5: Correspond à la colonne "Contact"
            stm.setString(6, investisseur.getSecteurInteret());
            stm.setDouble(7, investisseur.getMontantInvestissementMinimum());
            stm.setString(8, investisseur.getHistoriqueInvestissements());
            stm.setDouble(9, investisseur.getMontantInvesti());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ArrayList<Investisseur> getAll() {
        ArrayList<Investisseur> investisseurs = new ArrayList<>();
        String query = "SELECT * FROM `investisseur`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Investisseur investisseur = new Investisseur();
                investisseur.setId(rs.getInt("id"));
                investisseur.setNom(rs.getString("nom"));
                investisseur.setEmail(rs.getString("email"));
                investisseur.setCompteBancaire(rs.getInt("compteBancaire"));
                investisseur.setAddress(rs.getString("Address")); // Correction de l'orthographe
                investisseur.setContact(rs.getString("contact"));
                investisseur.setSecteurInteret(rs.getString("SecteurInteret"));
                investisseur.setMontantInvestissementMinimum(rs.getInt("MontantInvestissementMinimum"));
                investisseur.setHistoriqueInvestissements(rs.getString("HistoriqueInvestissements"));
                investisseur.setMontantInvesti(rs.getInt("MontantInvesti"));

                investisseurs.add(investisseur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return investisseurs;
    }


    /* @Override
    public ArrayList<Investisseur> getAll() {
        ArrayList<Investisseur> investisseurs = new ArrayList<>();
        String query = "SELECT * FROM `investisseur`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Investisseur investisseur = new Investisseur();
                investisseur.setId(rs.getInt("id"));
                investisseur.setNom(rs.getString("nom"));
                investisseur.setEmail(rs.getString("email"));
                investisseur.setCompteBancaire(rs.getInt("compteBancaire"));
                investisseur.setAddress(rs.getString("Adress"));
                investisseur.setContact(rs.getString("contact"));
                investisseur.setSecteurInteret(rs.getString("SecteurInteret"));
                investisseur.setMontantInvestissementMinimum(rs.getInt("MontantInvestissementMinimum"));
                investisseur.setHistoriqueInvestissements(rs.getString("HistoriqueInvestissements"));
                investisseur.setMontantInvesti(rs.getInt("ontantInvesti"));


                investisseurs.add(investisseur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return investisseurs;
    }

    @Override
    /*public void update(Investisseur updatedInvestisseur) {
        String query = "UPDATE `investisseur` SET `nom`=?, `email`=?, `compteBancaire`=? , `Adress`=? , `Contact`=? , `SecteurInteret`=? , `MontantInvestissementMinimum`=? , `HistoriqueInvestissements`=? , `compteBancaire`=? , `MontantInvesti`=? WHERE `id`=?";
        try {
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, updatedInvestisseur.getNom());
            stm.setString(2, updatedInvestisseur.getEmail());
            stm.setInt(3, updatedInvestisseur.getCompteBancaire());
            stm.setInt(4, updatedInvestisseur.getId());
            stm.setString(4, updatedInvestisseur.getAddress());
            stm.setString(4, updatedInvestisseur.getContact());
            stm.setString(4, updatedInvestisseur.getSecteurInteret());
            stm.setInt(4, updatedInvestisseur.getMontantInvestissementMinimum());
            stm.setString(4, updatedInvestisseur.getHistoriqueInvestissements());
            stm.setInt(4, updatedInvestisseur.getMontantInvesti());

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    public void update(Investisseur investisseur) {
        try (Connection connection = MyDataBase.getInstnce().getCnx()) {
            String query = "UPDATE investisseurs SET nom=?, email=?, compteBancaire=?, Address=?, contact=?, SecteurInteret=?, montantInvestissementMinimum=?, historiqueInvestissements=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, investisseur.getNom());
                preparedStatement.setString(2, investisseur.getEmail());
                preparedStatement.setInt(3, investisseur.getCompteBancaire());
                preparedStatement.setString(4, investisseur.getAddress());
                preparedStatement.setString(5, investisseur.getContact());
                preparedStatement.setString(6, investisseur.getSecteurInteret());
                preparedStatement.setDouble(7, investisseur.getMontantInvestissementMinimum());
                preparedStatement.setString(8, investisseur.getHistoriqueInvestissements());
                preparedStatement.setInt(9, investisseur.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean delete(Investisseur investisseur) {
        String query = "DELETE FROM `investisseur` WHERE `id`=?";
        try {
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setInt(1, investisseur.getId());

            int rowsDeleted = stm.executeUpdate();
            return rowsDeleted > 0; // Return true if at least one row is deleted
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

















    @Override
    public void ajouterInvestisseur(Investisseur investisseur) {
        add(investisseur);
    }

    @Override
    public boolean supprimerInvestisseur(int id) {
        Investisseur investisseur = new Investisseur();
        investisseur.setId(id);
        return delete(investisseur);
    }

    @Override
    public void modifierInvestisseur(Investisseur investisseur) {
        update(investisseur);
    }

    @Override
    public List<Investisseur> getAllInvestisseurs() {
        return getAll();
    }

    @Override
    public Investisseur getInvestisseurById(int id) {

        return null;
    }}


