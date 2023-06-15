package donnees;

public class Chambre {
	private String categorie;
	private double prix;
	private int nb_clients;
	private int capacite;
	private String etat_chambre;
	private String numero_chambre;
	public Chambre(String categorie, double prix, int nb_clients, String numero_chambre, int capacite, String etat_chambre) {
		this.numero_chambre = numero_chambre; 
		this.categorie = categorie;
		this.prix = prix;
		this.capacite = capacite;
		this.etat_chambre = etat_chambre;
		this.nb_clients = nb_clients;
	}

	public String getEtat_chambre() {
		return etat_chambre;
	}

	public void setEtat_chambre(String etat_chambre) {
		this.etat_chambre = etat_chambre;
	}

	public int getCapacite() {
		return capacite;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getNb_clients() {
		return nb_clients;
	}
	public void setNb_clients(int nb_clients) {
		this.nb_clients = nb_clients;
	}
	public String getCategorie() {
		return categorie;
	}
	public String getNumero_chambre() {
		return numero_chambre;
	}
	@Override
	public String toString() {
		return "Chambre [categorie=" + categorie + ", prix=" + prix + ", nb_clients=" + nb_clients + ", getPrix()="
				+ getPrix() + ", getNb_clients()=" + getNb_clients() + ", getCategorie()=" + getCategorie()
				+ "]";
	}
	public void verif_numero_chambre() {
		   char premierNumero = this.numero_chambre.charAt(0);
		   int numero = Integer.parseInt(this.numero_chambre.substring(1));
		   if (premierNumero != '0' && premierNumero != '1' && premierNumero != '2') {
		       System.err.println("Erreur, le premier numéro de chambre doit être 0, 1 ou 2");
		   }
		   else if (numero < 1 || numero > 81 ) {
			   System.err.println("Erreur, le numéro de chambre est compris entre 1 et 81);");
		   }
		}
	
}
