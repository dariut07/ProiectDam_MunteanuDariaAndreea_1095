package ro.ase.moneysaver;

import java.util.Date;

enum CategorieVenit{
    Salariu,Cadou,Alte
}
enum ValutaVenit{
    EUR,RON,DOL,CHF
}

public class Venit {
    private double suma;
    private CategorieVenit categorie;
    private ValutaVenit valuta;
    private String descriere;
    private Date data;

    public Venit(double suma, Date data, String descriere, ValutaVenit valuta, CategorieVenit categorie) {
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

    public CategorieVenit getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieVenit categorie) {
        this.categorie = categorie;
    }

    public ValutaVenit getValuta() {
        return valuta;
    }

    public void setValuta(ValutaVenit valuta) {
        this.valuta = valuta;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venit{" +
                "suma=" + suma +
                ", categorie=" + categorie +
                ", valuta=" + valuta +
                ", descriere='" + descriere + '\'' +
                ", data=" + data +
                '}';
    }
}
