package co.edu.uniquindio.transporte.model;

import co.edu.uniquindio.transporte.services.IEmpresaTransportServices;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte implements IEmpresaTransportServices {
    private List<Propietario> listaPropietarios = new ArrayList<>();
    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajero = new ArrayList<>();

    public List<Propietario> getListaPropietarios() { return listaPropietarios; }
    public List<VehiculoCarga> getListaVehiculosCarga() { return listaVehiculosCarga; }
    public List<VehiculoPasajero> getListaVehiculosPasajero() { return listaVehiculosPasajero; }

    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int edad){
        Propietario p = obtenerPropietario(numeroIdentificacion);
        if(p == null){
            listaPropietarios.add(new Propietario(nombre, numeroIdentificacion, email, numeroCelular, edad));
            return true;
        }
        return false;
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion){
        for(Propietario p: listaPropietarios){
            if(p.getNumeroIdentificacion().equals(numeroIdentificacion)) return p;
        }
        return null;
    }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion){
        Propietario p = obtenerPropietario(numeroIdentificacion);
        if(p != null) return listaPropietarios.remove(p);
        return false;
    }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual, String numeroIdentificacion, String email, String numeroCelular, int edad){
        Propietario p = obtenerPropietario(numeroIdentificacionActual);
        if(p != null){
            p.setNombre(nombre);
            p.setNumeroIdentificacion(numeroIdentificacion);
            p.setEmail(email);
            p.setNumeroCelular(numeroCelular);
            p.setEdad(edad);
            return true;
        }
        return false;
    }

    public String buscarVehiculoCargaPlaca(String placa){
        for(VehiculoCarga v: listaVehiculosCarga){
            if(v.getPlaca().equalsIgnoreCase(placa)) return v.toString();
        }
        return "";
    }

    public List<Propietario> propietariosPorPeso(double pesoMinimo){
        List<Propietario> resultado = new ArrayList<>();
        for(Propietario p: listaPropietarios){
            for(Vehiculo v: p.getListaVehiculosAsociados()){
                if(v instanceof VehiculoCarga && ((VehiculoCarga)v).getCapacidadCarga() > pesoMinimo){
                    resultado.add(p);
                    break;
                }
            }
        }
        return resultado;
    }

    public int pasajerosPorVehiculo(String placa){
        for(VehiculoPasajero v: listaVehiculosPasajero){
            if(v.getPlaca().equalsIgnoreCase(placa)) return v.getNumeroMaximoPasajeros();
        }
        return 0;
    }

    public int contarPropietariosMayores40(){
        int cont = 0;
        for(Propietario p: listaPropietarios) if(p.getEdad() > 40) cont++;
        return cont;
    }
}
