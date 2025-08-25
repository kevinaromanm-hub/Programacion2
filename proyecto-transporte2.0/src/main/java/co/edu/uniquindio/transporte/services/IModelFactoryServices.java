package co.edu.uniquindio.transporte.services;

import co.edu.uniquindio.transporte.model.Propietario;
import co.edu.uniquindio.transporte.model.VehiculoCarga;
import co.edu.uniquindio.transporte.model.VehiculoPasajero;
import java.util.List;

public interface IModelFactoryServices extends IPropietarioServices {

    // Delegaciones de Empresa (fachada)
    boolean agregarVehiculoCarga(VehiculoCarga vehiculo);
    VehiculoCarga obtenerVehiculoCarga(String placa);
    boolean actualizarVehiculoCarga(String placaActual, String placa, String modelo, String marca, String color, double capacidadCarga, int numeroEjes);
    boolean eliminarVehiculoCarga(String placa);
    List<VehiculoCarga> listarVehiculosCarga();

    boolean agregarVehiculoPasajero(VehiculoPasajero vehiculo);
    VehiculoPasajero obtenerVehiculoPasajero(String placa);
    boolean actualizarVehiculoPasajero(String placaActual, String placa, String modelo, String marca, String color, int numeroMaximoPasajeros);
    boolean eliminarVehiculoPasajero(String placa);
    List<VehiculoPasajero> listarVehiculosPasajero();

    boolean asociarVehiculoAPropietario(String idPropietario, String placaVehiculo);
    List<Propietario> propietariosPorPeso(double pesoMinimo);
    int pasajerosPorVehiculo(String placa);
    int contarPropietariosMayores40();

    String buscarPropietarioNombre(String nombre);
    String buscarVehiculoPorPlaca(String placa);
}
