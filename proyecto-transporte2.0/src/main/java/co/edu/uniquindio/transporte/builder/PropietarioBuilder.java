package co.edu.uniquindio.transporte.builder;

import co.edu.uniquindio.transporte.model.Propietario;

public class PropietarioBuilder {

    private String nombre;
    private String numeroIdentificacion;
    private String email;
    private String numeroCelular;
    private int edad; // 0 significa no definido

    public PropietarioBuilder() {
    }

    public PropietarioBuilder conNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
        return this;
    }

    public PropietarioBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        if (numeroIdentificacion != null && !numeroIdentificacion.isEmpty()) {
            this.numeroIdentificacion = numeroIdentificacion;
        }
        return this;
    }

    public PropietarioBuilder conEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
        return this;
    }

    public PropietarioBuilder conNumeroCelular(String numeroCelular) {
        if (numeroCelular != null && !numeroCelular.isEmpty()) {
            this.numeroCelular = numeroCelular;
        }
        return this;
    }

    public PropietarioBuilder conEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        }
        return this;
    }

    public Propietario construir() {
        return new Propietario(
                this.nombre,
                this.numeroIdentificacion,
                this.email,
                this.numeroCelular,
                this.edad
        );
    }
}

