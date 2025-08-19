package co.edu.uniquindio.empresa.model;

public class VehiculoPasajeros extends Vehiculo {
    private int numeroPasajeros;

    public VehiculoPasajeros(String placa, String modelo, String marca, String color, int numeroPasajeros) {
        super(placa, modelo, marca, color);
        this.numeroPasajeros = numeroPasajeros;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    @Override
    public String toString() {
        return super.toString() + ", Número de pasajeros: " + numeroPasajeros;
    }
}




