package donnees;

public class Client {
	private Integer num;
	private String civilite;
	private String nom;
	private String prenom;
	private String adresse1;
	private String adresse2; 
	private String code_postal;
	private String ville;
	private String numero_telephone; 
	private String adresse_mail;

	public Client(Integer num,String civilite, String nom,String prenom, String adresse1, String adresse2, String code_postal, String ville,
			String numero_telephone, String adresse_mail) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.code_postal = code_postal;
		this.ville = ville;
		this.numero_telephone = numero_telephone;
		this.adresse_mail = adresse_mail;
		this.prenom=prenom;
		this.num=num;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
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

	public String getAdresse_mail() {
		return adresse_mail;
	}

	public void setAdresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}

	public String toString() {
		return "Client [civilite=" + civilite + ", nom=" + nom + ", adresse1=" + adresse1 + ", adresse2=" + adresse2
				+ ", code_postal=" + code_postal + ", ville=" + ville + ", numero_telephone=" + numero_telephone
				+ ", adresse_mail=" + adresse_mail + "]";
	}

	public boolean estValide() {
		if (!civilite.equals("Madame") && !civilite.equals("Monsieur")) {
			return false;
		}

		if (nom == null || nom.isEmpty()) {
			return false;
		}

		if ((adresse1 == null || adresse1.isEmpty()) && (adresse2 == null || adresse2.isEmpty())) {
			return false;
		}

		if (code_postal == null || code_postal.isEmpty()) {
			return false;
		}

		if (ville == null || ville.isEmpty()) {
			return false;
		}

		if (numero_telephone == null || numero_telephone.isEmpty()) {
			return false;
		}

		if (adresse_mail == null || adresse_mail.isEmpty()) {
			return false;
		}

		if (adresse1 != null && adresse1.length() > 32) {
			return false;
		}

		if (adresse2 != null && adresse2.length() > 32) {
			return false;
		}

		if (!adresse_mail.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
			return false;
		}
		
		 if (!numero_telephone.matches("^\\+[0-9]{1,3}[0-9]{4,}$")) {
		        return false;
		    }
		 
		 if (!code_postal.matches("^[0-9a-zA-Z]{1,10}$")) {
		        return false;
		    }

		return true;
	}

	public Integer getNum() {
		return num;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}