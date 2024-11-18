package ro.ase.moneysaver;

import java.io.Serializable;

public class Buget implements Serializable
{
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

    @Override
    public String toString() {
        return "Buget{" +
                "suma=" + suma +
                '}';
    }
}
