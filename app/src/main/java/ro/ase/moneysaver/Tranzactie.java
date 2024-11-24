package ro.ase.moneysaver;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
enum Categorie {
    Sanatate, Casa, Cadouri, Educatie, Alimete, Salariu, Cadou, Alte
}

 enum Valuta {
    EUR, RON,DOL, CHF
}
@Entity(tableName = "Tranzactii")
public abstract class Tranzactie implements Serializable {
@PrimaryKey(autoGenerate = true)
private long id;

    private double suma;
    private Date data;
    private String descriere;
    private Categorie categorie;
    private Valuta valuta;

    public Tranzactie(double suma, Date data, String descriere, Valuta valuta, Categorie categorie) {
        this.suma = suma;
        this.data = data;
        this.descriere = descriere;
        this.valuta = valuta;
        this.categorie = categorie;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Descriere: %s, Suma: %.2f %s, Categorie: %s, Data: %s",
                descriere, suma, valuta, categorie, sdf.format(data));
    }
}
