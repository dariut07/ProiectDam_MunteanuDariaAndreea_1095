package ro.ase.moneysaver;

import java.util.Date;

public class Venit extends Tranzactie {

    public Venit(double suma, Date data, String descriere, Valuta valuta, Categorie categorie) {
        super(suma, data, descriere, valuta, categorie);
    }

    @Override
    public String toString() {
        return "Venit: " + super.toString();
    }
}
