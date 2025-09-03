package co.edu.uniquindio.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String id;
    private String telefono;
    private String correo;
    private int edad;
    private List<Reserva> reservas;

    public Cliente(String nombre, String id, String telefono, String correo, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
        this.reservas = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public List<Reserva> getReservas() { return reservas; }


    @Override
    public String toString() {
        return "Cliente {" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Correo='" + correo + '\'' +
                ", Edad=" + edad +
                '}';
    }

}
