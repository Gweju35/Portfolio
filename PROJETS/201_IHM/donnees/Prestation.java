package donnees;

import java.util.Date;

public class Prestation {

    private String type;
    private float prixHT;
    private String libelle;
   
    public String getType() {
        return type;
    }
   
     public void setType(String type) {
            if (type.equals("Pressing") || type.equals("Consommation au bar") || type.equals("Consommation en chambre")) {
                this.type = type;
            } else {
                System.out.println("Erreur: le type de la prestation n'existe pas");
            }
     }
   
    public float getPrixHT() {
        return prixHT;
    }
   
    public void setPrixHT(float prix) {
        if (prix > 999) {
            System.out.println("Erreur : Le prix ne peut pas dépasser 999 euros.");
        } else {
            prixHT = prix;
        }
        }
   
    public void setPrixHtHaussePourcentage(float pourcentage) {
        prixHT=prixHT+(prixHT*pourcentage/100);
    }
   
    public void setPrixHtBaissePourcentage(float pourcentage) {
        prixHT=prixHT-(prixHT*pourcentage/100);

    }
   
    public String getLibelle() {
        return libelle;
    }
   
    public Prestation(String type, float prix, String libelle) {
        this.type = type;
         if (prix > 999) {
                System.out.println("Erreur : Le prix ne peut pas dépasser 999 euros.");
            } else {
                prixHT = prix;
            }
         if (type.equals("Pressing") || type.equals("Consommation au bar") || type.equals("Consommation en chambre")) {
                this.type = type;
            } else {
                System.out.println("Erreur: le type de la prestation n'existe pas");
            }
   
    }

    public String toString() {
        if(this.libelle==null) {
            return "Type:" +type + "Prix Hors taxe :" + prixHT;
        }
        else {
            return "Type:" + type + "Prix Hors taxe :" + prixHT + "Libelle=" + libelle;
        }
    }
   
    public void affichePresta() {
        if (this.libelle==null){
            System.out.println("Type:" + this.type + "Prix Hors taxe :" + this.prixHT);
        }
        else {
            System.out.println("Type:" + this.type + "Libelle :"+ this.libelle + "Prix Hors taxe :" + this.prixHT);
        }
    }
   
}