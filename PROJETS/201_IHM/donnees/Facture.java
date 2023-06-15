package donnees;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Facture {
    private double montantDu;
    private double montantPaye;
    private LocalDate datePaiement;

    public Facture(double montantDu) {
        this.montantDu = Math.abs(montantDu);
        this.montantPaye = this.montantDu;
        this.datePaiement = LocalDate.now();
    }

    public double getMontantDu() {
        return montantDu;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = Math.abs(montantPaye);
    }

    public void afficherFacture() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Facture du " + dateFormatter.format(datePaiement));
        System.out.println("Montant dû: " + decimalFormat.format(montantDu) + " €");
        System.out.println("Montant payé: " + decimalFormat.format(montantPaye) + " €");
    }
}