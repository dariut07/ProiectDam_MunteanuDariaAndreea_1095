package ro.ase.moneysaver;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BugetDAO {
    @Insert
    void insertBuget(Buget buget);
    @Query("select * from bugete")
    List<Buget> getAll();
    @Query("SELECT * FROM bugete WHERE idBuget = :idCautat")
    Buget getById(int idCautat);
    @Query("DELETE FROM bugete")
    void deleteAll();
    @Query("DELETE FROM bugete WHERE idBuget = :id")
    void deleteBugetById(long id);
    @Query("UPDATE bugete SET suma = :suma WHERE idBuget = :id")
    void updateBuget(float suma, long id);

}
