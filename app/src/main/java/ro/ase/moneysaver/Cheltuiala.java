package ro.ase.moneysaver;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
@Entity(tableName = "cheltuieli")
public class Cheltuiala extends Tranzactie {
    @PrimaryKey(autoGenerate = true)
            private long id;
    @ColumnInfo(name = "esteUrgenta")
boolean esteUrgenta;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public boolean esteUrgenta() {
        return esteUrgenta;
    }
    public void setEsteUrgenta(boolean esteUrgenta) {
        this.esteUrgenta = esteUrgenta;
    }
    public Cheltuiala(double suma, Date data, String descriere, Valuta valuta, Categorie categorie, MetodaPlata metodaPlata, boolean esteUrgenta) {
        super(suma, data, descriere, valuta, categorie, metodaPlata);
        this.esteUrgenta = esteUrgenta;

    }

    @Override
    public String toString() {
        return "Cheltuiala: " + super.toString();
    }
}
