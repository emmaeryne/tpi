package tn.esprit.test;/* package tn.esprit.test;

import tn.esprit.models.Investisseur;

public class Main {
    public static void main(String[] args) {
        // Création d'un nouvel investisseur avec les champs spécifiés
        Investisseur investisseur = new Investisseur(
                1,                      // id
                "John Doe",             // nom
                "john@example.com",    // email
                123456789,             // compteBancaire
                "123 Street",          // Address
                "1234567890",          // Contact
                "Secteur d'intérêt",   // SecteurInteret
                10000,                  // MontantInvestissementMinimum
                "Historique des investissements" // HistoriqueInvestissements
        );

        // Affichage des informations de l'investisseur
        System.out.println("Informations de l'investisseur :");
        System.out.println("ID : " + investisseur.getId());
        System.out.println("Nom : " + investisseur.getNom());
        System.out.println("Email : " + investisseur.getEmail());
        System.out.println("Compte bancaire : " + investisseur.getCompteBancaire());
        System.out.println("Adresse : " + investisseur.getAddress());
        System.out.println("Contact : " + investisseur.getContact());
        System.out.println("Secteur d'intérêt : " + investisseur.getSecteurInteret());
        System.out.println("Montant d'investissement minimum : " + investisseur.getMontantInvestissementMinimum());
        System.out.println("Historique des investissements : " + investisseur.getHistoriqueInvestissements());
    }
}*/

/*
package tn.esprit.test;

import tn.esprit.Iservice.DonService;
import tn.esprit.models.Don;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Créer une instance de DonService
        DonService donService = new DonService() {
            @Override
            public void ajouterDon(Don don) {

            }

            @Override
            public void supprimerDon(int id) {

            }

            @Override
            public void modifierDon(Don don) {

            }

            @Override
            public List<Don> getAllDons() {
                return null;
            }

            @Override
            public Don getDonById(int id) {
                return null;
            }

            @Override
            public void enregistrerDon(Don nouveauDon) {

            }

            @Override
            public void updateDon(Don donRecupere) {

            }

            @Override
            public boolean deleteDon(int idDonASupprimer) {
                return false;
            }
        };

        // Créer un nouveau don
        Don nouveauDon = new Don();
        nouveauDon.setDate(new java.util.Date());
        nouveauDon.setMontant(100.0);
        nouveauDon.setProjet("Projet A");
        nouveauDon.setTypeDon("Type A");
        nouveauDon.setDonateur("Donateur A");
        nouveauDon.setBeneficiaire("Bénéficiaire A");

        // Enregistrer le don
        donService.enregistrerDon(nouveauDon);
        System.out.println("Don enregistré avec succès.");

        // Récupérer un don par son ID
        int idDon = 1; // À modifier selon l'ID du don que vous souhaitez récupérer
        Don donRecupere = donService.getDonById(idDon);
        if (donRecupere != null) {
            System.out.println("Don récupéré : " + donRecupere);
        } else {
            System.out.println("Aucun don trouvé avec l'ID : " + idDon);
        }

        // Récupérer tous les dons
        System.out.println("Liste des dons :");
        for (Don don : donService.getAllDons()) {
            System.out.println(don);
        }

        // Modifier un don existant
        if (donRecupere != null) {
            donRecupere.setMontant(150.0); // Modifier le montant (exemple)
            donService.updateDon(donRecupere);
            System.out.println("Don mis à jour avec succès.");
        }

        // Supprimer un don
        int idDonASupprimer = 2; // À modifier selon l'ID du don que vous souhaitez supprimer
        if (donService.deleteDon(idDonASupprimer)) {
            System.out.println("Don avec l'ID " + idDonASupprimer + " supprimé avec succès.");
        } else {
            System.out.println("Impossible de supprimer le don avec l'ID " + idDonASupprimer);
        }

    }
}*/



