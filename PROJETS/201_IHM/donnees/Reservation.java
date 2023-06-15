package donnees;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Reservation {
	
	public String etat1="Validée";
	public String etat2="Arrivée enregistrée";
	public String etat3="Close";
	
	private String num;
	private Client client;
	private Date dat_arr;
	private Date dat_dep;
	private Date dat_arr_r;
	private Date dat_dep_r;
	private String etat;
	private ArrayList<Chambre> chambres;
	HashMap<Prestation, Date> prestations;
	private String numero_telephone;
	private String ville;
	private String code_postal;
	private String adresse2;
	private String adresse1;
	private String nom;
	
	public Reservation(String num,Client client,Date dat_arr,Date dat_dep){
		this.num=num;
		this.client=client;
		this.dat_arr=dat_arr;
		this.dat_dep=dat_dep;
		etat=etat1;
		chambres = new ArrayList<Chambre>();
		prestations = new HashMap<Prestation,Date>();
	}

	public String getNum() {
		return num;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDat_arr() {
		return dat_arr;
	}

	public void setDat_arr(Date dat_arr) {
		this.dat_arr = dat_arr;
	}

	public Date getDat_dep() {
		return dat_dep;
	}

	public void setDat_dep(Date dat_dep) {
		this.dat_dep = dat_dep;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		if ((etat==etat1)||(etat==etat2)||(etat==etat3)) {
			this.etat = etat;
		}
		else {
			System.out.println("Erreur, l'etat entre est incorrect");
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumero_telephone() {
		return numero_telephone;
	}

	public void setNumero_telephone(String numero_telephone) {
		this.numero_telephone = numero_telephone;
	}

	

	public ArrayList<Chambre> getChambres() {
		return chambres;
	}


	public HashMap<Prestation, Date> getPrestations() {
		return prestations;
	}

}
