package ro.ase.moneysaver;

import java.io.Serializable;

public class Buget implements Serializable
{
    private double suma;

    public Buget(double suma) {
        this.suma = suma;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "Buget{" +
                "suma=" + suma +
                '}';
    }
}
