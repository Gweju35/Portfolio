package fonctions;

import donnees.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GestionReservation {
    private static GestionReservation instance;
    private ObservableList<Reservation> reservations = FXCollections.observableArrayList();
    private static Reservation TOYSHK;

    public GestionReservation() {
        // Constructeur privé pour empêcher l'instanciation directe
    }

    public static GestionReservation getInstance() {
        if (instance == null) {
            instance = new GestionReservation();
        }
        return instance;
    }

    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public ObservableList<Reservation> getReservations() {
        return reservations;
    }

    public ObservableList<Reservation> rechercherReservationParTelephone(String numeroTelephone) {
        ObservableList<Reservation> liste = FXCollections.observableArrayList();
        for (Reservation reservation : reservations) {
            if (reservation.getClient().getNumero_telephone().equals(numeroTelephone)) {
                liste.add(reservation);
            }
        }
        return liste; // Aucune réservation trouvée
    }
    
    public ObservableList<Reservation> rechercherReservationParNumero(String numero) {
        ObservableList<Reservation> liste = FXCollections.observableArrayList();
        for (Reservation reservation : reservations) {
            if (reservation.getNum() == numero) {
                liste.add(reservation);
            }
        }
        return liste; // Aucune réservation trouvée
    }

    public ObservableList<Reservation> rechercherReservationParNom(String nom) {
        ObservableList<Reservation> liste = FXCollections.observableArrayList();
        for (Reservation reservation : reservations) {
            if (reservation.getClient().getNom().equalsIgnoreCase(nom)) {
                liste.add(reservation);
            }
        }
        return liste; // Aucune réservation trouvée
    }

    public ObservableList<Reservation> rechercherReservationParPrenom(String prenom) {
        ObservableList<Reservation> liste = FXCollections.observableArrayList();
        for (Reservation reservation : reservations) {
            if (reservation.getClient().getPrenom().equalsIgnoreCase(prenom)) {
                liste.add(reservation);
            }
        }
        return liste; // Aucune réservation trouvée
    }


    /*public Reservation rechercherReservation(String critere, String valeur) {
        switch (critere) {
            case "telephone":
                return rechercherReservationParTelephone(valeur);
            case "numeroClient":
                return rechercherReservationParNumero(valeur);
            case "nom":
                return rechercherReservationParNom(valeur);
            case "prenom":
                return rechercherReservationParPrenom(valeur);
            default:
                return null; // Critère de recherche invalide
        }
    }*/
    
    public ObservableList<Reservation> loremator(String num, String nom,String prenom,String tel){
        if (num!="") {
    		this.reservations=(rechercherReservationParNumero(num));
    	}
        else{
            if (nom!=""){
                this.reservations=rechercherReservationParNom(nom);
            }
            if (prenom!=""){
                this.reservations=rechercherReservationParPrenom(prenom);
            }
            if (tel!=""){
                this.reservations=rechercherReservationParTelephone(tel);
            }
        }
        return this.reservations;    	
    }

	public static Reservation getTOYSHK() {
		return TOYSHK;
	}

	public static void setTOYSHK(Reservation tOYSHK) {
		TOYSHK = tOYSHK;
	}


    
}