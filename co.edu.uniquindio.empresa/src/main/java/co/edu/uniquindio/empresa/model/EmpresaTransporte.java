package co.edu.uniquindio.empresa.model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {
    private String nombre;
    private List<Propietario> propietarios;

    public EmpresaTransporte(String nombre) {
        this.nombre = nombre;
        this.propietarios = new ArrayList<>();
    }

    public void agregarPropietario(Propietario propietario) {
        propietarios.add(propietario);
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public String getNombre() {
        return nombre;
    }
}




