package ro.ase.moneysaver;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "bugete")
public class Buget implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private long idBuget;
    private float suma;

    public Buget(float suma) {
        this.suma = suma;
    }

    public float getSuma() {
        return suma;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }
public long getIdBuget() {
        return idBuget;

}
public void setIdBuget(long idBuget) {
        this.idBuget = idBuget;
}

    @Override
    public String toString() {
        return "Buget{" +
                "idBuget=" + idBuget +
                ", suma=" + suma +
                '}';
    }
}
