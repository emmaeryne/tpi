package tn.esprit.models;

public class Investisseur {

    private int id;
    private String nom;
    private String email;
    private int compteBancaire;
    private String Address;
    private String Contact;
    private String SecteurInteret;
    private int MontantInvestissementMinimum;
    private String HistoriqueInvestissements;
    private int MontantInvesti;

    public Investisseur() {
    }

    public Investisseur(String nom, String email, int compteBancaire, String address, String contact, String secteurInteret, int montantInvestissementMinimum, String historiqueInvestissements) {
        this.nom = nom;
        this.email = email;
        this.compteBancaire = compteBancaire;
        this.Address = address;
        this.Contact = contact;
        this.SecteurInteret = secteurInteret;
        this.MontantInvestissementMinimum = montantInvestissementMinimum;
        this.HistoriqueInvestissements = historiqueInvestissements;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(int compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        this.Contact = contact;
    }

    public String getSecteurInteret() {
        return SecteurInteret;
    }

    public void setSecteurInteret(String secteurInteret) {
        this.SecteurInteret = secteurInteret;
    }

    public int getMontantInvestissementMinimum() {
        return MontantInvestissementMinimum;
    }

    public void setMontantInvestissementMinimum(int montantInvestissementMinimum) {
        this.MontantInvestissementMinimum = montantInvestissementMinimum;
    }

    public String getHistoriqueInvestissements() {
        return HistoriqueInvestissements;
    }

    public void setHistoriqueInvestissements(String historiqueInvestissements) {
        this.HistoriqueInvestissements = historiqueInvestissements;
    }

    public int getMontantInvesti() {
        return MontantInvesti;
    }

    public void setMontantInvesti(int montantInvesti) {
        this.MontantInvesti = montantInvesti;
    }

    @Override
    public String toString() {
        return "Investisseur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", compteBancaire=" + compteBancaire +
                '}';
    }

    public void setCompteBancaire(double v) {
    }

    public void setMontantInvestissementMinimum(double v) {
    }
}
