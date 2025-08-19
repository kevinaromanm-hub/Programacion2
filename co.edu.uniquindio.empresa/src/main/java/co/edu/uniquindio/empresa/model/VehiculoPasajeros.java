package co.edu.uniquindio.empresa.model;

public class VehiculoPasajeros extends Vehiculo {
    private int maxPasajeros;
    private int pasajerosHoy;

    public VehiculoPasajeros(String placa, String modelo, String marca, String color, int maxPasajeros, int pasajerosHoy) {
        super(placa, modelo, marca, color);
        this.maxPasajeros = maxPasajeros;
        this.pasajerosHoy = pasajerosHoy;
    }

    public int getMaxPasajeros()
    {
        return maxPasajeros;
    }
    public int getPasajerosHoy()
    {
        return pasajerosHoy;
    }
    public void setPasajerosHoy(int pasajerosHoy) { this.pasajerosHoy = pasajerosHoy; }

    @Override
    public String toString()
    {
        return super.toString() + " [Pasajeros máx: " + maxPasajeros + ", Hoy: " + pasajerosHoy + "]";
    }
}