/*import tn.esprit.models.Investisseur;
import tn.esprit.service.investisseur;

public class Main {
    public static void main(String[] args) {
        // Création d'un nouvel investisseur
        Investisseur investisseur = new Investisseur(
                1,                      // id
                "John Doe",             // nom
                "john@example.com",     // email
                123456789,              // compteBancaire
                "123 Street",           // Address
                "1234567890",           // Contact
                "Secteur d'intérêt",    // SecteurInteret
                10000,                  // MontantInvestissementMinimum
                "Historique des investissements" // HistoriqueInvestissements
        );

        // Appel de la méthode pour enregistrer l'investisseur
        investisseur investisseurService = new investisseur();
        investisseurService.update(investisseur);

        // ID de l'investisseur à supprimer
        int idInvestisseurASupprimer = 1; // À remplacer par l'ID de l'investisseur que vous souhaitez supprimer

        // Appel de la méthode pour supprimer l'investisseur
        boolean suppressionReussie = investisseurService.supprimerInvestisseur(idInvestisseurASupprimer);

        if (suppressionReussie) {
            System.out.println("Investisseur avec l'ID " + idInvestisseurASupprimer + " supprimé avec succès.");
        } else {
            System.out.println("Impossible de supprimer l'investisseur avec l'ID " + idInvestisseurASupprimer);
        }
    }
}
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tn.esprit.models.Investisseur;
import tn.esprit.service.FiltreService;
import tn.esprit.service.SelectionService;
import tn.esprit.service.investisseur;
import tn.esprit.models.Don;
import tn.esprit.service.RechercheService;

public class Main {
    public static void main(String[] args) {
        investisseur investisseurService = new investisseur();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterInvestisseur(investisseurService, scanner);
                    break;
                case 2:
                    supprimerInvestisseur(investisseurService, scanner);
                    break;
                case 3:
                    mettreAJourInvestisseur(investisseurService, scanner);
                    break;
                case 4:
                    rechercherDons(scanner);
                    break;
                case 5:
                    //SelectionService(investisseurService, scanner);
                    break;

                case 7:
                    filtrerInvestisseurs(investisseurService, scanner);
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
                    break;
            }
        } while (choix != 6);
    }

    private static void afficherMenu() {
        System.out.println("Menu:");
        System.out.println("1. Ajouter un investisseur");
        System.out.println("2. Supprimer un investisseur");
        System.out.println("3. Mettre à jour un investisseur");
        System.out.println("4. Rechercher des dons");
        System.out.println("5. Sélectionner un service");
        System.out.println("7. Filtrer des investisseurs");
        System.out.println("6. Quitter");
        System.out.print("Choisissez une option : ");
    }

    private static void ajouterInvestisseur(investisseur service, Scanner scanner) {
        System.out.println("Ajout d'un nouvel investisseur :");
        Investisseur nouvelInvestisseur = new Investisseur();

        // Saisie du nom
        String nom;
        do {
            System.out.print("Nom : ");
            nom = scanner.nextLine().trim();
            if (nom.isEmpty()) {
                System.out.println("Le nom ne peut pas être vide. Veuillez saisir à nouveau.");
            }
        } while (nom.isEmpty());
        nouvelInvestisseur.setNom(nom);

        // Saisie de l'email
        String email;
        do {
            System.out.print("Email : ");
            email = scanner.nextLine().trim();
            if (email.isEmpty() || !email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
                System.out.println("Veuillez saisir une adresse email valide. (ex: exemple@gmail.com)");
            }
        } while (email.isEmpty() || !email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"));
        nouvelInvestisseur.setEmail(email);

        // Saisie du compte bancaire
        double compteBancaire;
        do {
            System.out.print("Compte bancaire : ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Veuillez saisir un nombre décimal pour le compte bancaire.");
                scanner.next();
            }
            compteBancaire = scanner.nextDouble();
            scanner.nextLine();
            if (compteBancaire <= 0) {
                System.out.println("Le compte bancaire ne peut pas être négatif ou nul. Veuillez saisir à nouveau.");
            }
        } while (compteBancaire <= 0);
        nouvelInvestisseur.setCompteBancaire(compteBancaire);

        // Saisie de l'adresse
        System.out.print("Adresse : ");
        nouvelInvestisseur.setAddress(scanner.nextLine());

        // Saisie du contact
        String contact;
        do {
            System.out.print("Contact (numéro de téléphone) : ");
            contact = scanner.nextLine().trim();
            if (!contact.matches("\\d{8}")) {
                System.out.println("Veuillez saisir un numéro de téléphone valide composé de 8 chiffres.");
            }
        } while (!contact.matches("\\d{8}"));
        nouvelInvestisseur.setContact(contact);

        // Saisie du secteur d'intérêt
        System.out.print("Secteur d'intérêt : ");
        nouvelInvestisseur.setSecteurInteret(scanner.nextLine());

        // Saisie du montant investissement minimum
        int montantInvestissementMinimum;
        do {
            System.out.print("Montant investissement minimum : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez saisir un nombre entier pour le montant investissement minimum.");
                scanner.next(); // Consomme l'entrée invalide
            }
            montantInvestissementMinimum = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne en trop
            if (montantInvestissementMinimum <= 0) {
                System.out.println("Le montant investissement minimum ne peut pas être négatif ou nul. Veuillez saisir à nouveau.");
            }
        } while (montantInvestissementMinimum <= 0);
        nouvelInvestisseur.setMontantInvestissementMinimum(montantInvestissementMinimum);

        // Saisie de l'historique des investissements
        System.out.print("Historique des investissements : ");
        nouvelInvestisseur.setHistoriqueInvestissements(scanner.nextLine());

        // Saisie du montant investi
        int montantInvesti;
        do {
            System.out.print("Montant investi : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez saisir un nombre entier pour le montant investi.");
                scanner.next(); // Consomme l'entrée invalide
            }
            montantInvesti = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne en trop
            if (montantInvesti < 0) {
                System.out.println("Le montant investi ne peut pas être négatif. Veuillez saisir à nouveau.");
            }
        } while (montantInvesti < 0);
        nouvelInvestisseur.setMontantInvesti(montantInvesti);

        // Ajout de l'investisseur avec les données saisies
        service.add(nouvelInvestisseur);
        System.out.println("Investisseur ajouté avec succès.");
    }


    private static void supprimerInvestisseur(investisseur service, Scanner scanner) {
        System.out.println("Suppression d'un investisseur :");
        System.out.print("ID de l'investisseur à supprimer : ");
        int id = scanner.nextInt();
        Investisseur investisseurASupprimer = new Investisseur();
        investisseurASupprimer.setId(id);
        boolean suppressionReussie = service.delete(investisseurASupprimer);
        if (suppressionReussie) {
            System.out.println("Investisseur avec l'ID " + id + " supprimé avec succès.");
        } else {
            System.out.println("Impossible de supprimer l'investisseur avec l'ID " + id);
        }
    }

    private static void mettreAJourInvestisseur(investisseur service, Scanner scanner) {
        System.out.println("Mise à jour d'un investisseur :");
        System.out.print("ID de l'investisseur à mettre à jour : ");
        int id = scanner.nextInt();
        Investisseur investisseurAModifier = new Investisseur();
        investisseurAModifier.setId(id);
        scanner.nextLine(); // Consommer la ligne en trop
        System.out.print("Nouveau nom : ");
        investisseurAModifier.setNom(scanner.nextLine());
        System.out.print("Nouvel email : ");
        investisseurAModifier.setEmail(scanner.nextLine());
        System.out.print("Nouveau compte bancaire : ");
        investisseurAModifier.setCompteBancaire((int) scanner.nextLong());
        scanner.nextLine(); // Consommer la ligne en trop
        System.out.print("Nouvelle adresse : ");
        investisseurAModifier.setAddress(scanner.nextLine());
        System.out.print("Nouveau contact : ");
        investisseurAModifier.setContact(scanner.nextLine());
        System.out.print("Nouveau secteur d'intérêt : ");
        investisseurAModifier.setSecteurInteret(scanner.nextLine());
        System.out.print("Nouveau montant investissement minimum : ");
        investisseurAModifier.setMontantInvestissementMinimum((int) scanner.nextDouble());
        scanner.nextLine(); // Consommer la ligne en trop
        System.out.print("Nouvel historique des investissements : ");
        investisseurAModifier.setHistoriqueInvestissements(scanner.nextLine());
        System.out.print("Nouveau montant investi : ");
        investisseurAModifier.setMontantInvesti(scanner.nextInt());

        service.update(investisseurAModifier);
        System.out.println("Investisseur mis à jour avec succès.");
    }

    private static void rechercherDons(Scanner scanner) {
        // Création d'une liste de dons (exemple)
        List<Don> listeDons = new ArrayList<>();
        listeDons.add(new Don("John Doe", 1000));
        listeDons.add(new Don("Jane Smith", 200));
        listeDons.add(new Don("Alice Johnson", 150));

        // Critère de recherche (exemple : nom du donateur)
        System.out.print("Entrez le critère de recherche : ");
        String critereRecherche = scanner.nextLine();

        // Appel de la méthode rechercherDons de RechercheService
        List<Don> resultatsRecherche = RechercheService.rechercherDons(listeDons, critereRecherche);

        // Affichage des résultats de la recherche
        System.out.println("Résultats de la recherche :");
        for (Don don : resultatsRecherche) {
            System.out.println(don);
        }
    }

    private static void filtrerInvestisseurs(investisseur service, Scanner scanner) {
        System.out.println("Filtrer des investisseurs :");
        System.out.print("Entrez le critère de filtrage : ");
        String critereFiltre = scanner.nextLine();
        List<Investisseur> investisseursFiltres = FiltreService.filtrerInvestisseurs(service.getAll(), critereFiltre);
        if (!investisseursFiltres.isEmpty()) {
            System.out.println("Résultats du filtrage :");
            for (Investisseur investisseur : investisseursFiltres) {
                System.out.println(investisseur);
            }
        } else {
            System.out.println("Aucun résultat trouvé pour le critère de filtrage spécifié.");
        }
    }
}
