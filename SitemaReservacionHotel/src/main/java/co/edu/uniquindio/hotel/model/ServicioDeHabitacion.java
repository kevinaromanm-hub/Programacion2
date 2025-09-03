package co.edu.uniquindio.hotel.model;

import co.edu.uniquindio.hotel.services.IConsumible;

public class ServicioDeHabitacion extends Servicio implements IConsumible {
    private String idServicio;
    private String descripcion;

    public ServicioDeHabitacion(String idServicio, String nombre, double precio, String descripcion) {
        super(nombre, precio);
        this.idServicio = idServicio;
        this.descripcion = descripcion;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void consumir() {
        System.out.println("Consumiendo el servicio de habitación: " + getNombre());
    }

    @Override
    public String toString() {
        return "ServicioDeHabitacion: " +
                "ID=" + idServicio +
                ", " + super.toString() +
                ", Descripción=" + descripcion;
    }
}
