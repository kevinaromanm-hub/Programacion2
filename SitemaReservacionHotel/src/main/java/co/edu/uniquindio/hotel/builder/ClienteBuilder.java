
package co.edu.uniquindio.hotel.builder;

import co.edu.uniquindio.hotel.model.Cliente;

public class ClienteBuilder {
    private String id;
    private String nombre = null;
    private String telefono = null;
    private String correo = null;
    private int edad = 0;

    public ClienteBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ClienteBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public ClienteBuilder edad(int edad) {
        this.edad = edad;
        return this;
    }

    public Cliente build() {
        return new Cliente(nombre, id, telefono, correo, edad);
    }
}
