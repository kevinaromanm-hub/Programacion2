package co.edu.uniquindio.transporte.model;


import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private String nombre;
    private String numeroIdentificacion;
    private String email;
    private String numeroCelular;
    private int edad;
    private List<Vehiculo> listaVehiculosAsociados = new ArrayList<>();

    public Propietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int edad){
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.edad = edad;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) { this.numeroIdentificacion = numeroIdentificacion; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNumeroCelular() { return numeroCelular; }
    public void setNumeroCelular(String numeroCelular) { this.numeroCelular = numeroCelular; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public List<Vehiculo> getListaVehiculosAsociados() { return listaVehiculosAsociados; }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", email='" + email + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                ", edad=" + edad +
                '}';
    }
}

