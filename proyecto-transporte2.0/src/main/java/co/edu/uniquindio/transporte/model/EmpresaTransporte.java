package co.edu.uniquindio.transporte.model;

import co.edu.uniquindio.transporte.services.IEmpresaTransportServices;
import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte implements IEmpresaTransportServices {

    private final List<Propietario> listaPropietarios = new ArrayList<>();
    private final List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private final List<VehiculoPasajero> listaVehiculosPasajero = new ArrayList<>();

    // === Propietarios ===
    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int edad) {
        if(obtenerPropietario(numeroIdentificacion) != null) return false;
        return listaPropietarios.add(new Propietario(nombre, numeroIdentificacion, email, numeroCelular, edad));
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) {
        for(Propietario p : listaPropietarios)
            if(p.getNumeroIdentificacion().equalsIgnoreCase(numeroIdentificacion)) return p;
        return null;
    }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) {
        Propietario p = obtenerPropietario(numeroIdentificacion);
        if(p != null) return listaPropietarios.remove(p);
        return false;
    }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual, String numeroIdentificacion, String email, String numeroCelular, int edad) {
        Propietario p = obtenerPropietario(numeroIdentificacionActual);
        if(p == null) return false;
        p.setNombre(nombre);
        p.setNumeroIdentificacion(numeroIdentificacion);
        p.setEmail(email);
        p.setNumeroCelular(numeroCelular);
        p.setEdad(edad);
        return true;
    }

    @Override
    public List<Propietario> listarPropietarios() { return listaPropietarios; }

    // === Vehículos de Carga ===
    @Override
    public boolean agregarVehiculoCarga(VehiculoCarga vehiculo) {
        if(obtenerVehiculoCarga(vehiculo.getPlaca()) != null) return false;
        return listaVehiculosCarga.add(vehiculo);
    }

    @Override
    public VehiculoCarga obtenerVehiculoCarga(String placa) {
        for(VehiculoCarga v : listaVehiculosCarga)
            if(v.getPlaca().equalsIgnoreCase(placa)) return v;
        return null;
    }

    @Override
    public boolean actualizarVehiculoCarga(String placaActual, String placa, String modelo, String marca, String color, double capacidadCarga, int numeroEjes) {
        VehiculoCarga v = obtenerVehiculoCarga(placaActual);
        if(v == null) return false;
        v.setPlaca(placa);
        v.setModelo(modelo);
        v.setMarca(marca);
        v.setColor(color);
        v.setCapacidadCarga(capacidadCarga);
        v.setNumeroEjes(numeroEjes);
        return true;
    }

    @Override
    public boolean eliminarVehiculoCarga(String placa) {
        VehiculoCarga v = obtenerVehiculoCarga(placa);
        if(v != null) return listaVehiculosCarga.remove(v);
        return false;
    }

    @Override
    public List<VehiculoCarga> listarVehiculosCarga() { return listaVehiculosCarga; }

    // === Vehículos de Pasajero ===
    @Override
    public boolean agregarVehiculoPasajero(VehiculoPasajero vehiculo) {
        if(obtenerVehiculoPasajero(vehiculo.getPlaca()) != null) return false;
        return listaVehiculosPasajero.add(vehiculo);
    }

    @Override
    public VehiculoPasajero obtenerVehiculoPasajero(String placa) {
        for(VehiculoPasajero v : listaVehiculosPasajero)
            if(v.getPlaca().equalsIgnoreCase(placa)) return v;
        return null;
    }

    @Override
    public boolean actualizarVehiculoPasajero(String placaActual, String placa, String modelo, String marca, String color, int numeroMaximoPasajeros) {
        VehiculoPasajero v = obtenerVehiculoPasajero(placaActual);
        if(v == null) return false;
        v.setPlaca(placa);
        v.setModelo(modelo);
        v.setMarca(marca);
        v.setColor(color);
        v.setNumeroMaximoPasajeros(numeroMaximoPasajeros);
        return true;
    }

    @Override
    public boolean eliminarVehiculoPasajero(String placa) {
        VehiculoPasajero v = obtenerVehiculoPasajero(placa);
        if(v != null) return listaVehiculosPasajero.remove(v);
        return false;
    }

    @Override
    public List<VehiculoPasajero> listarVehiculosPasajero() { return listaVehiculosPasajero; }

    // === Asociación y Consultas ===
    @Override
    public boolean asociarVehiculoAPropietario(String idPropietario, String placaVehiculo) {
        Propietario p = obtenerPropietario(idPropietario);
        if(p == null) return false;

        Vehiculo veh = obtenerVehiculoCarga(placaVehiculo);
        if(veh == null) veh = obtenerVehiculoPasajero(placaVehiculo);

        if(veh == null) return false;

        // Evitar duplicado silencioso (sin excepciones)
        for(Vehiculo v : p.getListaVehiculosAsociados())
            if(v.getPlaca().equalsIgnoreCase(veh.getPlaca())) return true;

        p.getListaVehiculosAsociados().add(veh);
        return true;
    }

    @Override
    public List<Propietario> propietariosPorPeso(double pesoMinimo) {
        List<Propietario> resultado = new ArrayList<>();
        for(Propietario p : listaPropietarios){
            for(Vehiculo v : p.getListaVehiculosAsociados()){
                if(v instanceof VehiculoCarga vehCarga && vehCarga.getCapacidadCarga() > pesoMinimo){
                    resultado.add(p);
                    break;
                }
            }
        }
        return resultado;
    }

    @Override
    public int pasajerosPorVehiculo(String placa) {
        VehiculoPasajero vp = obtenerVehiculoPasajero(placa);
        return (vp != null) ? vp.getNumeroMaximoPasajeros() : 0;
    }

    @Override
    public int contarPropietariosMayores40() {
        int cont = 0;
        for(Propietario p : listaPropietarios)
            if(p.getEdad() > 40) cont++;
        return cont;
    }

    // === Búsquedas ===
    @Override
    public String buscarPropietarioNombre(String nombre) {
        for(Propietario p : listaPropietarios)
            if(p.getNombre().equalsIgnoreCase(nombre)) return p.toString();
        return "";
    }

    @Override
    public String buscarVehiculoPorPlaca(String placa) {
        VehiculoCarga vc = obtenerVehiculoCarga(placa);
        if(vc != null) return "Vehiculo Carga: " + vc.toString();

        VehiculoPasajero vp = obtenerVehiculoPasajero(placa);
        if(vp != null) return "Vehiculo Pasajero: " + vp.toString();

        return "Vehiculo no encontrado";
    }
}
