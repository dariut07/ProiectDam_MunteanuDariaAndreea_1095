package ro.ase.moneysaver;

import java.util.Date;

public class Cheltuiala extends Tranzactie {

    public Cheltuiala(double suma, Date data, String descriere, Valuta valuta, Categorie categorie) {
        super(suma, data, descriere, valuta, categorie);
    }

    @Override
    public String toString() {
        return "Cheltuiala: " + super.toString();
    }
}
