package co.edu.uniquindio.empresa.model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {
    private String nombre;
    private List<Propietario> propietarios = new ArrayList<>();

    public EmpresaTransporte(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public List<Propietario> getPropietarios() { return propietarios; }

    public void agregarPropietario(Propietario propietario) {
        propietarios.add(propietario);
    }
}








