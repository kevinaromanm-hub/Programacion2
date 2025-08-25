package co.edu.uniquindio.transporte.model;

public class VehiculoCarga extends Vehiculo {
    private double capacidadCarga;
    private int numeroEjes;

    public VehiculoCarga(String placa, String modelo, String marca, String color, double capacidadCarga, int numeroEjes){
        super(placa, modelo, marca, color);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    public double getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(double capacidadCarga) { this.capacidadCarga = capacidadCarga; }
    public int getNumeroEjes() { return numeroEjes; }
    public void setNumeroEjes(int numeroEjes) { this.numeroEjes = numeroEjes; }

    @Override
    public String toString(){
        return super.toString() + ", CapacidadCarga: " + capacidadCarga + ", Ejes: " + numeroEjes;
    }
}
