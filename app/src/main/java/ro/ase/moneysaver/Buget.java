package ro.ase.moneysaver;

public class Buget {
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
