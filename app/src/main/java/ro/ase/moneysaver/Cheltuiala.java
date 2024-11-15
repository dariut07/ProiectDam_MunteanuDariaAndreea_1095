package ro.ase.moneysaver;

import java.util.Date;

enum Categorie{
    Sanatate,Casa,Cadouri,Educatie,Alimente

}
enum Valuta{
    EUR,RON,DOL,CHF
        }
public class Cheltuiala {
    private double suma;
    private Categorie categorie;
    private Valuta valuta;
    private Date data;
private String descriere;

    public Cheltuiala(String descriere, Date data, Valuta valuta, Categorie categorie, double suma) {
        this.descriere = descriere;
        this.data = data;
        this.valuta = valuta;
        this.categorie = categorie;
        this.suma = suma;
    }

    public double getSuma() {
        return suma;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public Date getData() {
        return data;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Cheltuiala{" +
                "suma=" + suma +
                ", categorie=" + categorie +
                ", valuta=" + valuta +
                ", data=" + data +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
