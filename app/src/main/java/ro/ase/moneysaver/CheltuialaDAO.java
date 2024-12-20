package ro.ase.moneysaver;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface CheltuialaDAO {
    @Insert
    void insert(Cheltuiala cheltuiala);
    @Query("SELECT * FROM cheltuieli")
    List<Cheltuiala> getAll();
    @Query("SELECT * FROM cheltuieli WHERE id = :id")
    Cheltuiala getById(long id);
    @Query("DELETE FROM cheltuieli WHERE id = :id")
    void deleteById(long id);
    @Query("update cheltuieli set suma=:suma,data=:data,descriere=:descriere,categorie=:categorie,valuta=:valuta,metodaPlata=:metodaPlata,esteUrgenta=:esteUrgenta where id=:id")
    void update(long id, double suma, Date data, String descriere, Categorie categorie, Valuta valuta, MetodaPlata metodaPlata, boolean esteUrgenta);

}
