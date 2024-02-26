package tn.esprit.models;

import java.util.Date;

public class Don {
    private int id;
    private Date date;
    private double montant;
    private String projet;
    private String typeDon;
    private Object donateur;

    public Don(int id, String date, double montant, String projet, String typeDon, String donateur) {
    }

    public String getBeneficiaire() {
        return Beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        Beneficiaire = beneficiaire;
    }

    private String Beneficiaire;



    // Constructeur, getters et setters
    public Don(String johnDoe, int i) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.projet = projet;
        this.typeDon = typeDon;
        this.donateur = donateur;
        this.Beneficiaire=Beneficiaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getTypeDon() {
        return typeDon;
    }

    public void setTypeDon(String typeDon) {
        this.typeDon = typeDon;
    }

    public String getDonateur() {
        return (String) donateur;
    }

    public void setDonateur(Object donateur) {
        this.donateur = donateur;
    }
}
