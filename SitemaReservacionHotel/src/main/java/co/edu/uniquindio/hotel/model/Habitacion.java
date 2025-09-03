package co.edu.uniquindio.hotel.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Habitacion {
    protected String numero;
    protected double precio;
    protected List<ServicioDeHabitacion> servicios;

    public Habitacion(String numero, double precio) {
        this.numero = numero;
        this.precio = precio;
        this.servicios = new ArrayList<>();
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public List<ServicioDeHabitacion> getServicios() { return servicios; }

    @Override
    public String toString() {
        return "Número='" + numero + '\'' +
                ", Precio=" + precio +
                ", Servicios=" + servicios.size();
    }

}